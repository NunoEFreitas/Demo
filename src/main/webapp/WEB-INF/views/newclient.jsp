<%-- 
    Document   : newclient
    Created on : 11/jan/2016, 11:08:42
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
 
	<form:form method="POST" modelAttribute="client">
		<form:input type="hidden" path="id" id="id"/>
		<table>
			<tr>
				<td><label for="name">Name: </label> </td>
				<td><form:input path="name" id="name"/></td>
                                <td><form:errors path="name" cssClass="error"/></td>

		    </tr>
                    <tr>
				<td><label for="email">Email: </label> </td>
				<td><form:input path="email" id="email"/></td>
                                <td><form:errors path="email" cssClass="error"/></td>

		    </tr>
                    <tr>
				<td><label for="address">Address: </label> </td>
				<td><form:input path="address" id="address"/></td>
                                <td><form:errors path="address" cssClass="error"/></td>

		    </tr>
                    <tr>
				<td><label for="telephone">Telephone: </label> </td>
				<td><form:input path="telephone" id="telephone"/></td>
                                <td><form:errors path="telephone" cssClass="error"/></td>

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
                ${error}
	<br/>
	<br/>
    </body>
</html>
