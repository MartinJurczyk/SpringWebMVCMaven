package core;

import java.util.List;

public class PokerState implements GameState {
    private PlayerIterator playerIterator;
    private List<Player> players;
    private Game game;
    private int poolMoney;
    private int maxAnte;
    private int minOverTrumping;

    private PokerState(PlayerIterator playerIterator, List<Player> players, Game game, int poolMoney, int maxAnte, int minOverTrumping) {
        this.playerIterator = playerIterator;
        this.players = players;
        this.game = game;
        this.poolMoney = poolMoney;
        this.maxAnte = maxAnte;
        this.minOverTrumping = minOverTrumping;
    }

    public int getPoolMoney() {
        return poolMoney;
    }

    private int getMaxAnte() {
        return maxAnte;
    }

    public void makeMove(int amount) {
        updateState(amount);
        nextPlayer();
    }

    private void updateState(int amount) {
        Player player = getCurrentPlayer();
        player.setBetMoney(player.getBetMoney() + amount);
        player.setOwnMoney(player.getOwnMoney() - amount);
        poolMoney = poolMoney + amount;
    }

    public void resign() {
        getCurrentPlayer().setPassed(true);
        nextPlayer();
    }

    private void nextPlayer() {
        Player next = playerIterator.next();
        if (isAdjusted(next)) {
            game.nextStep();
        }
    }

    public void cleanTable() {

    }

    public Player getCurrentPlayer() {
        return playerIterator.current();
    }


    public static GameStateBuilder builder() {
        return new GameStateBuilder();
    }

    private boolean isAdjusted(Player next) {
        return getMaxAnte() == next.getBetMoney();
    }

    public static class GameStateBuilder {
        private PlayerIterator playerIterator;
        private List<Player> players;
        private Game game;
        private int poolMoney = 0;
        private int maxAnte = 0;
        private int minOverTrumping = 1;

        public GameStateBuilder players(List<Player> players) {
            this.playerIterator = new PlayerIterator(players, 0);
            this.players = players;
            return this;
        }

        public GameStateBuilder game(Game game) {
            this.game = game;
            return this;
        }

        public GameStateBuilder poolMoney(int poolMoney) {
            this.poolMoney = poolMoney;
            return this;
        }

        public GameStateBuilder maxAnte(int maxAnte) {
            this.maxAnte = maxAnte;
            return this;
        }

        public GameStateBuilder minOverTrumping(int minOverTrumping) {
            this.minOverTrumping = minOverTrumping;
            return this;
        }

        public PokerState build() {
            return new PokerState(playerIterator, players, game, poolMoney,maxAnte, minOverTrumping);
        }

    }
}
