<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/8/2023
  Time: 8:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
  <tr>
    <td><strong>Languages</strong></td>
    <td>
      ${mail.language}
    </td>
  </tr>
  <tr>
    <td><strong>Page Size</strong></td>
    <td> show
      ${mail.pageSize}
      emails per page
    </td>
  </tr>
  <tr>
    <td><strong>Spams Filter</strong></td>
    <td>
      ${mail.filler}
    </td>
  </tr>
  <tr>
    <td><strong>Signature</strong></td>
    <td>
      ${mail.signature}
    </td>
  </tr>

</table>
</body>
</html>
