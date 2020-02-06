<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Planets</title>
</head>
<body>
<c:import url="../teamplate/menu.jsp"/>
<table>
    <tr>Planet ID</tr>
    <tr>Planet Name</tr>
    <tr>Planet Mass</tr>
    <tr>Is Habitable?</tr>
    <tr>Satellites</tr>
    <c:if test="${user.id > 0}">
        <tr>Observations</tr>
        <tr>Edit</tr>
        <tr>Delete</tr>
    </c:if>
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
            <td><c:forEach var="observation" items="${observation}">
                <c:if test="${planet.id==observation.planet.id}">
                    <ul>
                        <li>
                                ${observation.observations}
                        </li>
                    </ul>
                </c:if>
            </c:forEach></td>
            <c:forEach var="observation" items="${observation}">
                <c:if test="${user.id == observation.user.id && planet.id == observation.planet.id}">
                    <td>
                        <a href="${pageContext.request.contextPath}/planetForm/${planet.id}">
                            <button>EDIT</button>
                        </a>
                    </td>
                    <td>
                        <form action="deletePlanet" method="post">
                            <button type="submit">Delete</button>
                            <input type="hidden" name="idPlanet" value="${planet.id}">
                        </form>
                    </td>
                </c:if>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
</body>
</html>
