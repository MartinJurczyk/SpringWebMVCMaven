package core;

public interface GameState {
    void makeMove(int amount);

    void cleanTable();

    Player getCurrentPlayer();

    void resign();
}
