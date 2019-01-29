package core;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class PlayerIterator implements Iterator<Player> {
    private List<Player> players;
    private int first;
    private int index;

    public PlayerIterator(List<Player> players, int index) {
        this.players = players;
        this.index = index;
        this.first = index;
    }

    public boolean hasNext() {
        return true;
    }

    public Player next() {
        do {
            index++;
            if (index >= players.size()) {
                index = 0;
            }
        } while (players.get(index).isPassed());
        return players.get(index);
    }

    public void remove() {

    }

    public void forEachRemaining(Consumer<? super Player> action) {

    }

    public Player current() {
        return players.get(index);
    }
}
