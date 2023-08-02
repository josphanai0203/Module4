<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/translate" method="get">
<input type="text" placeholder="Nhập từ " value="${word}" name="word"><br>
<input type="submit" value="tìm kiếm"> <br>
    <span>Result : ${result}</span>
</form>
</body>
</html>