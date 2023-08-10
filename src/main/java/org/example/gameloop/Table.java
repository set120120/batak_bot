package org.example.gameloop;

import org.example.player.Player;

import java.util.HashMap;
import java.util.Map;

public class Table {

    private Map<Player, Card> playedCardsInCurrentRound = new HashMap<>();

    public Map<Player, Card> getPlayedCardsInCurrentRound() {
        return playedCardsInCurrentRound;
    }

    public void clearCurrentTable() {
        playedCardsInCurrentRound.clear();
    }

    public void addCardCurrentRound(Player player, Card card) {
        playedCardsInCurrentRound.put(player, card);
    }

    public void displayCurrentTable() {
        System.out.println("Current Cards on table: ");
        for (Card card : playedCardsInCurrentRound.values()) {
            System.out.print(card.toString() + ", ");
        }
        System.out.println(".");
    }
}
