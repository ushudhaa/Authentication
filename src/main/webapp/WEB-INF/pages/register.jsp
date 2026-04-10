<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 3/20/2026
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<% String errormsg=(String)request.getAttribute("error");%>
<body>
<form method="post" action="register">
    <label>name</label>
    <input name="name"/>
    <label>Email</label>
    <input name="email"/>
    <label>Password</label>
    <input name="password"/>
    <button type="submit">Register</button>
    </form>
    <label>
        <%=errormsg%>
    </label>
</body>
</html>
