<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="settingMail" action="/setting" method="post">
  <table>
    <tr>
      <td><strong>Languages</strong></td>
      <td>
        <form:select path="language" items="${languages}"/>
      </td>
    </tr>
    <tr>
      <td><strong>Page Size</strong></td>
      <td> show
        <form:select path="pageSize" items="${sizes}"/>
        emails per page
      </td>
    </tr>
    <tr>
      <td><strong>Spams Filter</strong></td>
      <td>
        <form:checkbox path="filler" /> Enable spams filler
      </td>
    </tr>
    <tr>
      <td><strong>Signature</strong></td>
      <td>
        <form:input path="signature"/>
      </td>
    </tr>
    <tr>
      <td></td>
      <td>
        <input type="submit" value="update">
      </td>
    </tr>
  </table>

</form:form>
</body>
</html>
