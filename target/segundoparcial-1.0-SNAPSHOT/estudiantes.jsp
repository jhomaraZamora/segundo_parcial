<%-- 
    Document   : estudiantes
    Created on : 14 may. de 2024, 22:34:52
    Author     : jhomara
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="com.emergentes.modelo.Estudiante"%>

<%@page import="java.util.List"%>
<%
    List<Estudiante> estudiantes = (List<Estudiante>) request.getAttribute("estudiantes");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Estudiantes</title>
    </head>
    <body>
        <fieldset>
            <h3 style="text-align: center;">PRIMER PARCIAL</h3>
            <p style="text-align: center;"><strong>Nombre:</strong> Jhomara Quecaña Zamora</p>
            <p style="text-align: center;"><strong>Carnet:</strong> 10088531</p>
        </fieldset> 
        <br>
        <h1>Registro Dia del Internet</h1>
        <p><a href="EstudianteController?action=add">Nuevo</a></p>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Seminario</th>
                <th>Confirmado</th>
                <th>Fecha Inscripción</th>
                <th></th>
                <th></th>
            </tr>

            <c:forEach var="item" items="${estudiantes}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.nombre}</td>
                    <td>${item.apellido}</td>
                    <td>${item.seminario}</td>
                    <td>
                        <input type="checkbox" name="confirmado" ${item.confirmado== 'si' ? 'checked' : ''} />
                    </td>

                    <td>${item.fecha}</td>
                    <td>
                        <a href="EstudianteController?action=edit&id=${item.id}">Editar</a>
                    </td>
                    <td>
                        <a href="EstudianteController?action=delete&id=${item.id}">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>



        </table>
    </body>
</html>
