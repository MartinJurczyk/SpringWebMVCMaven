<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset-UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link href="<spring:url value="/resources/main.css"/>" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css?family=Lobster&amp;subset=latin-ext" rel="stylesheet">

    <title>ProCare-Game</title>
</head>
<body>
<div>
    <header>

        <h1>ProCare</h1>
        <p>Based on <a href="https://pl.wikipedia.org/wiki/Texas_Hold%E2%80%99em" target="_blank">Texas Hold'em</a></p>

    </header>

    <main>

        <article>

            <div class="board">

                <div class="card" id="c0"></div>
                <div class="card" id="c1"></div>
                <div class="card" id="c2"></div>
                <div class="card" id="c3"></div>
                <div class="card" id="c4"></div>
                <br>
                <div class="score" id="pool">${state.poolMoney}</div>

                <div class="playerBoardA" id="pb0">
                    <div class="score" id="stake0">${state.players.get(0).betMoney}</div>

                    <div class="card" id="p0c0"></div>
                    <div class="card" id="p0c1"></div>

                    <c:out value="${state.players.get(0).name}"/><br>

                    <div class="score">${state.players.get(0).ownMoney}</div>

                    <div class="put">
                        <form action="putMoney">
                            <input type="text" name="money"> <br>
                            <input type="submit" id= "put0" value="put">
                        </form>
                        <form action="pass">
                            <input type="submit" id= "pass0" value="pass">
                        </form>
                    </div>

                </div>

                <div class="playerBoard" id="pb1">
                    <div class="score" id="stake1">${state.players.get(1).betMoney}</div>

                    <div class="card" id="p1c0"></div>
                    <div class="card" id="p1c1"></div>

                    <c:out value="${state.players.get(1).name}"/><br>

                    <div class="score">${state.players.get(1).ownMoney}</div>

                    <div class="put" >
                        <form action="putMoney">
                            <input type="text" name="money"> <br>
                            <input type="submit" id= "put1" value="put">
                        </form>
                        <form action="pass">
                            <input type="submit" id= "pass1" value="pass">
                        </form>
                    </div>

                </div>

            </div>


            <br>
            <br>
            <form action="cleanUp">
                <input type="submit" id= "finalize" value="finalize">
            </form>

        </article>

    </main>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="<spring:url value="/resources/main.js"/>"></script>
</div>
</body>
</html>