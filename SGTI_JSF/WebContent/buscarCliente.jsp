<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<h:form>
	<h1>Buscar Cliente</h1>			
		<table>
			<tr>
				<td><h:outputText> Cedula o RUT del Cliente </h:outputText></td>
				<td><h:inputText id="cedrut" value="#{ClienteBean.cedRut}" required="true"></h:inputText></td>
				<td><h:commandButton  value="Aceptar" action="#{ClienteBean.buscarClienteAbrirTarea}"></h:commandButton></td>
			</tr>
		</table>
</h:form>






