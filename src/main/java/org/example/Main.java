package org.example;

import org.example.bot.BotPlayer;
import org.example.gameloop.*;
import org.example.player.HumanPlayer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameManager gameManager = initializeGamePlay();

        gameManager.start();


    }
    private static GameManager initializeGamePlay() {
        Scanner scanner = new Scanner(System.in);
        HumanPlayer humanPlayer = new HumanPlayer(scanner, "HUMAN");
        BotPlayer bot1 = new BotPlayer("Bot1");
        BotPlayer bot2 = new BotPlayer("Bot2");
        BotPlayer bot3 = new BotPlayer("Bot3");
        humanPlayer.setNext(bot1);
        bot1.setNext(bot2);
        bot2.setNext(bot3);
        bot3.setNext(humanPlayer);
        Dealer dealer = new Dealer(new Deck());
        Table table = new Table();
        Scoreboard scoreboard = new Scoreboard(humanPlayer, bot1, bot2, bot3);
        TurnCycleEvaluator turnCycleEvaluator = new TurnCycleEvaluator();
        TurnManager turnManager = new TurnManager(turnCycleEvaluator);
        BidManager bidManager = new BidManager();
        return new GameManager(humanPlayer, bot1, bot2, bot3, dealer, table, scoreboard, scanner, turnManager, turnCycleEvaluator, bidManager);
    }
}