<%-- 
    Document   : newrepairstatus
    Created on : 15/jan/2016, 17:08:54
    Author     : Nuno
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Registration Form</h2>
 
	<form:form method="POST" modelAttribute="status">
		<form:input type="hidden" path="id" id="id"/>
		<table>
			<tr>
				<td><label for="designation">Designation </label> </td>
				<td><form:input path="designation" id="designation"/></td>
				<td><form:errors path="designation" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td colspan="3">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update"/>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register"/>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</form:form>
    </body>
</html>
