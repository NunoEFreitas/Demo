<%-- 
    Document   : registeruser
    Created on : 30/dez/2015, 16:04:13
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
 
	<form:form method="POST" modelAttribute="user">
		<form:input type="hidden" path="id" id="id"/>
		<table>
			<tr>
				<td><label for="name">Name: </label> </td>
				<td><form:input path="name" id="name"/></td>
                                <td><form:errors path="name" cssClass="error"/></td>

		    </tr>
                    <tr>
				<td><label for="password">Password: </label> </td>
				<td><form:input path="password" id="password"/></td>
                                <td><form:errors path="password" cssClass="error"/></td>

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
				<td><label for="nif">Nif: </label> </td>
				<td><form:input path="nif" id="nif"/></td>
                                <td><form:errors path="nif" cssClass="error"/></td>

		    </tr>
                    <tr>
                    <td><label for="userProfile">Profile: </label> </td>
                    <td>
                    <form:select path="userProfile.id" id="userProfile.id">
                            <c:forEach items="${uplist}" var="upl">
                                 <c:choose>
                                    <c:when test="${upl.id eq userProfile.id}">
                                    <option value="${upl.id}" selected="true">${upl.designation}</option>
                                    </c:when>
                                    <c:otherwise>
                                    <option value="${upl.id}">${upl.designation}</option>
                                    </c:otherwise>
                                </c:choose>
                                    </c:forEach>
                            </form:select>
                    </td>
		    </tr>
                    
                    
                    <c:choose>
                        <c:when test="${upl.id eq userProfile.id}">
                            <option value="${upl.id}" selected="true">${upl.designation}</option>
                        </c:when>
                    <c:otherwise>
                        <option value="${upl.id}">${upl.designation}</option>
                    </c:otherwise>
                    </c:choose>
		
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
