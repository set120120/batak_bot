package org.example.player;

import org.example.enums.Suit;
import org.example.gameloop.Card;

import java.util.Scanner;

public class HumanPlayer extends Player {

    private final Scanner scanner;

    public HumanPlayer(Scanner scanner, String name) {
        super();
        this.scanner = scanner;
        this.name = name;
    }


    @Override
    public Suit selectTramp() {
        logHand();
        System.out.println("""
                Human is the bid winner.\s
                Please select your tramp\s
                '1' for 'HEARTS', '2' for 'SPADES', '3' for 'CLUB' and '4' for 'DIAMONDS'""");
        int input = scanner.nextInt();

        while (input != 1 && input != 2 && input != 3 && input != 4) {
            System.out.println("Invalid input. Please enter '1' for Human or '2' for Bot1. '3' for Bot2. '4' for Bot3");
            input = scanner.nextInt();
        }

        if (input == 1) {
            return Suit.HEARTS;
        } else if (input == 2) {
            return Suit.SPADES;
        } else if (input == 3) {
            return Suit.CLUBS;
        } else {
            return Suit.DIAMONDS;
        }
    }

    @Override
    public void logHand() {
        System.out.println("Your hand: ");
        for (int i = 0; i < this.getHand().size(); i++) {
            System.out.println((i + 1) + "-) " + this.getHand().get(i));
        }
    }

    @Override
    public Card playCard(Suit tramp) {
        Card selectedCard = getPlayerInput();
        if (getHand().contains(selectedCard)) {
            getHand().remove(selectedCard);
            return selectedCard;
        } else {
            System.out.println("There is not selected card");
            System.out.println(selectedCard);
        }
        return playCard(tramp);
    }

    @Override
    public int makeBid(int currentMaxBid) {
        System.out.println("Enter the number to make bid.");
        int bid = scanner.nextInt();
        while (bid == currentMaxBid && bid != 0) {
            System.out.println("You cannot make a bid is equal to current max bid. " +
                    "Please increase your bid or enter '0' to say pas");
            bid = scanner.nextInt();
        }
        System.out.println("Human is bidding " + bid);
        return bid > currentMaxBid ? bid : 0;
    }

    @Override
    public String toString() {
        return "HumanPlayer{hand=" + hand + "}";
    }

    private Card getPlayerInput() {
        logHand();

        System.out.println("Enter the number corresponding to the card you want to play:");
        int cardIndex = scanner.nextInt() - 1;

        if (cardIndex < 0 || cardIndex >= getHand().size()) {
            System.out.println("Invalid selection. Please enter a number between 1 and " + hand.size());
            return getPlayerInput();
        }

        return getHand().get(cardIndex);
    }
}
