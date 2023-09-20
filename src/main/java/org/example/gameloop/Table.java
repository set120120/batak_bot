package org.example.gameloop;

import org.example.enums.Suit;
import org.example.player.Player;

import java.util.*;

public class Table {
    // toAsk Ali Abi to better Way
    private final List<Integer> hearts = new ArrayList<>() {
        {
            for (int i = 2; i < 15; i++) {
                add(i);
            }
        }
    };
    private final List<Integer> spades = new ArrayList<>() {
        {
            for (int i = 2; i < 15; i++) {
                add(i);
            }
        }
    };
    private final List<Integer> diamonds = new ArrayList<>() {
        {
            for (int i = 2; i < 15; i++) {
                add(i);
            }
        }
    };
    private final List<Integer> clubs = new ArrayList<>() {
        {
            for (int i = 2; i < 15; i++) {
                add(i);
            }
        }
    };

    private final Map<Suit, List<Integer>> mapOfCards = Map.of(Suit.CLUBS, clubs, Suit.HEARTS, hearts,
            Suit.DIAMONDS, diamonds, Suit.SPADES, spades);
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
    public void deleteCardFromMap(Card card){
        mapOfCards.get(card.suit()).remove(card.value().getValueCode());
    }
}
