package core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerIteratorTest {

    private static ArrayList<Player> players = new ArrayList<Player>();

    @BeforeEach
    void setUp() {
        players.add(new Player("Martin", 1000, 0, false, false));
        players.add(new Player("Bogdan", 2000, 0, false, false));
    }

    @Test
    void testPeriodic() {
        //given
        players.add(new Player("Magda", 3000, 0, true, false));
        PlayerIterator playerIterator = new PlayerIterator(players, 0);

        // when
        Player next = playerIterator.next();

        // then
        assertEquals(next, players.get(1));
    }

    @Test
    void testPassing() {
        //given
        PlayerIterator playerIterator = new PlayerIterator(players, 0);

        // when
        playerIterator.next();
        Player next = playerIterator.next();
        Player current = playerIterator.current();

        // then
        assertEquals(current, players.get(2 % players.size()));
        assertEquals(next, players.get(2 % players.size()));
    }

    @AfterEach
    void cleanUp() {
        players.removeAll(players);
    }
}