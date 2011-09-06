<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<h:form>
	<h1>Buscar Cliente</h1>			
		<table border="1">
			<tr>
				<td><h:outputText> Cedula o RUT del Cliente </h:outputText></td>
				<td><h:inputText id="cedrut" value="#{ClienteBean.cedRut}" required="true"></h:inputText></td>
			</tr>
			<tr><h:commandButton style="margin: -20px 0 0 287px;" value="Aceptar" action="#{ClienteBean.buscarClienteAbrirTarea}"></h:commandButton>
			</tr>
		</table>
</h:form>






