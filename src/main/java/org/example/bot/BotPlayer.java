package org.example.bot;

import org.example.enums.Suit;
import org.example.gameloop.Card;
import org.example.player.Player;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class BotPlayer extends Player {

    public BotPlayer(String name) {
        super();
        this.name = name;
    }


    @Override
    public void logHand() {
        System.out.println(this.getName() + "'s hand: ");
        for (int i = 0; i < this.getHand().size(); i++) {
            System.out.println((i + 1) + "-) " + this.getHand().get(i));
        }
    }

    @Override
    public Card playCard() {
        return null;
    }

    @Override
    public Suit selectTramp() {
        return null;
    }

    @Override
    public int makeBid() {
        // todo: cannot bid equal or less than currentbid if there's any
        return determineBid().orElse(4);
    }

    private Optional<Integer> determineBid() {
        if (shouldBid()) {
            // todo: write the algo for the bid value
            return Optional.of(6);
        } else {
            return Optional.empty();
        }
    }

    private boolean shouldBid() {
        Suit mostCountedSuit = findMostCountedSuit();

        int handValueSum = this.getHand()
                .stream()
                .filter(it -> it.getSuit() == mostCountedSuit)
                .mapToInt(it -> it.getValue().getValueCode())
                .sum();

        // todo: Find a good threshold
        return handValueSum >= 50;
    }

    private Suit findMostCountedSuit() {
        Map<Suit, Long> suitCount =
                this.getHand()
                        .stream()
                        .collect(Collectors.groupingBy(Card::getSuit, Collectors.counting()));

        long max = 0;
        Suit suit = null;
        for (Map.Entry<Suit, Long> entry : suitCount.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                suit = entry.getKey();
            }
        }
        return suit;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "BotPlayer{" +
                "name='" + name + '\'' +
                ", hand=" + hand +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BotPlayer botPlayer)) return false;
        return getName().equals(botPlayer.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
