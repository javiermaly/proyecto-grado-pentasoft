
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
<f:subview id="buscarCliente">
	<%@include file="header.jsp"%>	
	<%@include file="buscarCliente.jsp"%>	
</f:subview>

<h:form>	
		<h1>Abrir Tarea</h1>			
				<table border="1">
					<tr>
						<th>Tarea</th><th> ----</th>
					</tr>
					<tr>
						<th>Cliente</th><th><h:outputText value="#{ClienteSession.clienteSession.cedRut}" ></h:outputText></th>
					</tr>
					<tr>
						<th>Tecnico</th><th> ----</th>
					</tr>					
				</table>		
</h:form>

</f:view>
</body>
</html>
