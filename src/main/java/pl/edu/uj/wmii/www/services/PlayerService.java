package pl.edu.uj.wmii.www.services;

import core.Player;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("playerService")
public class PlayerService {
    private static int idCounter = 0;
    private List<Player> players = new ArrayList<>();
    private List<Player> chosenPlayers = new ArrayList<>();

    public void addPlayer(String playerName, int money) {
        Player player = new Player(idCounter, playerName, money, 0);
        idCounter++;
        players.add(player);
    }

    public Player[] getPlayers() {
        return players.toArray(new Player[players.size()]);
    }

    public void setChosenPlayers(Integer[] chosenIdPlayers) {
        for (int i = 0; i < chosenIdPlayers.length; i++) {
            chosenPlayers.add(players.get(chosenIdPlayers[i]));
        }
    }

    public List<Player> getChosenPlayers() {
        return chosenPlayers;
    }
}
