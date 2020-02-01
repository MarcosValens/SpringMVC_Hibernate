<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Planets</title>
</head>
<body>
<c:import url="../teamplate/menu.html"></c:import>
<ul>
    <c:forEach var="planet" items="${planets}">
        <li>${planet.name}</li>
    </c:forEach>
</ul>
</body>
</html>
