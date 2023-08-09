package org.example.player;

import org.example.enums.Suit;
import org.example.gameloop.Card;

import java.util.LinkedList;
import java.util.List;

public abstract class Player {

    private boolean isFirst;
    // todo: isFirstToBid isFirstToPlay olarak ayıralım
    protected String name;
    protected List<Card> hand;
    protected int scoreInCurrentRound;

    public Player() {
        this.isFirst = false;
        this.hand = new LinkedList<>();
        this.scoreInCurrentRound = 0;
    }

    public boolean isHandEmpty() {
        return hand.isEmpty();
    }

    public void addToHand(Card card) {
        this.hand.add(card);
    }

    public String getName() {
        return name;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
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
