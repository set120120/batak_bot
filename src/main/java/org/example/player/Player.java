package org.example.player;

import org.example.enums.Suit;
import org.example.gameloop.Card;

import java.util.*;
import java.util.stream.Collectors;

public abstract class Player {

    private Player next;
    protected String name;
    protected List<Card> hand;
    private boolean isFirstToBid;
    protected int scoreInCurrentRound = 0;

    public Player getNext() {
        return next;
    }

    public void setNext(Player next) {
        this.next = next;
    }

    public void setFirstToBid(boolean firstToBid) {
        isFirstToBid = firstToBid;
    }

    public Player() {
        this.hand = new LinkedList<>();
        this.scoreInCurrentRound = 0;
    }

    public List<Card> groupCardsInHand() {
        Map<String, List<Card>> groupedAndSorted = this.getHand().stream()
                .collect(Collectors.groupingBy(card -> card.suit().getSuitName(),
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                cards -> cards.stream()
                                        .sorted(Comparator.comparingInt(card -> -card.value().getValueCode()))
                                        .collect(Collectors.toList()))));

        List<Card> result = new ArrayList<>();
        groupedAndSorted.values().forEach(result::addAll);
        return result;
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

    public abstract int makeBid(int currentMaxBid);


    @Override
    public String toString() {
        return "Player{" +
                "hand=" + hand +
                ", scoreInCurrentRound=" + scoreInCurrentRound +
                '}';
    }

    public void setHand(List<Card> groupCardsInHand) {
        this.hand = groupCardsInHand;
    }
}
