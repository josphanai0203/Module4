<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/Calculator" method="get">
    <input type="number" name="num1">
    <input type="number" name="num2">
    <br>
    <input type="submit" value="add" name="action">
    <input type="submit" value="sub" name="action">
    <input type="submit" value="mul" name="action">
    <input type="submit" value="div" name="action">
    <br>
    <span>Result : ${result}</span>

</form>
</body>
</html>