package org.example.gameloop;

import org.example.player.Player;

import java.util.Iterator;
import java.util.List;

public class TurnManager {
    private final List<Player> playerTurns;
    private Iterator<Player> iterator;

    public List<Player> getPlayerTurns() {
        return playerTurns;
    }

    public TurnManager(List<Player> playerTurns) {
        this.playerTurns = playerTurns;
        this.iterator = playerTurns.iterator();
    }

    public Player getCurrentPlayer() {
        return this.getPlayerTurns()
                .stream().filter(Player::isFirst)
                .findAny()
                .orElseThrow(() -> new RuntimeException("There is no current player"));
    }

    public void nextTurn() {
        if (!iterator.hasNext()) {
            iterator = playerTurns.iterator();
        }
        for (Player playerTurn : playerTurns) {
            playerTurn.setFirst(false);
        }
        iterator.next().setFirst(true);
    }

    public Player setFirstPlayer(Player player) {
        for (Player playerTurn : playerTurns) {
            playerTurn.setFirst(false);
        }
        player.setFirst(true);
        return player;
    }
}
