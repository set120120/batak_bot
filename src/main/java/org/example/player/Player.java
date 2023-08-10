package org.example.player;

import org.example.enums.Suit;
import org.example.gameloop.Card;

import java.util.*;
import java.util.stream.Collectors;

public abstract class Player {

    private Player next;
    private boolean isFirstToBid;

    private boolean isFirstToPlay;
    // todo: isFirstToBid isFirstToPlay olarak ayıralım
    protected String name;
    protected List<Card> hand;
    protected int scoreInCurrentRound = 0;

    public Player getNext() {
        return next;
    }

    public void setNext(Player next) {
        this.next = next;
    }

    public Player() {
        this.isFirstToBid = false;
        this.isFirstToPlay = false;
        this.hand = new LinkedList<>();
        this.scoreInCurrentRound = 0;
    }

    public List<Card> groupCardsInHand() {
        Map<String, List<Card>> groupedAndSorted = this.getHand().stream()
                .collect(Collectors.groupingBy(card -> card.getSuit().getSuitName(),
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                cards -> cards.stream()
                                        .sorted(Comparator.comparingInt(card -> -card.getValue().getValueCode()))  // Ters sıralama
                                        .collect(Collectors.toList()))));

        List<Card> result = new ArrayList<>();  // Create a modifiable list
        groupedAndSorted.values().forEach(result::addAll);  // Add the sorted cards to the result list
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


    public void setFirstToBid(boolean isFirstToBid) {
        this.isFirstToBid = isFirstToBid;
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

    public void setHand(List<Card> groupCardsInHand) {
        this.hand = groupCardsInHand;
    }
}
