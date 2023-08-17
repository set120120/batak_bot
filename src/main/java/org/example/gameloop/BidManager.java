package org.example.gameloop;

import org.example.player.Player;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class BidManager {

    private final TurnManager turnManager;

    public BidManager(TurnManager turnManager) {
        this.turnManager = turnManager;
    }


    public Player determineTheBidWinner(Player player) {
        Map<Player, Integer> allBids = takeAllBids(player);
        System.out.println(allBids);
        Map.Entry<Player, Integer> playerWhoBidMax = allBids.entrySet().stream().max(Map.Entry.comparingByValue())
                .orElseThrow(() -> new RuntimeException("No max bid found"));
        System.out.println(allBids);

        if (playerWhoBidMax.getValue() == 0) {
            System.out.println("No one make bid. Therefore, the bid went to " + player.getName() + ".");
            return player;
        }
        System.out.println("Bid winner is " + playerWhoBidMax.getKey().getName());
        return playerWhoBidMax.getKey();
    }


    private Map<Player, Integer> takeAllBids(Player currentPlayer) {
        Map<Player, Integer> bidsByPlayers = new HashMap<>();

        int currentMaxBid = currentPlayer.makeBid(4);
        bidsByPlayers.put(currentPlayer, currentMaxBid);

        Player secondPlayer = turnManager.getNextPlayer(currentPlayer);

        bidsByPlayers.put(secondPlayer, secondPlayer.makeBid(currentMaxBid));
        currentMaxBid = getCurrentMaxBid(bidsByPlayers);

        Player thirdPlayer = turnManager.getNextPlayer(secondPlayer);

        bidsByPlayers.put(thirdPlayer, thirdPlayer.makeBid(currentMaxBid));
        currentMaxBid = getCurrentMaxBid(bidsByPlayers);

        Player fourthPlayer = turnManager.getNextPlayer(thirdPlayer);

        bidsByPlayers.put(fourthPlayer, fourthPlayer.makeBid(currentMaxBid));
        return bidsByPlayers;
    }

    private int getCurrentMaxBid(Map<Player, Integer> bidsByPlayers) {
        return bidsByPlayers.values().stream()
                .sorted(Comparator.comparingInt(card -> -card))
                .toList()
                .get(0);
    }
}
