package org.example.player;

import org.example.enums.Suit;
import org.example.gameloop.Card;

import java.util.List;

public abstract class Player {

    private boolean isFirst;
    protected String name;
    protected List<Card> hand;
    private int scoreInCurrentRound;

    public boolean isHandEmpty() {
        return hand.isEmpty();
    }

    public void addToHand(Card card) {
        this.hand.add(card);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getHand() {
        return this.hand;
    }

    public int getScore() {
        return scoreInCurrentRound;
    }

    public void setScore(int scoreInCurrentRound) {
        this.scoreInCurrentRound = scoreInCurrentRound;
    }
    public abstract Suit selectTramp();
    public abstract void logHand();

    public abstract Card playCard();

    public abstract int makeBid();


    @Override
    public String toString() {
        return "Player{" +
                "hand=" + hand +
                ", scoreInCurrentRound=" + scoreInCurrentRound +
                '}';
    }
}
