package org.example.gameloop;

import org.example.enums.Suit;
import org.example.player.Player;

import java.util.Comparator;
import java.util.Map;

public class TurnCycleEvaluator {

//    public Player determineTurnWinner(Player player, Map<Player,Card> playerCardMap, Suit tramp, Suit firstCardsSuit) {
//        player = findMostValuableCardsOwner(playerCardMap, tramp, firstCardsSuit);
//        return player;
//    }

    public Player findMostValuableCardsOwner(Map<Player, Card> playerCardMap, Suit tramp, Suit firstCardsSuit) {
        if (isThereTramp(playerCardMap, tramp)) {
            Map.Entry<Player, Card> wantedPair = playerCardMap.entrySet().stream()
                    .filter(card -> card.getValue().getSuit().equals(tramp))
                    .max(Comparator.comparingInt(x -> x.getValue().getValue().getValueCode()))
                    .get();
            System.out.println("winner is " + wantedPair.getKey().getName());
            wantedPair.getKey().setScore(wantedPair.getKey().getScore() + 1);
            return wantedPair.getKey();
        } else {
            Map.Entry<Player, Card> wantedPair = playerCardMap.entrySet().stream()
                    .filter(card -> card.getValue().getSuit().equals(firstCardsSuit))
                    .max(Comparator.comparingInt(x -> x.getValue().getValue().getValueCode()))
                    .get();
            System.out.println("winner is" + wantedPair.getKey().getName());
            wantedPair.getKey().setScore(wantedPair.getKey().getScore() + 1);
            return wantedPair.getKey();
        }
    }

    private boolean isThereTramp(Map<Player, Card> cards, Suit tramp) {
        return cards.values().stream()
                .filter(it -> it.getSuit().equals(tramp))
                .toList()
                .size() > 0;
    }
}
