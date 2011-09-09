<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>



<f:view>
	<f:subview id="header">
		<%@include file="header.jsp"%>
	</f:subview>
	<h:form>
		<h1>Buscar Cliente</h1>
		<table>
			<tr>
				<td><h:outputText> Cedula o RUT del Cliente </h:outputText>
				</td>
				<td><h:inputText id="cedrut" value="#{ClienteBean.cedRut}"
						required="true"></h:inputText>
				</td>
				<td><h:commandButton value="Aceptar"
						action="#{ClienteBean.buscarCliente}"></h:commandButton>
				</td>
			</tr>
		</table>
	</h:form>

	<h:form>
		<table border="1">
			<tr>
				<th>Empresa: </th>
				<th><h:outputText value="#{ClienteSession.clienteSession.empresa}"></h:outputText></th>
			</tr>
			<tr>
				<th>Nombre o Razón Social: </th>
				<th><h:outputText value="#{ClienteSession.clienteSession.nombre_RazonSocial}"></h:outputText></th>
			</tr>
			<tr>
				<th>Telefono</th>
				<th><h:outputText value="#{ClienteSession.clienteSession.telefono}"></h:outputText></th>
			</tr>
 			<tr> 
				<th>Fecha fin de Garantia</th>
  				<th><h:outputText value="#{ClienteSession.clienteSession.fechaFinGarantia}"><f:convertDateTime type="date"/></h:outputText></th> 
 			</tr>
 			<tr>
				<td><h:commandButton value="Aceptar"
						action="#{ClienteBean.bajaCliente}"></h:commandButton></td>
			</tr> 
		</table>
		
	</h:form>


</f:view>
</body>
</html>



