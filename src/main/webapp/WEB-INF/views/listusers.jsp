<%-- 
    Document   : listusers
    Created on : 5/jan/2016, 16:09:27
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
        	<h2>List of Users</h2>	
	<table>
		<tr>
			<td>ID</td><td>Name</td><td>Password</td><td>Email</td><td>Telephone</td><td>NIF</td><td>Address</td><td>Profile</td>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
			<td>${user.id}</td>
			<td>${user.name}</td>
                        <td>${user.password}</td>
                        <td>${user.email}</td>
                        <td>${user.telephone}</td>
                        <td>${user.nif}</td>
                        <td>${user.address}</td>
                        <td>${user.userProfile.getDesignation()}</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/newuser' />">Add new User</a>
    </body>
</html>
