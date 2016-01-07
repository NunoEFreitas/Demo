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
			<td>ID</td><td>Description</td><td>Edit</td><td>Delete</td>
		</tr>
		<c:forEach items="${profiles}" var="profile">
			<tr>
			<td>${profile.id}</td>
			<td>${profile.designation}</td>
                        <td><a href="<c:url value='/edit-${profile.id}-userProfile' />">Edit</a></td>
			<td><a href="<c:url value='/delete-${profile.id}-userProfile' />">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/newprofile' />">Add new Profile</a>
    </body>
</html>
