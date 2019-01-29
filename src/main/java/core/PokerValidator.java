package core;

import java.io.IOException;

public class PokerValidator implements StateValidator {
    public void validateNextMove(GameState state, Player player) throws IOException {
        Player currentPlayer = state.getCurrentPlayer();
        if (!currentPlayer.equals(player)) throw new IOException("Invalid Player");
    }

    public void validateNextTurn(GameState state) {

    }
}
