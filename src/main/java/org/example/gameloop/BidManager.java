package org.example.gameloop;

import org.example.bot.BotPlayer;
import org.example.enums.Suit;
import org.example.player.HumanPlayer;
import org.example.player.Player;

import java.util.*;

public class BidManager {

    private final HumanPlayer humanPlayer;
    private final BotPlayer bot1;
    private final BotPlayer bot2;
    private final BotPlayer bot3;
    private final TurnManager turnManager;


    public BidManager(HumanPlayer humanPlayer, BotPlayer bot1,
                      BotPlayer bot2, BotPlayer bot3,
                      TurnManager turnManager) {
        this.humanPlayer = humanPlayer;
        this.bot1 = bot1;
        this.bot2 = bot2;
        this.bot3 = bot3;
        this.turnManager = turnManager;
    }

    public Player determineTheBidWinner() {
        Map<Player, Integer> bidByPlayer = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            //todo: use the flag.
            if (humanPlayer.isFirst()) {
                bidByPlayer.put(humanPlayer, humanPlayer.makeBid());
                turnManager.nextTurn();
            } else if (bot1.isFirst()) {
                bidByPlayer.put(bot1, bot1.makeBid());
                turnManager.nextTurn();
            } else if (bot2.isFirst()) {
                bidByPlayer.put(bot2, bot2.makeBid());
                turnManager.nextTurn();
            } else if (bot3.isFirst()) {
                bidByPlayer.put(bot3, bot3.makeBid());
                turnManager.nextTurn();
            }
        }
        Map.Entry<Player, Integer> playerWhoBidMax = bidByPlayer.entrySet().stream().max(Map.Entry.comparingByValue())
                .orElseThrow(() -> new RuntimeException("No max bid found"));
        return turnManager.setFirstPlayer(playerWhoBidMax.getKey());
    }

    public Suit selectGameTramp(Player player) {
        return player.selectTramp();
    }

}
