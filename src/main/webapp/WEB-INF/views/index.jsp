<%-- 
    Document   : index
    Created on : 4/jan/2016, 11:48:18
    Author     : Nuno
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Repair Management</title>
    </head>
    <body>
        <img src="<c:url value="resources/Capturar.png" />" />
        <h1>welcome</h1>
        <a href="new">Add Employee</a>
        <br>
        <a href="list">List Employees</a>
        <br>
        <a href="newUser">Add User</a>
        <br>
        <a href="listUsers">List Users</a>
        <br>
        <a href="newProfile">Add Profile</a>
    </body>
</html>
