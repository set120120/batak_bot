package org.example.bot;

import org.example.enums.Suit;
import org.example.gameloop.BidConfigManager;
import org.example.gameloop.Card;
import org.example.model.BidConfig;
import org.example.player.Player;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.example.enums.Value.*;

public class BotPlayer extends Player {


    private final BidConfigManager bidConfigManager;

    public BotPlayer(String name, BidConfigManager bidConfigManager) {
        super();
        this.bidConfigManager = bidConfigManager;
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
        Card selectedCard = getHand().get(0);
        getHand().remove(selectedCard);
        logHand();
        return selectedCard;
    }

    @Override
    public Suit selectTramp() {
        return null;
    }

    @Override
    public int makeBid() {
        // todo: cannot bid equal or less than current bid if there's any
        return shouldBid();
    }

    private Optional<Integer> determineBid() {
        if (shouldBid() == 5) {
            // todo: write the algo for the bid value
            return Optional.of(6);
        } else {
            return Optional.empty();
        }
    }

    private int shouldBid() {
        Suit mostCountedSuit = findMostCountedSuit();
        int trampCount = getTrampCount(mostCountedSuit);
        int pointsFromNonTrampSuits = pointsFromNonTrampSuits(this.getHand(), mostCountedSuit);
        if (trampCount < 5) {
            return 0;
        } else if (trampCount == 5) {
            float averageOfTramp = averageOfTramp(this.getHand(), mostCountedSuit, trampCount);
            return bidConfigManager.getBidConfig().stream()
                    .filter(bidConfig -> bidConfig.getTrampCount() == 5)
                    .filter(bidConfig -> bidConfig.getAverageOfTramps().contains(averageOfTramp))
                    .filter(bidConfig -> bidConfig.getPointsFromNonTrampSuit().contains(pointsFromNonTrampSuits))
                    .map(BidConfig::getBidCount)
                    .findAny()
                    .orElseThrow(() -> new RuntimeException("No range is defined wi"));
        } else if (trampCount == 6) {
            float averageOfTramp = averageOfTramp(this.getHand(), mostCountedSuit, trampCount);
            return bidConfigManager.getBidConfig().stream()
                    .filter(bidConfig -> bidConfig.getTrampCount() == 6)
                    .filter(bidConfig -> bidConfig.getAverageOfTramps().contains(averageOfTramp))
                    .filter(bidConfig -> bidConfig.getPointsFromNonTrampSuit().contains(pointsFromNonTrampSuits))
                    .map(BidConfig::getBidCount)
                    .findAny()
                    .orElseThrow(() -> new RuntimeException("No range is defined for trampCount " + trampCount + "" +
                            "and averageOfTramps: " + averageOfTramp + "and pointsFromNonTrampSuits: " + pointsFromNonTrampSuits));
        } else if (trampCount == 7) {
            float averageOfTramp = averageOfTramp(this.getHand(), mostCountedSuit, trampCount);
            return bidConfigManager.getBidConfig().stream()
                    .filter(bidConfig -> bidConfig.getTrampCount() == 7)
                    .filter(bidConfig -> bidConfig.getAverageOfTramps().contains(averageOfTramp))
                    .filter(bidConfig -> bidConfig.getPointsFromNonTrampSuit().contains(pointsFromNonTrampSuits))
                    .map(BidConfig::getBidCount)
                    .findAny()
                    .orElseThrow(() -> new RuntimeException("No range is defined for trampCount " + trampCount + "" +
                            "and averageOfTramps: " + averageOfTramp + "and pointsFromNonTrampSuits: " + pointsFromNonTrampSuits));
        } else {
            if (isThereAce(this.getHand())){
                return trampCount;
            } else {
                return trampCount - 1;
            }
        }
    }

    private int getTrampCount(Suit mostCountedSuit) {
        return this.getHand().stream()
                .filter(x -> x.suit() == mostCountedSuit)
                .toList()
                .size();
    }


    private float averageOfTramp(List<Card> cards, Suit tramp, int countOfTramp) {
        int sumOfValues = cards.stream()
                .filter(x -> x.suit() == tramp)
                .mapToInt(x -> x.value().getValueCode())
                .sum();
        return (float) sumOfValues / countOfTramp;
    }

    // 5
    private int pointsFromNonTrampSuits(List<Card> cards, Suit tramp) {
        int point = 0;
        Map<Suit, List<Card>> myHandWithNonTramp = cards.stream().filter(x -> x.suit() != tramp)
                .collect(Collectors.groupingBy(Card::suit));
        boolean isAceFound;
        boolean isKingFound;
        for (Map.Entry<Suit, List<Card>> entry : myHandWithNonTramp.entrySet()) {
            isAceFound = false;
            isKingFound = false;
            if (entry.getValue().size() == 1) {
                point += 1;
                if (entry.getValue().get(0).value().getValueCode() == ACE.getValueCode()) {
                    point += 3;
                }
                continue;
            }
            for (Card card : entry.getValue()) {
                if (card.value().getValueCode() == ACE.getValueCode()) {
                    point += 3;
                    isAceFound = true;
                } else if (card.value().getValueCode() == KING.getValueCode()) {
                    point += 2;
                    if (isAceFound) {
                        point += 1;
                    }
                    isKingFound = true;
                } else if (card.value().getValueCode() == QUEEN.getValueCode()) {
                    point += 1;
                    if (isAceFound) {
                        point += 1;
                    }
                    if (isKingFound) {
                        point += 1;
                    }
                } else if (card.value().getValueCode() == JACK.getValueCode() && isAceFound) {
                    point += 1;
                }
            }
        }
        if (myHandWithNonTramp.size() == 2) {
            point += 3;
        } else if (myHandWithNonTramp.size() == 1) {
            point += 6;
        }
        return point;
    }

    private Suit findMostCountedSuit() {
        Map<Suit, Long> suitCount =
                this.getHand()
                        .stream()
                        .collect(Collectors.groupingBy(Card::suit, Collectors.counting()));

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
    private boolean isThereAce(List<Card> cards) {
        return cards.stream()
                .filter(card -> card.value() == ACE)
                .toList()
                .size() > 0;
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
