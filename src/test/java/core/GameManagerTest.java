package core;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class GameManagerTest {

    @Test
    void test() throws IOException {
        List<Player> players = new ArrayList<Player>();
        Player martin = new Player(1,"Martin", 1000, 0, false, false);
        players.add(martin);
        Player magda = new Player(2, "Magda", 1000, 0, false, false);
        players.add(magda);

        PokerState pokerState = PokerState.builder()
                .players(players)
                .maxAnte(1)
                .poolMoney(200)
                .minOverTrumping(1)
                .build();

        // rozdanie
        pokerState.makeMove(20);
        pokerState.makeMove(20);
        // 3 karty na stole
        pokerState.makeMove(10);
        pokerState.makeMove(20);
        pokerState.makeMove(20);
        pokerState.makeMove(10);
        // 4 karty na stole
        pokerState.makeMove(0);
        pokerState.makeMove(10);
        pokerState.makeMove(20);
        pokerState.makeMove(20);
        // 5 kart na stole
        pokerState.makeMove(0);
        pokerState.makeMove(100);
        pokerState.resign();

        assertEquals(pokerState.getPoolMoney(), 450);
    }
}