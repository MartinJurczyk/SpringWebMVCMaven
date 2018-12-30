package pl.edu.uj.wmii.www.services;

import pl.edu.uj.wmii.www.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerService {
    private List<Player> players = new ArrayList<Player>();

    public void addPlayer(String playerName) {
        players.add(new Player(playerName));
    }

    public List<Player> getPlayers() {
        return players;
    }
}
