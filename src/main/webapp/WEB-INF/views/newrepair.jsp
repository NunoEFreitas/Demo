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
				<td><label for="startDate">Start Date: </label> </td>
				<td><form:input path="startDate" id="startDate"/></td>
                                <td><form:errors path="startDate" cssClass="startDate"/></td>

		    </tr>
                    <tr>
				<td><label for="observation">Observations: </label> </td>
				<td><form:input path="observation" id="observation"/></td>
                                <td><form:errors path="observation" cssClass="error"/></td>

		    </tr>
                    <tr>
				<td><label for="serialNumber">Serial Number: </label> </td>
				<td><form:input path="serialNumber" id="serialNumber"/></td>
                                <td><form:errors path="serialNumber" cssClass="error"/></td>

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
