package org.example.gameloop;

import org.example.enums.Suit;
import org.example.enums.Value;

public record Card(Suit suit, Value value) {

    @Override
    public String toString() {
        return value + " of " + suit;
    }


}
