<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Planets</title>
</head>
<body>
<c:import url="../teamplate/menu.html"/>
<table>
    <tr>Planet ID</tr>
    <tr>Planet Name</tr>
    <tr>Planet Mass</tr>
    <tr>Is Habitable?</tr>
    <tr>Satellites</tr>
    <tr>Edit</tr>
    <tr>Delete</tr>
    <c:forEach var="planet" items="${planets}">
        <tr>
            <td>${planet.id}</td>
            <td>${planet.name}</td>
            <td>${planet.mass}</td>
            <td>${planet.habitable}</td>
            <td>
                <ul>
                    <c:forEach var="satellite" items="${satellites}">
                        <c:if test="${planet.id == satellite.planet.id}">
                            <li>${satellite.name}</li>
                        </c:if>
                    </c:forEach>
                </ul>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/planetForm/${planet.id}"><button>EDIT</button></a>
            </td>
            <td>
                <form action="deletePlanet" method="post">
                    <button type="submit">Delete</button>
                    <input type="hidden" name="idPlanet" value="${planet.id}">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
