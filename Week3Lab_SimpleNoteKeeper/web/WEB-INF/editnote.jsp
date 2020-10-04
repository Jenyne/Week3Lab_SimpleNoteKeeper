<%-- 
    Document   : editnote
    Created on : Sep 30, 2020, 8:30:31 AM
    Author     : Nykke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <br>
        <h3>Editing Note!</h3>
        <form action="" method="post" autocomplete="off">
            <label>Title: </label><Input type="text" name="title"value=${title}><br><br>
            <label>Contents: </label><textarea name="notemsg" rows="4" cols="50">${notemsg}</textarea><br>
        <input type="submit" href="viewnote" value="Save">
        </form>
        <p${error}></p>
    </body>
</html>
