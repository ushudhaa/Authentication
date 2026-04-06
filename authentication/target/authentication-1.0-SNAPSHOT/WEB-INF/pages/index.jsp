<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<% com.authentication.user.model.UserModel user=(com.authentication.user.model.UserModel)request.getAttribute("user");%>
<a href="register">register</a>
<br/>
<a href="login">Login</a>
<% if(user==null){
%>
<h1>
<%=user.getName()%>
<%=user.getEmail()%>
