<%-- 
    Document   : viewNote
    Created on : 29-Sep-2021, 16:03:38
    Author     : BritishWaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>

        <div>
            <h2>Displaying your note</h2>

            <label>Title:</label> <span>${note_title}</span>
            <br>
            <br>
    
            <label>Contents:</label>
            <br>
            <span>${note_contents}</span>
            <br>
            <br>
            <a href="note?editNote">Edit Note</a>
        </div>        
    </body>
</html>
