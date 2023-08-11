package org.example.gameloop;

import org.example.player.Player;

import java.util.LinkedHashMap;
import java.util.Map;

public class Table {

    private final Map<Player, Card> playedCardsInCurrentRound = new LinkedHashMap<>();

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

    public Card getFirstCardPlayed() {
        return playedCardsInCurrentRound.entrySet()
                .iterator()
                .next()
                .getValue();
    }
}
