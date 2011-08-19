package stateless;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import beans.Cliente;




@Stateless
public class ManagerC implements ClienteRemote {

        @PersistenceContext(unitName = "SGTI_JPA")
        private EntityManager em;       
                
        public boolean agregarCliente(Cliente c){               
                        
                try {
                        em.persist(c);  
                        return true;
                        
                } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                }
        }
        
        public boolean eliminarCliente(int ced){
                Cliente c;
                c = encontrarCliente(ced);              
                if (c!=null){   
                        try{
                                em.remove(c);
                                return true;
                        }
                        catch(Exception e){
                                e.printStackTrace();
                                return false;
                        }
                        
                }else{
                        return false;
                }               
        }               
        
        public List<Cliente> listarClientes() {         
                @SuppressWarnings(value="unchecked")//para que deje de mostrar advertencia List need unchecked convertion
                List<Cliente> listaClientes = em.createNamedQuery("todosClientes").getResultList();
                return listaClientes;
        }
                
        public Cliente encontrarCliente(int ced){
                Cliente p = em.find(Cliente.class, ced);
                return p;
        }
        
        public Cliente actualizarCliente(Cliente u){
                u = em.merge(u);
                return u;       
        }
        
}