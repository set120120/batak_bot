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
        System.out.println("IMPLEMENTE ETTT");
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
        return null;
    }

    @Override
    public int makeBid() {
       return 5;

    }

    @Override
    public String toString() {
        return "HumanPlayer{hand=" + hand + "}";
    }
}
