<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<form action="login" method="post">
    <label>Username:<br>
        <select type="text" name="userName">
            <c:forEach var="user" items="${users}">
                <option value="${user.userName}">${user.userName}</option>
            </c:forEach>
        </select>
    </label>
    <br>
    <label>Password: <br>
        <input type="password" name="password"><br>
    </label>
    <input type="submit" value="Login">
</form>
</body>
</html>
