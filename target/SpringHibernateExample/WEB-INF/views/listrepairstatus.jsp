<%-- 
    Document   : listrepairstatus
    Created on : 15/jan/2016, 17:09:08
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
	<h2>List of Repair Status</h2>	
	<table>
		<tr>
			<td>ID</td><td>Description</td><td>Edit</td><td>Delete</td>
		</tr>
		<c:forEach items="${status}" var="status">
			<tr>
			<td>${status.id}</td>
			<td>${status.designation}</td>
                        <td><a href="<c:url value='/edit-${status.id}-status' />">Edit</a></td>
			<td><a href="<c:url value='/delete-${status.id}-status' />">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/newrepairstatus' />">Add new Repair Status</a>
    </body>
</html>
