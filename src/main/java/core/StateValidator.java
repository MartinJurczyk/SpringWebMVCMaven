package core;

import java.io.IOException;

public interface StateValidator {
    void validateNextMove(GameState state, Player player) throws IOException;

    void validateNextTurn(GameState state);
}
