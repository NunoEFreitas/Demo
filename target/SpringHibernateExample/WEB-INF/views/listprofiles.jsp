<%-- 
    Document   : listprofiles
    Created on : 5/jan/2016, 16:05:18
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
	<h2>List of Profiles</h2>	
	<table>
		<tr>
			<td>ID</td><td>Description</td>
		</tr>
		<c:forEach items="${profiles}" var="profile">
			<tr>
			<td>${profile.id}</td>
			<td>${profile.designation}</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/newprofile' />">Add new Profile</a>
    </body>
</html>
