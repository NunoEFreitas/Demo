<%-- 
    Document   : listclients
    Created on : 11/jan/2016, 11:09:03
    Author     : Nuno
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
                	<h2>List of Clients</h2>	
	<table>
		<tr>
                    <td>ID</td><td>Name</td><td>Email</td><td>Telephone</td>
                    <td>Edit</td><td>Delete</td>
		</tr>
		<c:forEach items="${client}" var="client">
			<tr>
			<td>${client.id}</td>
                        <td>${client.name}</td>
                        <td>${client.email}</td>
                        <td>${client.telephone}</td>
                        <td><a href="<c:url value='/edit-${client.id}-client' />">Edit</a></td>
			<td><a href="<c:url value='/delete-${client.id}-client' />">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/newclient' />">Add new Client</a>
    </body>
</html>
