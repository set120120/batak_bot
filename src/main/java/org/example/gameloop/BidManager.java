package org.example.gameloop;

import org.example.bot.BotPlayer;
import org.example.enums.Suit;
import org.example.player.HumanPlayer;
import org.example.player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BidManager {

    private final HumanPlayer humanPlayer;
    private final BotPlayer bot1;
    private final BotPlayer bot2;
    private final BotPlayer bot3;
    private final Table table;
    private final Dealer dealer;
    private final Scanner scanner;
    private final TurnManager turnManager;
    private Player firstPlayerToBid;


    public BidManager(HumanPlayer humanPlayer, BotPlayer bot1,
                      BotPlayer bot2, BotPlayer bot3,
                      Table table, Dealer dealer, Scanner scanner, Player firstPlayerToBid,
                      TurnManager turnManager) {
        this.humanPlayer = humanPlayer;
        this.bot1 = bot1;
        this.bot2 = bot2;
        this.bot3 = bot3;
        this.table = table;
        this.dealer = dealer;
        this.scanner = scanner;
        this.firstPlayerToBid = firstPlayerToBid;
        this.turnManager = turnManager;
    }

    public Player selectPlayerToStart(HumanPlayer humanPlayer, BotPlayer bot1, BotPlayer bot2, BotPlayer bot3, Player firstPlayerToBid) {
        List<Integer> bids = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            //todo: use the flag.
            if (firstPlayerToBid.getName().equals(humanPlayer.getName())) {
                int c = humanPlayer.makeBid();
                bids.add(c);
                firstPlayerToBid = turnManager.nextTurn();
            } else if (firstPlayerToBid.getName().equals(bot1.getName())) {
                int c = bot1.makeBid();
                bids.add(c);
                firstPlayerToBid = turnManager.nextTurn();
            } else if (firstPlayerToBid.getName().equals(bot2.getName())) {
                int c = bot2.makeBid();
                bids.add(c);
                firstPlayerToBid = turnManager.nextTurn();
            } else {
                int c = bot3.makeBid();
                bids.add(c);
                firstPlayerToBid = turnManager.nextTurn();
            }
        }
        int maxBid = Collections.max(bids);
        int index = bids.indexOf(maxBid);
        for (int i = 0; i < index; i++) {
            firstPlayerToBid = turnManager.nextTurn();
        }

        return firstPlayerToBid;
    }
     public Suit selectGameTramp(Player player){
        return player.selectTramp();
     }

}
