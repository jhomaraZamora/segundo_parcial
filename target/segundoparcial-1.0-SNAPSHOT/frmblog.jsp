<%-- 
    Document   : frmblog
    Created on : 14 may. de 2024, 12:38:24
    Author     : jhomara
--%>

<%@page import="com.emergentes.modelo.Blog"%>
<%
    Blog b =(Blog) request.getAttribute("blog");
    System.out.println(b);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar / Editar Blog</title>
    </head>
    <body>
        <h1>Nuevo Registro</h1>
        <form action="BlogController" method="POST">
            <input type="hidden" name="id" value="${b.fecha}" />
            <table>
                
                <tr>
                    <td>Fecha</td>
                    <td><input type="date" name="fecha" value="${b.fecha}" /></td>
                </tr>
                
                <tr>
                    <td>Titulo</td>
                    <td><input type="text" name="titulo" value="${b.titulo}" /></td>
                </tr>
                
                <tr>
                    <td>Contenido</td>
                    <td><input type="text" name="contenido" value="${b.contenido}" /></td>
                </tr>
                
                <tr>
                    <td></td>
                    <td><input type="submit" value="Guardar" /></td>
                </tr>
                
            </table>
        </form>
    </body>
</html>
