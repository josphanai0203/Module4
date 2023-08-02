<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/convert" method="get">


    <input type="text" name="money" value="${money}" placeholder="Nhập USD">
    <br>
    <input type="submit" value="chuyển">
    <br>
        <input readonly value="${result}">
    <br>

</form>
</body>
</html>