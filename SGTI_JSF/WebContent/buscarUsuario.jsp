<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>



<f:view>
	<f:subview id="header">
		<%@include file="header.jsp"%>
	</f:subview>
	<h:form>
		<h1>Buscar Usuario</h1>
		<table>
			<tr>
				<td><h:outputText>Cédula del Usuario </h:outputText>
				</td>
				<td><h:inputText id="cedula" value="#{UsuariosBean.cedula}"
						required="true"></h:inputText>
				</td>
				<td><h:commandButton value="Aceptar"
						action="#{UsuariosBean.buscarUsuario}"></h:commandButton>
				</td>
			</tr>
		</table>
	</h:form>

	<h:form rendered="#{UsuariosBean.evento==4}">
		<table border="1">
			<tr>
				<th>Nombre: </th>
				<th><h:outputText value="#{usuRequest.nombre}"></h:outputText></th>
			</tr>
			<tr>
				<th>Celular: </th>
				<th><h:outputText value="#{usuRequest.celular}"></h:outputText></th>
			</tr>
			
		</table>
	</h:form>
	<h:form rendered="#{UsuariosBean.evento==3}">
		<table border="1">
			<tr>
				<th> Usuario no existe!!!</th>
			</tr>
		</table>
	</h:form>

</f:view>
</body>
</html>



