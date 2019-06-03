<%--
  Created by IntelliJ IDEA.
  User: stefan.seulean
  Date: 2019-06-03
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo Submit Form JSP</title>
</head>
<body>
<body>

<form action="submit-form" method="POST">
    Please enter a color <br>
    <input type="text" name="color" size="20px">
    <input type="submit" value="submit">
</form>

Submitted color:${submittedColor}

</body>

</body>
</html>
