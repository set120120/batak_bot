package org.example.gameloop;

import org.example.enums.Suit;
import org.example.player.Player;

import java.util.*;

public class Table {

    private final Map<Player, Card> playedCardsInCurrentRound = new LinkedHashMap<>();

    public Map<Player, Card> getPlayedCardsInCurrentRound() {
        return playedCardsInCurrentRound;
    }

    public Optional<Card> getFirstCardOnTable() {
        List<Card> values = playedCardsInCurrentRound.values().stream().toList();
        return this.playedCardsInCurrentRound.isEmpty() ? Optional.empty() : Optional.of(values.get(0));
    }


    public void clearCurrentTable() {
        playedCardsInCurrentRound.clear();
    }

    public void addCardCurrentRound(Player player, Card card) {
        playedCardsInCurrentRound.put(player, card);
    }

    public void displayCurrentTable() {
        System.out.println("Current Cards on table: " + playedCardsInCurrentRound.values());
    }

    public Card getFirstCardPlayed() {
        return playedCardsInCurrentRound.entrySet()
                .iterator()
                .next()
                .getValue();
    }

    public boolean isThereAnyTrampOnTable(Suit tramp) {
        return !this.playedCardsInCurrentRound.values()
                .stream()
                .filter(card -> card.suit() == tramp)
                .toList()
                .isEmpty();
    }
}
