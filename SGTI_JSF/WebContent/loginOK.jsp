<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exito</title>
</head>
<body>
<f:view>
	<h:form>	
		
		<h:panelGrid columns="1" rendered="#{LoginBean.perfil==1}">
			<h:outputText value="Logueado Correctamente como ADMINISTRADOR!!!"></h:outputText>
		</h:panelGrid>
		
		<h:panelGrid columns="1" rendered="#{LoginBean.perfil==2}">
			<h:outputText value="Logueado Correctamente como ADMINISTRATIVO!!!"></h:outputText>
		</h:panelGrid>
		<h:panelGrid columns="1" rendered="#{LoginBean.perfil==3}">
			<h:outputText value="Logueado Correctamente como ENCARGADO!!!"></h:outputText>
		</h:panelGrid>
		<h:panelGrid columns="1" rendered="#{LoginBean.perfil==4}">
			<h:outputText value="Logueado Correctamente como TECNICO!!!"></h:outputText>
		</h:panelGrid>
		
	</h:form>
</f:view>
</body>
</html>