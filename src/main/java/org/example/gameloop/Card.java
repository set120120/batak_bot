package org.example.gameloop;

import org.example.enums.Suit;
import org.example.enums.Value;

public class Card {

    private final Suit suit;

    private final Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Value getValue() {
        return this.value;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }


}
