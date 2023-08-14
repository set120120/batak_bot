package org.example.gameloop;

import org.example.enums.Suit;
import org.example.player.Player;

import java.util.HashMap;
import java.util.Map;

public class BidManager {

    public BidManager() {
    }

    public Player determineTheBidWinner(Player player) {
        Map<Player, Integer> allBids = takeAllBids(player);
        System.out.println(allBids);
        Map.Entry<Player, Integer> playerWhoBidMax = allBids.entrySet().stream().max(Map.Entry.comparingByValue())
                .orElseThrow(() -> new RuntimeException("No max bid found"));
        System.out.println(allBids);
        System.out.println("Bid winner is " + playerWhoBidMax.getKey().getName());
        return playerWhoBidMax.getKey();
    }

    public Suit selectGameTramp(Player player) {
        return player.selectTramp();
    }


    private Map<Player, Integer> takeAllBids(Player player) {
        Map<Player, Integer> bidsByPlayers = new HashMap<>();
        bidsByPlayers.put(player, player.makeBid());
        bidsByPlayers.put(player.getNext(), player.getNext().makeBid());
        bidsByPlayers.put(player.getNext().getNext(), player.getNext().getNext().makeBid());
        bidsByPlayers.put(player.getNext().getNext().getNext(), player.getNext().getNext().getNext().makeBid());
        return bidsByPlayers;
    }

}
