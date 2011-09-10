<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>



<f:view>
	<f:subview id="header">
		<%@include file="header.jsp"%>
	</f:subview>
	<h:form>
		<h1>Eliminar Cliente</h1>
		<table>
			<tr>
				<td><h:outputText> Cedula o RUT del Cliente </h:outputText>
				</td>
				<td><h:inputText id="cedrut" value="#{ClienteBean.cedRut}"
						required="true"></h:inputText>
				</td>
				<td><h:commandButton value="Aceptar" action="#{ClienteBean.buscarCliente}"></h:commandButton>
				</td>
			</tr>
		</table>
	</h:form>

	<h:form rendered="#{ClienteBean.evento==4}">
		<table border="1">
			<tr>
				<th>Empresa: </th>
				<td><h:outputText value="#{ClienteSession.clienteSession.empresa}"></h:outputText></td>
				</tr>
			<tr>
				<th>Nombre o Raz�n Social: </th>
				<td><h:outputText value="#{ClienteSession.clienteSession.nombre_RazonSocial}"></h:outputText></td>
			</tr>
			<tr>
				<th>Telefono</th>
				<td><h:outputText value="#{ClienteSession.clienteSession.telefono}"></h:outputText></td>
			</tr>
 			<tr> 
				<th>Fecha fin de Garantia</th>
  				<td><h:outputText rendered="#{ClienteSession.fechaGarant!=null}" value="#{ClienteSession.fechaGarant}">
  					<f:convertDateTime pattern="yyyy/MM/dd"/>
  					</h:outputText>
  				</td> 
 			</tr>
 			<tr>
				<td><h:commandButton value="Eliminar" action="#{ClienteBean.bajaCliente}"></h:commandButton></td>
			</tr> 
		</table>
		
	</h:form>
	<h:form rendered="#{ClienteBean.evento==1}">
		<table border="1">
			<tr>
				<th> Cliente Eliminado con exito!!!</th>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{ClienteBean.evento==2}">
		<table border="1">
			<tr>
				<th> Error al eliminar el Cliente!!!</th>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{ClienteBean.evento==3}">
		<table border="1">
			<tr>
				<th> Cliente no existe!!!</th>
			</tr>
		</table>
	</h:form>


</f:view>
</body>
</html>



