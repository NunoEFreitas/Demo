<%-- 
    Document   : mainadmin
    Created on : 13/jan/2016, 14:41:44
    Author     : Nuno
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Main Admin</h1>
        ${message}
        <br>
        <a href="newuser">Add User</a>
        <br>
        <a href="newmaterial">Add Material</a>
        <br>
        <a href="newprofile">Add Profile</a>
        <br>
        <a href="listprofiles">List Profiles</a>
        <br>
        <a href="listusers">List Users</a>
        <br>
        <a href="listmaterials">List Materials</a>
        <br>
    </body>
</html>
