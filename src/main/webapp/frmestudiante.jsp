<%-- 
    Document   : frmestudiante
    Created on : 14 may. de 2024, 22:49:03
    Author     : jhomara
--%>

<%@page import="com.emergentes.modelo.Estudiante"%>
<%
    Estudiante estudiante = (Estudiante) request.getAttribute("estudiante");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar / Editar Estudiante</title>
    </head>
    <body>
        <h1>Nuevo Registro</h1>
        <form action="EstudianteController" method="POST">
            <input type="hidden" name="id" value="${estudiante.id}" />
            <table>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="${estudiante.nombre}" /></td>
                </tr>

                <tr>
                    <td>Apellido</td>
                    <td><input type="text" name="apellido" value="${estudiante.apellido}" /></td>
                </tr>

                <tr>
                    <td>Seminario</td>
                    <td>
                        <select id="seminario" name="seminario">
                            <option value="Java" ${estudiante.seminario == 'Java' ? 'selected' : ''}>Java</option>
                            <option value="Php" ${estudiante.seminario == 'Php' ? 'selected' : ''}>Php</option>
                            <option value="Python" ${estudiante.seminario == 'Python' ? 'selected' : ''}>Python</option>
                        </select>
                    </td>
                    </td>
                </tr>

                <tr>
                    <td>Confirmado</td>
                    <td>
                        <select id="confirmado" name="confirmado">
                            <option value="si" ${estudiante.confirmado == 'si' ? 'selected' : ''}>si</option>
                            <option value="no" ${estudiante.confirmado == 'no' ? 'selected' : ''}>no</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td>Fecha</td>
                    <td><input type="date" name="fecha" value="${estudiante.fecha}" /></td>
                </tr>

                <tr>
                    <td></td>
                    <td><input type="submit" value="Guardar" /></td>
                </tr>

            </table>
        </form>
    </body>
</html>
