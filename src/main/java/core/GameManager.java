package core;

import java.io.IOException;

public class GameManager {
    private GameState state;
    private StateValidator stateValidator;

    public GameManager(GameState state, StateValidator stateValidator) {
        this.state = state;
        this.stateValidator = stateValidator;
    }

    public GameState startGame() {
        return state;
    }

    public GameState move(Player player, int amount) throws IOException {
        stateValidator.validateNextMove(state, player);
        state.makeMove(amount);
        return state;
    }

    public GameState resign(Player player) throws IOException {
        stateValidator.validateNextMove(state, player);
        state.resign();
        return state;
    }

    public GameState nextTurn() {
        stateValidator.validateNextTurn(state);
        state.cleanTable();
        return state;
    }

    public GameState endGame() {
        return state;
    }
}
