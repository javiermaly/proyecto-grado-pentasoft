
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
	<f:subview id="header">
		<%@include file="header.jsp"%>
	</f:subview>
	
	
	<h:form>
		<h1>Alta de Cliente</h1>
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
	<h:form rendered="#{ClienteBean.nombreRazSocial == null }">
		<table border="1">
			<tr>
			<h:inputText id="cedrut" required="true" value="#{ClienteBean.cedRut}"></h:inputText>
			
				<th>Nombre Completo / Razón Social:</th>
				<td><h:inputText 
						value="#{ClienteBean.nombreRazSocial}"></h:inputText>
				</td>
			</tr>
			<tr>
				<th>Dirección:</th>
				<td><h:inputText value="#{ClienteBean.direccion}"></h:inputText></td>
			</tr>
			<tr>
				<th>Teléfono:</th>
				<td><h:inputText value="#{ClienteBean.telefono}"></h:inputText></td>
			</tr>
			<tr>
				<th>Fecha de Fin de Garantía (año/mes/dia):</th>
				
				<td><h:inputText value="#{ClienteBean.fechaFinGarantia}">
						<f:convertDateTime pattern="yyyy/MM/dd" />
					</h:inputText></td>
			</tr>
			<tr>
				<td><h:commandButton value="Aceptar"
						action="#{ClienteBean.altaCliente}"></h:commandButton>
				</td>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{ClienteBean.nombreRazSocial != null }">
		<f:verbatim>CLIENTE DADO DE ALTA</f:verbatim>
	</h:form>

</f:view>
</body>
</html>
