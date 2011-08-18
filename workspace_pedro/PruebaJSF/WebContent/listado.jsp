<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<f:view>
<head>
<title><h:outputText value="Listado de Personas" /></title>
</head>
	<body>
		<h:outputText value="listado de personas" />
		<p>
			<h:form>
				<h:dataTable border="2" value="#{PersonaBean.listarPersonas}" var="Persona">
					<h:column>
					 	<f:facet name="header">
            				<h:outputText value="nombre"></h:outputText>
         				</f:facet>
						<h:outputText value="#{Persona.nombre}" />						
					</h:column>	
					<h:column>
					 	<f:facet name="header">
            				<h:outputText value="cedula"></h:outputText>
         				</f:facet>
						<h:outputText value="#{Persona.cedula}" />						
					</h:column>
					<h:column>
					 	<f:facet name="header">
            				<h:outputText value="direccion"></h:outputText>
         				</f:facet>
						<h:outputText value="#{Persona.direccion}" />						
					</h:column>	
					 <h:column>
        			 <h:form>
            			<h:commandButton action="#{PersonaBean.eliminarPersona}" value="Borrar"></h:commandButton>
         			</h:form>
      				</h:column>										
				</h:dataTable>
			</h:form>
	</body>
</f:view>
</html>