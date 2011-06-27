<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Eliminar</title>
</head>
<body>
<f:view>
	<h:form>	
		<h3>Ingrese la c&eacute;dula de la persona a eliminar</h3>
		<table>	
				<tr>
					<td>Cedula: </td><td><h:inputText id="cedula" value="#{PersonaBean.cedula}" required="true"></h:inputText></td>
				</tr>
				<tr>	
					<td><h:commandButton value="Eliminar" action="#{PersonaBean.eliminarPersona}"></h:commandButton></td>
				</tr>
		</table>
	</h:form>
</f:view>
</body>
</html>