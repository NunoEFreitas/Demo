<%-- 
    Document   : mainstore
    Created on : 13/jan/2016, 14:41:34
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
        <h1>Main Store</h1>
        <br>
        ${message}
        <a href="newrepair">Add Repair</a>
        <br>
        <a href="newclient">Add Client</a>
        <br>
        <a href="newmaterial">Add Material</a>
        <br>
        <a href="listrepairs">List Repairs</a>
        <br>
        <a href="listclients">List Clients</a>
        <br>
        <a href="listmaterials">List Materials</a>
        <br>
        <a href="statistics">Statistics</a>
        <br>
    </body>
</html>
