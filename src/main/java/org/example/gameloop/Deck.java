package org.example.gameloop;

import org.example.enums.Suit;
import org.example.enums.Value;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {

    public static final int TOTAL_CARDS = 52;
    public static final int SUIT_TYPES = 4;

    private final LinkedList<Card> cards = new LinkedList<>();

    Deck() {
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                cards.add(new Card(suit, value));
            }
        }
        shuffle();
    }

    public void shuffle() { Collections.shuffle(cards); }
    public LinkedList<Card> getCards() { return cards; }
    public Card draw(){ return cards.pop(); }
    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
