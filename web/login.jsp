<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<c:if test="${requestScope['message'] != null}">
    <c:out value="${message}"></c:out>
</c:if>

<form action="/login" method="post">

    <input type="text" name="username" placeholder="Username Here"/>
    <input type="password" name="password"/>

    <button type="submit">Login</button>

</form>

</body>
</html>
