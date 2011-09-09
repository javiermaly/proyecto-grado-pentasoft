
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>

	<style type="text/css" ></style>
	
	<link rel="stylesheet" type="text/css" href="estilo.css" media="screen" />

<f:subview id="header">

	<h:form rendered="#{UsuarioBean.perfil==1}">	
		<h1>ADMINISTRADOR</h1>
			<div id="menu">
            <ul id="nav">
 
            <li><span>Clientes</span>
                <ul>
                    <li><a href="buscarCliente.jsf">Buscar Cliente</a></li>
                    <li><a href="altaCliente.jsf">Alta Cliente</a></li>
                    <li><a href="#">Baja Cliente</a></li>
                    <li><a href="modificarCliente.jsf">Modificación Cliente</a></li>
                    <li><a href="#">Listado de Clientes</a></li>
               </ul>
            </li>
 
            <li><span>Usuarios</span>
                <ul>
                    <li><a href="#">Buscar Usuario </a></li>
                    <li><a href="#">Alta Usuario</a></li>
                    <li><a href="#">Baja Usuario</a></li>
                    <li><a href="#">Modificación Usuario</a></li>
                    <li><a href="#">Habilitación Usuario</a></li>
                    <li><a href="#">Listado de Usuarios</a></li>
               </ul>
            </li>            
            <li><span>Grupos</span>
 
                <ul>
                  <li><a href="#">Buscar Grupo</a></li>
                  <li><a href="#">Alta Grupo</a></li>
                  <li><a href="#">Baja Grupo</a></li>
                  <li><a href="#">Modificación Grupo</a></li>
                  <li><a href="#">Listado de Grupos</a></li>
               </ul>
            </li>
             <li><span>Listados</span>
 
                <ul>
                  <li><a href="#">listado</a></li>
            
               </ul>
            </li>
        </ul>
 
    </div>
	</h:form>
	<h:form rendered="#{UsuarioBean.perfil==2}">	
	<h1>ADMINISTRATIVO</h1>
			<div id="menu">
            <ul id="nav">
 
            <li><span>Clientes</span>
                <ul>
                    <li><a href="buscarCliente.jsf">Buscar Cliente</a></li>
                    <li><a href="altaCliente.jsf">Alta Cliente</a></li>
                    <li><a href="#">Baja Cliente</a></li>
                    <li><a href="modificarCliente.jsf">Modificación Cliente</a></li>
                    <li><a href="#">Listado de Clientes</a></li>
               </ul>
            </li>
 
            <li><span>Usuarios</span>
                <ul>
                    <li><a href="#">Buscar Usuario </a></li>
                </ul>
            </li>            
            <li><span>Tareas</span>
 
                <ul>
                  <li><a href="#">Buscar Tarea</a></li>
                  <li><a href="abrirTarea.jsf">Abrir Tarea</a></li>
                  <li><a href="#">Modificar Tarea</a></li>
                  <li><a href="#">Reabrir Tarea</a></li>
                  <li><a href="#">Cerrar Tarea</a></li>
               </ul>
            </li>
             <li><span>Listados</span>
 
                <ul>
                  <li><a href="#">listado</a></li>
            
               </ul>
            </li>
        </ul>
 
    </div>	
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