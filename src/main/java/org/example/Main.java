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
        //String name = scanner.nextLine();
        BidConfigManager bidConfigManager = new BidConfigManager();
        Table table = new Table();
        HumanPlayer humanPlayer = new HumanPlayer(scanner, "HUMAN");
//        var bot1c = new CardProbabilityManager();
//        var bot2c = new CardProbabilityManager();
//        var bot3c = new CardProbabilityManager();

        BotPlayer bot1 = new BotPlayer("Bot1", bidConfigManager, table);
        BotPlayer bot2 = new BotPlayer("Bot2", bidConfigManager, table);
        BotPlayer bot3 = new BotPlayer("Bot3", bidConfigManager, table);
//        bot1.getCardProbabilityManager().setOpponentsAccordingToPlayer(List.of(humanPlayer,bot2, bot3));
//        bot2.getCardProbabilityManager().setOpponentsAccordingToPlayer(List.of(humanPlayer,bot1, bot3));
//        bot3.getCardProbabilityManager().setOpponentsAccordingToPlayer(List.of(humanPlayer,bot1, bot2));
        humanPlayer.setNext(bot1);
        bot1.setNext(bot2);
        bot2.setNext(bot3);
        bot3.setNext(humanPlayer);
        Dealer dealer = new Dealer(new Deck());
        ScoreManager scoreManager = new ScoreManager(humanPlayer, bot1, bot2, bot3);
        TurnCycleEvaluator turnCycleEvaluator = new TurnCycleEvaluator(scoreManager);
        TurnManager turnManager = new TurnManager();
        BidManager bidManager = new BidManager(turnManager);
        return new GameManager(humanPlayer, bot1, bot2, bot3, dealer, table, scanner, turnManager, turnCycleEvaluator, bidManager);
    }
}