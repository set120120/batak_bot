package org.example.gameloop;

import org.example.player.Player;

import java.util.ArrayList;
import java.util.List;

public class TurnManager {
    private final List<Player> playerTurns;
    private final TurnCycleEvaluator turnCycleEvaluator;

    public TurnManager(TurnCycleEvaluator turnCycleEvaluator) {
        this.turnCycleEvaluator = turnCycleEvaluator;
        this.playerTurns = new ArrayList<>(4);
    }

    public List<Player> getPlayerTurns() {
        return playerTurns;
    }

    public List<Player> setNewTurnCycle(Player turnWinner) {
        List<Player> newTurnList = new ArrayList<>();

        newTurnList.add(0, turnWinner);
        newTurnList.add(1, turnWinner.getNext());
        newTurnList.add(2, turnWinner.getNext().getNext());
        newTurnList.add(3, turnWinner.getNext().getNext().getNext());

        return newTurnList;
    }

    public Player getNextPlayer(Player player) {
        return player.getNext();
    }
}
