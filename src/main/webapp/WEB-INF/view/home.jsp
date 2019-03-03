<%@ page contentType="text/html;charset-UTF-8" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link href="<spring:url value="/resources/main.css"/>" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css?family=Lobster&amp;subset=latin-ext" rel="stylesheet">

    <title>ProCare-Home</title>
</head>
<body>
<header>

    <h1>ProCare</h1>
    <p>Based on <a href="https://pl.wikipedia.org/wiki/Texas_Hold%E2%80%99em" target="_blank">Texas Hold'em</a></p>

</header>

<form action="player">
    Add new player: <input type="text" name="playerName"> <br>
    <input type="submit" value="Add">
</form>


<form action="play">
    <ul>
        <c:forEach var="listValue" items="${players}">
            <input type="checkbox" name="chosenPlayers" value=${listValue.id}> ${listValue.name}<br>
        </c:forEach>
    </ul>
    <input type="submit" value="Play">
</form>
</body>
</html>
