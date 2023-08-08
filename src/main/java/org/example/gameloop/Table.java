package org.example.gameloop;

import java.util.ArrayList;
import java.util.LinkedList;

public class Table {

    private LinkedList<Card> playedCardsInCurrentRound = new LinkedList<>();

    public LinkedList<Card> getPlayedCardsInCurrentRound() {
        return playedCardsInCurrentRound;
    }

    public void clearCurrentTable(){
        playedCardsInCurrentRound.clear();
    }
    public void addCardCurrentRound(Card card) {
        playedCardsInCurrentRound.add(card);
    }
    public void displayCurrentTable() {
        System.out.println("Current Cards on table: ");
        for (Card card : playedCardsInCurrentRound){
            System.out.print(card.toString() + ", ");
        }
        System.out.println(".");
    }
}
