package org.example.gameloop;

import org.example.bot.BotPlayer;
import org.example.enums.Suit;
import org.example.player.HumanPlayer;
import org.example.player.Player;

import java.util.Scanner;

public class OneGameCycle {
    private final HumanPlayer humanPlayer;
    private final BotPlayer bot1;
    private final BotPlayer bot2;
    private final BotPlayer bot3;
    private final Table table;
    private final Dealer dealer;
    private final Scoreboard scoreboard;
    private final Scanner scanner;
    private TurnManager turnManager;
    private Player firstPlayerToStart;
    private Player currentPlayer;
    private final Suit currentTramp;

    public OneGameCycle(HumanPlayer humanPlayer, BotPlayer bot1, BotPlayer bot2, Scanner scanner,
                        BotPlayer bot3, Table table, Dealer dealer, Scoreboard scoreboard,
                        TurnManager turnManager, Player firstPlayerToStart, Player currentPlayer, Suit currentTramp) {
        this.humanPlayer = humanPlayer;
        this.bot1 = bot1;
        this.bot2 = bot2;
        this.bot3 = bot3;
        this.table = table;
        this.dealer = dealer;
        this.scoreboard = scoreboard;
        this.scanner = scanner;
        this.turnManager = turnManager;
        this.firstPlayerToStart = firstPlayerToStart;
        this.currentPlayer = currentPlayer;
        this.currentTramp = currentTramp;
    }



    public void oneCycle(){
        for (int i = 0; i< 4; i++){

        }
    }


}
