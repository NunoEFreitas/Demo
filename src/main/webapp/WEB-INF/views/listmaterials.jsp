<%-- 
    Document   : listmaterials
    Created on : 14/jan/2016, 13:51:17
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
                    <td>ID</td><td>Designation</td><td>Buy Price</td><td>Sell Price</td>
                    <td>Edit</td><td>Delete</td>
		</tr>
		<c:forEach items="${material}" var="material">
			<tr>
			<td>${material.id}</td>
                        <td>${material.designation}</td>
                        <td>${material.buyPrice}</td>
                        <td>${material.sellPrice}</td>
                        <td><a href="<c:url value='/edit-${material.id}-material' />">Edit</a></td>
			<td><a href="<c:url value='/delete-${material.id}-material' />">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/newmaterial' />">Add new Material</a>
    </body>
</html>

