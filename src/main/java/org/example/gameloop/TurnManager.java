package org.example.gameloop;

import org.example.player.Player;

import java.util.Iterator;
import java.util.List;

public class TurnManager {
    private final List<Player> playerTurns;
    private Iterator<Player> iterator;

    public TurnManager(List<Player> playerTurns) {
        this.playerTurns = playerTurns;
        this.iterator = playerTurns.iterator();
    }

    public Player nextTurn() {
        if (!iterator.hasNext()) {
            iterator = playerTurns.iterator();
        }
        return iterator.next();
    }
}
