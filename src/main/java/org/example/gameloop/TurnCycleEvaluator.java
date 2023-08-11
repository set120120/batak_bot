package org.example.gameloop;

import org.example.enums.Suit;
import org.example.player.Player;

import java.util.Comparator;
import java.util.Map;

public class TurnCycleEvaluator {

    private final ScoreManager scoreManager;

    public TurnCycleEvaluator(ScoreManager scoreManager) {
        this.scoreManager = scoreManager;
    }


    public Player getTurnWinner(Map<Player, Card> playerCardMap, Suit tramp, Suit firstCardsSuit) {
        if (isThereTramp(playerCardMap, tramp)) {
            Map.Entry<Player, Card> wantedPair = playerCardMap.entrySet().stream()
                    .filter(card -> card.getValue().suit().equals(tramp))
                    .max(Comparator.comparingInt(x -> x.getValue().value().getValueCode()))
                    .get();

            System.out.println("winner is " + wantedPair.getKey().getName());
            scoreManager.incrementPlayerScore(wantedPair.getKey());
            return wantedPair.getKey();
        } else {
            Map.Entry<Player, Card> wantedPair = playerCardMap.entrySet().stream()
                    .filter(card -> card.getValue().suit().equals(firstCardsSuit))
                    .max(Comparator.comparingInt(x -> x.getValue().value().getValueCode()))
                    .get();
            System.out.println("winner is" + wantedPair.getKey().getName());
            scoreManager.incrementPlayerScore(wantedPair.getKey());
            return wantedPair.getKey();
        }
    }

    private boolean isThereTramp(Map<Player, Card> cards, Suit tramp) {
        return !cards.values().stream()
                .filter(it -> it.suit().equals(tramp))
                .toList().isEmpty();
    }
}
