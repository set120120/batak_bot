package org.example.bot;

import org.example.enums.Suit;
import org.example.gameloop.BidConfigManager;
import org.example.gameloop.Card;
import org.example.gameloop.Table;
import org.example.model.BidConfig;
import org.example.player.Player;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.example.enums.Value.*;

public class BotPlayer extends Player {

    private final BidConfigManager bidConfigManager;
    private final Table table;

    public BotPlayer(String name, BidConfigManager bidConfigManager, Table table) {
        super();
        this.bidConfigManager = bidConfigManager;
        this.table = table;
        this.name = name;
    }

    @Override
    public void logHand() {
        System.out.println(this.getName() + "'s hand: ");
        for (int i = 0; i < this.getHand().size(); i++) {
            System.out.println((i + 1) + "-) " + this.getHand().get(i));
        }
    }

     //Functions for gameplay.
    private List<Card> sortCards(List<Card> cards) {
        return cards.stream()
                .sorted(Comparator.comparingInt(card -> card.value().getValueCode()))
                .toList();
    }
    private List<Card> filterForASpecificSuit(List<Card> cards, Suit suit) {
        return cards.stream()
                .filter(card -> card.suit() == suit)
                .toList();
    }
    private List<Card> filterAndSortForSuit(List<Card> cards, Suit suit) {
        return cards.stream()
                .filter(card -> card.suit() == suit)
                .sorted(Comparator.comparingInt(card -> card.value().getValueCode()))
                .toList();
    }

    private List<Card> bigCards(List<Card> cards, Card maxCard) {
        return cards.stream()
                .filter(card -> card.value().getValueCode() > maxCard.value().getValueCode())
                .toList();
    }
    private List<Card> sortedBigCards(List<Card> cards, Card maxCard) {
        return cards.stream()
                .filter(card -> card.value().getValueCode() > maxCard.value().getValueCode())
                .sorted(Comparator.comparingInt(card -> card.value().getValueCode()))
                .toList();
    }
    @Override
    public Card playCard(Suit tramp) {
        if (table.getPlayedCardsInCurrentRound().isEmpty()) { // if there is no card on table play first card
            Card selectedCard = getHand().get(0);
            getHand().remove(selectedCard);
            logHand();
            return selectedCard;
        }
        int indexOfCurrentPlayer = table.getPlayedCardsInCurrentRound().size();

        Card topCard = table.getFirstCardOnTable().get();

        boolean isThereFirstSuit = true;

        List<Card> cardsCanPlayed = filterForASpecificSuit(this.getHand(), topCard.suit());

        if (cardsCanPlayed.isEmpty()) {                        // if there is no any card you have to play with tramp
            cardsCanPlayed = filterForASpecificSuit(this.getHand(), tramp);
            isThereFirstSuit = false;
        }
        if (cardsCanPlayed.isEmpty()) { // if there is no tramp you have to play the lower card
            Card selectedCard = this.getHand().stream()
                    .min(Comparator.comparingInt(card -> card.value().getValueCode())).get();
            getHand().remove(selectedCard);
            logHand();
            return selectedCard;
        }

        if (!table.isThereAnyTrampOnTable(tramp)) { // if no-one played with tramp that
                                                    // means everyone played hearts while tramp is club
            if (isThereFirstSuit) { // if I have first suit
                Card maxCard = table.getPlayedCardsInCurrentRound().values().stream()
                        .max(Comparator.comparingInt(card -> card.value().getValueCode()))
                        .get();

                List<Card> biggerCards = bigCards(cardsCanPlayed, maxCard);

                if (biggerCards.isEmpty()) {
                    Card selectedCard = sortCards(cardsCanPlayed).get(0);
                    getHand().remove(selectedCard);
                    logHand();
                    return selectedCard;
                }
                if (indexOfCurrentPlayer != 3){
                    Card selectedCard = biggerCards.get(0);
                    getHand().remove(selectedCard);
                    logHand();
                    return selectedCard;
                } else {
                    Card selectedCard = biggerCards.stream()
                            .min(Comparator.comparingInt(card -> card.value().getValueCode())).get();
                    getHand().remove(selectedCard);
                    logHand();
                    return selectedCard;
                }

            } else {
                Card selectedCard = cardsCanPlayed.stream()
                        .min(Comparator.comparingInt(card-> card.value().getValueCode())).get();
                getHand().remove(selectedCard);
                logHand();
                return selectedCard;
            }


        } else { // someone played tramp
            if (isThereFirstSuit) {
                if (topCard.suit() != tramp) { // if the first card's suit is not tramp I should play with low as much as possible
                    Card selectedCard = sortCards(cardsCanPlayed).get(0);
                    getHand().remove(selectedCard);
                    logHand();
                    return selectedCard;
                }
                else { // if the first card is tramp
                    Card maxTrampPlayed = table.getPlayedCardsInCurrentRound().values().stream()
                            .filter(card -> card.suit() == tramp)
                            .max(Comparator.comparingInt(card -> card.value().getValueCode())).get();

                    List<Card> biggerCards = sortedBigCards(cardsCanPlayed, maxTrampPlayed);

                    if (!biggerCards.isEmpty()) {
                        Card selectedCard = biggerCards.get(0);
                        getHand().remove(selectedCard);
                        logHand();
                        return selectedCard;
                    }
                    Card selectedCard = sortCards(cardsCanPlayed).get(0);
                    getHand().remove(selectedCard);
                    logHand();
                    return selectedCard;
                }
            }
            List<Card> biggerCards = filterAndSortForSuit(cardsCanPlayed, tramp);
            if (!biggerCards.isEmpty()) {
                Card selectedCard = biggerCards.get(0);
                getHand().remove(selectedCard);
                logHand();
                return selectedCard;
            }
            Card selectedCard = sortCards(cardsCanPlayed).get(0);
            getHand().remove(selectedCard);
            logHand();
            return selectedCard;
        }
    }

    private boolean isThereCardWithCurrentSuit(Suit suit) {
        return this.getHand().stream()
                .filter(it -> it.suit() == suit)
                .toList().isEmpty();
    }

    // Functions for bidding.

    @Override
    public Suit selectTramp() {
        Suit mostCountedSuit = findMostCountedSuit();
        System.out.println("Selected Tramp is: " + mostCountedSuit);
        return mostCountedSuit;
    }

    @Override
    public int makeBid(int currentMaxBid) {
        int bid = determineBidCount();
        System.out.println(this.getName() + " is bidding :" + determineBidCount());
        return bid > currentMaxBid ? bid : 0;
    }

    private int determineBidCount() {
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
            if (isThereAce(this.getHand())) {
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

    private float increaseAverageOfTramp(List<Card> cards, Suit tramp) {
        List<Card> tramps = cards.stream()
                .filter(card -> card.suit() == tramp)
                .toList();
        boolean isAceFound = false;
        boolean isKingFound = false;
        float increaseAmount = 0F;
        for (Card card : tramps) {
            if (card.value().getValueCode() == ACE.getValueCode()) {
                increaseAmount += 0.30F;
                isAceFound = true;
            } else if (card.value().getValueCode() == KING.getValueCode()) {
                increaseAmount += 0.15F;
                isKingFound = true;
                if (isAceFound) {
                    increaseAmount += 0.15F;
                }
            } else if (card.value().getValueCode() == QUEEN.getValueCode()) {
                increaseAmount += 0.10F;
                if (isAceFound) {
                    increaseAmount += 0.10F;
                }
                if (isKingFound) {
                    increaseAmount += 0.05F;
                    if (isAceFound) {
                        increaseAmount += 0.20F;
                    }
                }

            }
        }

        return increaseAmount;
    }

    private float averageOfTramp(List<Card> cards, Suit tramp, int countOfTramp) {
        int sumOfValues = cards.stream()
                .filter(x -> x.suit() == tramp)
                .mapToInt(x -> x.value().getValueCode())
                .sum();
        return ((float) sumOfValues / countOfTramp) + increaseAverageOfTramp(cards, tramp);
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
        return this.getHand().stream()
                .collect(Collectors.groupingBy(Card::suit, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .get()
                .getKey();
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
