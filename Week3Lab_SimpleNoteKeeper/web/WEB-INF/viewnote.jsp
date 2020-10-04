<%-- 
    Document   : viewnote
    Created on : Sep 30, 2020, 8:30:20 AM
    Author     : Nykke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <br>
        <h3>View Note</h3>
        <label>Title:</label><p ${note.title}></p>
        <label>Contents:</label><p ${note.notemsg}></p>
        <a href="editnote" value="edit">Edit<a/>
            
    </body>
</html>
