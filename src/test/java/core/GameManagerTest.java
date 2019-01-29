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
        Player martin = new Player("Martin", 1000, 0, false, false);
        players.add(martin);
        Player magda = new Player("Magda", 1000, 0, false, false);
        players.add(magda);

        PokerState pokerState = PokerState.builder()
                .players(players)
                .game(new Poker())
                .build();

        GameManager gameManager = new GameManager(pokerState, new PokerValidator());

        // rozdanie
        gameManager.move(martin, 20);
        gameManager.move(magda, 20);
        // 3 karty na stole
        gameManager.move(martin, 10);
        gameManager.move(magda, 20);
        gameManager.move(martin, 20);
        gameManager.move(magda, 10);
        // 4 karty na stole
        gameManager.move(martin, 0);
        gameManager.move(magda, 10);
        gameManager.move(martin, 20);
        gameManager.move(magda, 20);
        // 5 kart na stole
        gameManager.move(martin, 0);
        gameManager.move(magda, 100);
        PokerState gameState = (PokerState)gameManager.resign(martin);

        assertEquals(gameState.getPoolMoney(), 250);
    }
}