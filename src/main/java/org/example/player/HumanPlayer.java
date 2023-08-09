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
        return null;
    }

    @Override
    // todo: do group by and order
    public void logHand() {
        System.out.println("Your hand: ");
        for (int i = 0; i < this.getHand().size(); i++) {
            System.out.println((i + 1) + "-) " + this.getHand().get(i));
        }
    }

    @Override
    public Card playCard() {
        Card selectedCard = getPlayerInput();
        if (getHand().contains(selectedCard)){
            System.out.println(getHand().remove(selectedCard));
            return selectedCard;
        } else {
            System.out.println("There is not selected card");
            System.out.println(selectedCard);
        }
        return playCard();
    }

    @Override
    public int makeBid() {
       return 7;

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
