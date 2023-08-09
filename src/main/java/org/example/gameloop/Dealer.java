package org.example.gameloop;

import org.example.player.Player;

public record Dealer(Deck deck) {

//    public void dealCardsToPlayer(HumanPlayer player, BotPlayer bot1, BotPlayer bot2, BotPlayer bot3) {
//        deck.shuffle();
//
//        for (int i = 0; i < 13; i++) {
//            player.addToHand(deck.draw());
//        }
//        for (int i = 0; i < 13; i++) {
//            bot1.addToHand(deck.draw());
//        }
//        for (int i = 0; i < 13; i++) {
//            bot2.addToHand(deck.draw());
//        }
//        for (int i = 0; i < 13; i++) {
//            bot3.addToHand(deck.draw());
//        }
//        player.setHand(player.groupCardsInHand());
//        bot1.setHand(bot1.groupCardsInHand());
//        bot2.setHand(bot2.groupCardsInHand());
//        bot3.setHand(bot3.groupCardsInHand());
//    }


    public void dealCardsToPlayer(Player... players) {
        deck.shuffle();

        for (Player player : players) {
            for (int i = 0; i < 13; i++) {
                player.addToHand(deck.draw());
            }
            player.setHand(player.groupCardsInHand());
        }
    }
}
