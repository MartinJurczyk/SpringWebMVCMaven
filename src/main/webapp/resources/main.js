
var cards = ["karoK.png", "pikQ.png", "pik8.png", "trefl5.png", "kier10.png","karoA.png", "pikA.png", "karoJ.png", "trefl2.png", "kier4.png"];
//var cards = ["karo5.png", "pik7.png", "pik8.png", "treflJ.png", "kier4.png","karoJ.png", "pik7.png", "karoQ.png", "trefl2.png", "kier8.png"];

var cardsTurn;
var playerTurn;

$( document ).ready(function() {
    checkCookie("cardsTurn");
    cardsTurn = getCookie("cardsTurn");

    checkCookie("playerTurn");
    playerTurn = getCookie("playerTurn");

    if(cardsTurn == "1") {
        revealCard('#c0', 0);
        revealCard('#c1', 1);
        revealCard('#c2', 2);
    } else if(cardsTurn == "2") {
        revealCard('#c0', 0);
        revealCard('#c1', 1);
        revealCard('#c2', 2);
        revealCard('#c3', 3);
    } else if(cardsTurn == "3") {
        revealCard('#c0', 0);
        revealCard('#c1', 1);
        revealCard('#c2', 2);
        revealCard('#c3', 3);
        revealCard('#c4', 4);
    } else {
        setCookie("playerTurn", "0", 365);
        setCookie("cardsTurn", "0", 365);
    }

    if (playerTurn == "1") {
        switchPlayer(0, 1);
    }
});

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function checkCookie(cname) {
    var user = getCookie(cname);
    if (user == "") {
        user = "0";
        setCookie(cname, user, 365);
    }
}

var p0c0 = document.getElementById('p0c0');
var p0c1 = document.getElementById('p0c1');

var p1c0 = document.getElementById('p1c0');
var p1c1 = document.getElementById('p1c1');

p0c0.addEventListener("click", function() { quickRevealCard(0, 0); });
p0c1.addEventListener("click", function() { quickRevealCard(0, 1); });

p1c0.addEventListener("click", function() { quickRevealCard(1, 0); });
p1c1.addEventListener("click", function() { quickRevealCard(1, 1); });

function quickRevealCard(playerNumber, cardNumber)
{
    var borderColor = $('#pb' + playerNumber).css('border-color');

    if (borderColor == "rgb(233, 182, 74)") {
        revealCard('#p' + playerNumber + 'c' + cardNumber, 5 + 2 * playerNumber + cardNumber);

        setTimeout(function() { restoreCard('#p' + playerNumber + 'c' + cardNumber) }, 750);
    } else {
        alert("You can't see opponent cards");
    }
}

function restoreCard(id)
{
    $(id).css('background-image', 'url(img/cover.png)');
    $(id).addClass('card');
    $(id).removeClass('cardA');
}


var c0 = document.getElementById('c0');
var c1 = document.getElementById('c1');
var c2 = document.getElementById('c2');
var c3 = document.getElementById('c3');
var c4 = document.getElementById('c4');

c0.addEventListener("click", function() { revealTableCard(); });
c1.addEventListener("click", function() { revealTableCard(); });
c2.addEventListener("click", function() { revealTableCard(); });
c3.addEventListener("click", function() { revealTableCard(); });
c4.addEventListener("click", function() { revealTableCard(); });

function revealCard(id, number) {
    var image = "url(img/" + cards[number] + ")";

    $(id).css('background-image', image);
    $(id).addClass('cardA');
    $(id).removeClass('card');
}

function revealTableCard()
{
    if ($('#stake1').html() == $('#stake0').html()) {
        cardsTurn++;
        setCookie("cardsTurn", cardsTurn, 365);
        if(cardsTurn == "1") {
            revealCard('#c0', 0);
            revealCard('#c1', 1);
            revealCard('#c2', 2);
        } else if(cardsTurn == "2") {
            revealCard('#c3', 3);
        } else if(cardsTurn == "3") {
            revealCard('#c4', 4);
        }
    } else {
        alert("First everybody must even")
    }
}

var put0 = document.getElementById('put0');
var put1 = document.getElementById('put1');

put0.addEventListener("click", function() { switchPlayer(0, 1); playerTurn++; setCookie("playerTurn", playerTurn, 365);});
put1.addEventListener("click", function() { switchPlayer(1, 0); playerTurn--; setCookie("playerTurn", playerTurn, 365);});

function switchPlayer(playerNumberCurrent, playerNumberNext) {
    $('#pb' + playerNumberCurrent).addClass('playerBoard');
    $('#pb' + playerNumberCurrent).removeClass('playerBoardA');

    $('#pb' + playerNumberNext).addClass('playerBoardA');
    $('#pb' + playerNumberNext).removeClass('playerBoard');
}


var pass0 = document.getElementById('pass0');
var pass1 = document.getElementById('pass1');

pass0.addEventListener("click", function() { pass();});
pass1.addEventListener("click", function() { pass();});

function pass() {
    revealCard('#c0', 0);
    revealCard('#c1', 1);
    revealCard('#c2', 2);
    revealCard('#c3', 3);
    revealCard('#c4', 4);
    revealCard('#p0c0', 5);
    revealCard('#p0c1', 6);
    revealCard('#p1c0', 7);
    revealCard('#p1c1', 8);
}

var finalize = document.getElementById('finalize');

finalize.addEventListener("click", function() { cleanUp();});

function cleanUp() {
    setCookie("playerTurn", "0", 365);
    setCookie("cardsTurn", "0", 365);

    restoreCard('#c0');
    restoreCard('#c1');
    restoreCard('#c2');
    restoreCard('#c3');
    restoreCard('#c4');
    restoreCard('#p0c0');
    restoreCard('#p0c1');
    restoreCard('#p1c0');
    restoreCard('#p1c1');
}
