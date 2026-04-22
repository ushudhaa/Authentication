<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="register">Register</a>
<br/>
<a href="login">Login</a>
<%--<%--%>
<%--    com.authentication.user.model.UserModel user=(com.authentication.user.model.UserModel)session.getAttribute("user");--%>
<%--%>--%>
<%--<%--%>
<%--    if(user!=null){--%>
<%--%>--%>
<%--<h1>Name: ${user.getName()}</h1>--%>
<%--<h1>Email: ${user.getEmail()}</h1>--%>
<%--<%--%>
<%--}else{--%>
<%--%>--%>
<%--<h1>Please log in</h1>--%>
<%--<%--%>
<%--    }--%>
<%--%>--%>
<c:choose>
    <c:when test="${not empty user}">
        <h1> Name: ${user.getName()}</h1>
        <h1> Email:${user.getEmail()}</h1>
    </c:when>
    <c:otherwise>
        <h1>please log in first</h1>
    </c:otherwise>
</c:choose>

<form method="post" action="add-topic">
    <label>Topic Name</label>
    <input name="topic_name"/>
    <button type="submit">Add Topic</button>
</form>
</body>
</html>
