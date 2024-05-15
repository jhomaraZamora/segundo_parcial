<%-- 
    Document   : blogs
    Created on : 14 may. de 2024, 12:35:36
    Author     : jhomara
--%>

<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Blog"%>
<%
    List<Blog> b = (List<Blog>) request.getAttribute("blogs");
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Blogs</title>
    </head>
    <body>
        <h1>Listado de Avisos</h1>
        <p><a href="BlogController?action=add">Nuevo</a></p>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Fecha</th>
                <th>Titulo</th>
                <th>Contenido</th>
                <th></th>
                <th></th>
            </tr>

            <c:forEach var="item" items="${b}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.fecha}</td>
                    <td>${item.titulo}</td>
                    <td>${item.contenido}</td>
                    <td>
                        <a href="BlogController?action=edit&id=${item.id}">Editar</a>
                    </td>
                    <td>
                        <a href="BlogController?action=delete&id=${item.id}">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>



        </table>
    </body>
</html>
