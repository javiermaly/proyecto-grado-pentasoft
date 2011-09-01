package stateless;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import beans.Usuario;




@Stateless
@SuppressWarnings(value="unchecked")
public class ManagerU implements UsuarioRemote{

        @PersistenceContext(unitName ="SGTI_JPA")
        private EntityManager em;
        
         
        private List<Usuario> listaUsuarios;
        
        
        public boolean agregarUsuario(Usuario u){               
                try {                   
                        em.persist(u);                  
                        return true;

                } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                }         
        }
        
        public boolean eliminarUsuario(long ced){
                Usuario u;
                u = encontrarUsuario(ced);              
                if (u!=null){                   
                        try{
                                em.remove(u);
                                return true;
                        }catch(Exception e ){
                                e.printStackTrace();
                                return false;
                        }
                }
                else
                        return false;
        }               
        
        public List<Usuario> listarUsuarios() {         
                List<Usuario> todos= em.createNamedQuery("todosUsuarios").getResultList();
                return todos;
        }
        
        public Usuario encontrarUsuario(long ced){
                Usuario u = em.find(Usuario.class, ced);
                return u;
        }
        
        public boolean actualizarUsuario(Usuario u){
                try{
                        em.merge(u);
                        return true;
                }catch(Exception e){
                        e.printStackTrace();
                        return false;
                }
        }
        
        public Usuario login(long cedula, String pwd){
        	Usuario u = em.find(Usuario.class, cedula);
        	if (u.getPwd().equals(pwd)){
        		System.out.println("usuario encontrado");
        		return u;
        	}
        	else{
        		System.out.println("no valido");
        		return null;
        	}
        	
        	
        }
        
                
}