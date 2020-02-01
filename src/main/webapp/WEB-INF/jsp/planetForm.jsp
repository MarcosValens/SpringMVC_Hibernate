<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Planet Form</title>
</head>
<body>
<c:import url="../teamplate/menu.html"></c:import>
<form action="savePlanet" method="post">

    <input type="hidden" name="idPlanet" value="${planet.getId()}">

    <label>Name Planet:<br>
        <input type="text" name="namePlanet" value="${planet.getName()}"><br>
    </label>

    <label>Mass:<br>
        <input type="text" name="massPlanet" value="${planet.getMass()}"><br>
    </label>

    <label>Habitable:<br>
        <input type="checkbox" name="habitablePlanet" value="YES ${(planet.isHabitable())?"checked":""}"><br>
    </label>

    <label>Satellites:<br>
    <select multiple id="option" name="satellitesPlanet">
        <c:forEach var="satellite" items="${satellites}">
            <option value="${satellite.getId()}">${satellite.getName()}</option>
        </c:forEach>
    </select>
    </label>

    <br>
    <br>
    <input type="submit" value="Submit">
</form>

<script>
    let selection = document.getElementById('option');
    let values = new Array(selection.length);
    selection.addEventListener('click', function(e) {
        values[e.target.index] = !values[e.target.index];
        for(var i=0;i<values.length;++i) {
            selection.options[i].selected = values[i];
        }
    });
</script>
</body>
</html>
