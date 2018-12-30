<%@ page contentType="text/html;charset-UTF-8" isELIgnored="false" %>
<html>


<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ProCare</title>
</head>
<body>
<h1>
    ProCare
</h1>

<form action="player">
    Add new player: <input type="text" name="playerName"> <br>
    <input type="submit" value="Add">
</form>

<form action="play">
    <ul>
        <c:forEach var="listValue" items="${players}">
            <input type="checkbox" name="chosenPlayers" value=${listValue}> ${listValue.name}<br>
        </c:forEach>
    </ul>
    <input type="submit" value="Play">
</form>
</body>
</html>
