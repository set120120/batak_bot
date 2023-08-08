package org.example.gameloop;

import org.example.player.Player;

public record Dealer(Deck deck) {

    public void dealCardsToPlayer(Player player) {
        deck.shuffle();

        if (player.isHandEmpty() && !deck.isEmpty()) {
            for (int i = 0; i < 13; i++) {
                player.addToHand(deck.draw());
            }
        }
    }
    public void logDeckSize() {
        System.out.println("Remaining number of cards in deck: " + this.deck.getCards().size());
    }
}
