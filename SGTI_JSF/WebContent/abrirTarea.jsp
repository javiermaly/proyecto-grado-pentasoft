
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
				<td><h:outputText> Cedula o RUT del Cliente </h:outputText></td>
				<td><h:inputText id="cedrut" value="#{ClienteBean.cedRut}" required="true"></h:inputText></td>
				<td><h:commandButton  value="Aceptar" action="#{ClienteBean.buscarClienteAbrirTarea}"></h:commandButton></td>
			</tr>
		</table>
</h:form>
<h:form>	
		<h1>Abrir Tarea</h1>			
				<table border="1">
					<tr>
						<th>Cliente: </th><td><h:outputText value="#{ClienteSession.clienteSession.nombre_RazonSocial}" ></h:outputText></td>
					</tr>
					<tr>
						<th>Prioridad: </th>
						<td><h:selectOneRadio value="#{TareaBean.prioridad}">
							<f:selectItem itemValue="1" itemLabel="Alta"/>
							<f:selectItem itemValue="2" itemLabel="Media"/>
							<f:selectItem itemValue="3" itemLabel="Baja"/>
							</h:selectOneRadio>
						</td>
					</tr>					
					<tr>
						<th>Lugar: </th>
						<td><h:selectOneRadio value="#{TareaBean.esExterna}">
							<f:selectItem itemValue="false" itemLabel="Interna"/>
							<f:selectItem itemValue="true" itemLabel="Externa"/>
							</h:selectOneRadio>
						</td>
					</tr>
					<tr>
						<th>Tipo: </th>
						<td><h:selectOneMenu value="#{TareaBean.tipo}">
							<f:selectItem itemValue="2" itemLabel="Desarrollo"/>
							<f:selectItem itemValue="1" itemLabel="Soporte Técnico"/>
							</h:selectOneMenu>						
						</td>
					</tr>
					<tr>
						<th>Grupo Asingado: </th>
						<td><h:selectOneMenu value="#{TareaBean.grupoId}">
							<f:selectItem itemValue="1" itemLabel="soporte calle"/>
							<f:selectItem itemValue="2" itemLabel="soporte redes"/>
							</h:selectOneMenu>						
						</td>
					</tr>
					<tr>
						<th>Descripcion: </th>
						<td><h:inputTextarea rows="5" cols="25" value="#{TareaBean.descripcion}"/>						
						</td>
					</tr>
					<tr>
						<th>Observacion: </th>
						<td><h:inputTextarea rows="5" cols="25" value="#{TareaBean.observacion}"/>						
						</td>
					</tr>					
					<tr>
						<th>Fecha Comprometida(año/mes/dia)</th><td><h:inputText value="#{TareaBean.fechaComprometida}"><f:convertDateTime pattern="yyyy/MM/dd"/>
						</h:inputText> </td>
					</tr>
					<tr>
						<td><h:commandButton value="Aceptar" action="#{TareaBean.abrirTarea}"></h:commandButton></td>
					</tr>					
				</table>		
</h:form>

</f:view>
</body>
</html>
