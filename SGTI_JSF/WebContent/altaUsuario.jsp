
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
	<f:subview id="header">
		<%@include file="header.jsp"%>
	</f:subview>


	<h:form>
		<h1>Alta de Usuario</h1>
		<table>
			<tr>
				<td><h:outputText>Cédula</h:outputText></td>
				<td><h:inputText id="cedula" value="#{UsuariosBean.cedula}"
						required="true"></h:inputText></td>
				<td><h:commandButton value="Aceptar"
						action="#{UsuariosBean.buscarUsuario}"></h:commandButton></td>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{UsuariosBean.nombreRazSocial == null }">
		<table border="1">
			<tr>
				<th>Es empresa: </th>
				<td><h:selectOneRadio value="#{UsuariosBean.empresa}">
					<f:selectItem itemValue="true" itemLabel="Si"/>
					<f:selectItem itemValue="false" itemLabel="No"/>					
					</h:selectOneRadio>
				</td>
			</tr>
			<tr>
				<th>Cédula / RUT</th>
				<td>
				<h:inputText id="cedrut" value="#{UsuariosBean.cedRut}" ></h:inputText>
				</td>
			</tr>

			<tr>
				<th>Nombre Completo / Razón Social:</th>
				<td><h:inputText value="#{UsuariosBean.nombreRazSocial}"></h:inputText>
				</td>
			</tr>
			<tr>
				<th>Dirección:</th>
				<td><h:inputText value="#{UsuariosBean.direccion}"></h:inputText>
				</td>
			</tr>
			<tr>
				<th>Teléfono:</th>
				<td><h:inputText value="#{UsuariosBean.telefono}"></h:inputText>
				</td>
			</tr>
			<tr>
				<th>Fecha de Fin de Garantía (año/mes/dia):</th>

				<td><h:inputText value="#{UsuariosBean.fechaFinGarantia}">
						<f:convertDateTime pattern="yyyy/MM/dd" />
					</h:inputText>
				</td>
			</tr>
			<tr>
				<td><h:commandButton value="Aceptar"
						action="#{UsuariosBean.altaCliente}"></h:commandButton></td>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{UsuariosBean.evento==1 }">
		<table border="1">
			<tr>
				<th> Cliente ingresado con exito!!!</th>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{UsuariosBean.evento==2}">
		<table border="1">
			<tr>
				<th> Error al ingresarlo!!!</th>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{UsuariosBean.evento==4}">
		<table border="1">
			<tr>
				<th> Cliente ya existe!!!</th>
			</tr>
		</table>
	</h:form>

</f:view>
</body>
</html>
