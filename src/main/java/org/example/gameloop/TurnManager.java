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
                .stream().filter(Player::isFirstToPlay)
                .findAny()
                .orElseThrow(() -> new RuntimeException("There is no current player"));
    }

    public void nextTurnForBid() {
        if (!iterator.hasNext()) {
            iterator = playerTurns.iterator();
        }
        for (Player playerTurn : playerTurns) {
            playerTurn.setFirstToBid(false);
        }
        iterator.next().setFirstToBid(true);
    }


    public void nextTurnForGame() {
        if (!iterator.hasNext()) {
            iterator = playerTurns.iterator();
        }
        for (Player playerTurn : playerTurns) {
            playerTurn.setFirstToPlay(false);
        }
        iterator.next().setFirstToPlay(true);
    }

    public Player setFirstPlayer(Player player) {
        player.setFirstToPlay(true);
        return player;
    }
}
