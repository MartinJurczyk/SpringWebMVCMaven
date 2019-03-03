package core;

import java.util.List;

public class PokerState {
    private PlayerIterator playerIterator;
    private List<Player> players;
    private int poolMoney;
    private int maxAnte;
    private int minOverTrumping;
    private Player winner;

    private PokerState(PlayerIterator playerIterator, List<Player> players, int poolMoney, int maxAnte, int minOverTrumping) {
        this.playerIterator = playerIterator;
        this.players = players;
        this.poolMoney = poolMoney;
        this.maxAnte = maxAnte;
        this.minOverTrumping = minOverTrumping;
        this.winner = players.get(0);
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
        winner = nextPlayer();
    }

    private Player nextPlayer() {
        return playerIterator.next();
    }

    public void cleanUp() {
        winner.setOwnMoney(winner.getOwnMoney() + poolMoney);
        poolMoney = 0;
        for(Player player: players) {
            player.setBetMoney(0);
        }
    }

    public Player getCurrentPlayer() {
        return playerIterator.current();
    }


    private boolean isAdjusted(Player next) {
        return getMaxAnte() == next.getBetMoney();
    }

    public static GameStateBuilder builder() {
        return new GameStateBuilder();
    }

    public static class GameStateBuilder {
        private PlayerIterator playerIterator;
        private List<Player> players;
        private int poolMoney = 0;
        private int maxAnte = 0;
        private int minOverTrumping = 1;

        public GameStateBuilder players(List<Player> players) {
            this.playerIterator = new PlayerIterator(players, 0);
            this.players = players;
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
            return new PokerState(playerIterator, players, poolMoney,maxAnte, minOverTrumping);
        }

    }

    public PlayerIterator getPlayerIterator() {
        return playerIterator;
    }

    public void setPlayerIterator(PlayerIterator playerIterator) {
        this.playerIterator = playerIterator;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setPoolMoney(int poolMoney) {
        this.poolMoney = poolMoney;
    }

    public void setMaxAnte(int maxAnte) {
        this.maxAnte = maxAnte;
    }

    public int getMinOverTrumping() {
        return minOverTrumping;
    }

    public void setMinOverTrumping(int minOverTrumping) {
        this.minOverTrumping = minOverTrumping;
    }
}
