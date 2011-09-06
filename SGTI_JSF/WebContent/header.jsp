
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
	<script>
		function cambiarClase(obj,clase){
			document.getElementById(obj).className=clase;
		}
	</script>
<!--	<style type="text/css">@import url("estilo.css");</style> -->
	
 	<link rel="stylesheet" type="text/css" href="estilo.css" media="screen" /> 

<f:subview id="header">

	<h:form rendered="#{UsuarioBean.perfil==1}">	
		<h1>ADMINISTRADOR</h1>
			<div style="width: 150px">
				<ul class="menu">
					<li onMouseOver="cambiarClase('submenu1','mostrar');"
						onMouseOut="cambiarClase('submenu1','');"><h:outputLink ><f:verbatim> TAREAS</f:verbatim></h:outputLink> 
						<ul id="submenu1">
							<li><h:outputLink value="error.jsp"><f:verbatim> Abrir Tarea</f:verbatim></h:outputLink> 
							</li>
							<li><h:outputLink value="error.jsp"><f:verbatim> Cerrar Tarea</f:verbatim></h:outputLink> 
							</li>
						</ul></li>
					<li><a href="#">Item 2</a>
					</li>
					<li onMouseOver="cambiarClase('submenu3','mostrar');"
						onMouseOut="cambiarClase('submenu3','');"><a href="#">Item
							3</a>
						<ul id='submenu3'>
							<li><a href="#">Item 3.1</a>
							</li>
							<li><a href="#">Item 3.2</a>
							</li>
							<li><a href="#">Item 3.3</a>
							</li>
							<li><a href="#">Item 3.4</a>
							</li>
						</ul></li>
					<li><a href="#">Item 4</a>
					</li>
				</ul>
			</div>
				
	</h:form>
	<h:form rendered="#{UsuarioBean.perfil==2}">	
		<h1>ADMINISTRATIVO</h1>			
				<table border="1">					
					<tr>
						<th><h:commandLink onfocus="sarasaaa">Abrir Tarea</h:commandLink></th>
					</tr>
					<tr>
						<th>Cerrar Tareas</th>
					</tr>
					<tr>
						<th>Buscar Cliente</th>
					</tr>
					<tr>
						<th>Buscar Técnico</th>
					</tr>					
				</table>		
	</h:form>
	<h:form rendered="#{UsuarioBean.perfil==3}">	
		<h1>ENCARGADO</h1>			
				<table border="1">
					<tr>
						<th><h:commandLink onfocus="sarasaaa">Listar Tareas</h:commandLink></th>
					</tr>
					<tr>
						<th>Asignar Tareas</th>
					</tr>
					<tr>
						<th>Derivar Tareas</th>
					</tr>
					<tr>
						<th>Buscar Cliente</th>
					</tr>
					<tr>
						<th>Buscar Técnico</th>
					</tr>				
				</table>		
	</h:form>
	<h:form rendered="#{UsuarioBean.perfil==4}">	
		<h1>TECNICO</h1>			
				<table border="1">
					<tr>
						<th><h:commandLink onfocus="sarasaaa">Tomar Tarea</h:commandLink></th>
					</tr>
					<tr>
						<th>Finalizar Tarea</th>
					</tr>
					<tr>
						<th>Buscar Cliente</th>
					</tr>					
				</table>		
	</h:form>
</f:subview>
</head>
<body>