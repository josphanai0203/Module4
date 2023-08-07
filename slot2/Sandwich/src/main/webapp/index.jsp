<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/save">
    <input type="checkbox" style="margin-right: 5px" name="condiments" value="Lettuce"> Lettuce
    <input type="checkbox" style="margin-right: 5px" name="condiments" value="Tomato"> Tomato
    <input type="checkbox" style="margin-right: 5px" name="condiments" value="Mustard"> Mustard
    <input type="checkbox" style="margin-right: 5px" name="condiments" value="Sprouts"> Sprouts
    <br>
    <input type="submit" value="save">
    <br>
    <span>Result : ${result}</span>
</form>
</body>
</html>