<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 3/20/2026
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Add Topic</title>
</head>
<body>
<form method="post" action="add-topic">
    <label>Topic Name</label>
    <input name="topic_name"/>
    <button type="submit">Add Topic</button>
    <c:if test="${not empty error}">
        <label>${error}</label>
    </c:if>
</form>
</body>
</html>
