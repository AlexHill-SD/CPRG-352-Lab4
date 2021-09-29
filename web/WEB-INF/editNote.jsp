<%-- 
    Document   : editNote
    Created on : 29-Sep-2021, 16:03:46
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

        <h2>Edit your note</h2>


        <form action="note?viewNote" method="POST">
            <label for="note_title">Title:</label>
            <input type="text" name="note_title" id="note_title" value="${note_title}">
            <br>
            <br>
            <label for="note_contents">Contents:</label>
            <br>
            <textarea name="note_contents" id="" cols="50" rows="12">${note_contents}</textarea>
            <br>
            <br>
            <button type="submit">Save Note</button>
        </form>
    </body>
</html>
