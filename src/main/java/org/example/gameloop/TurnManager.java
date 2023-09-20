package org.example.gameloop;

import org.example.player.Player;

import java.util.ArrayList;
import java.util.List;

public class TurnManager {
    private final List<Player> playerTurns;

    public TurnManager() {
        this.playerTurns = new ArrayList<>(4);
    }

    public List<Player> getPlayerTurns() {
        return playerTurns;
    }

    public Player getNextPlayer(Player player) {
        return player.getNext();
    }
}
