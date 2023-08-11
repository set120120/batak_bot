package org.example.gameloop;

import org.example.bot.BotPlayer;
import org.example.enums.Suit;
import org.example.player.HumanPlayer;
import org.example.player.Player;

import java.util.Scanner;

public class GameManager {
    private final HumanPlayer humanPlayer;
    private final BotPlayer bot1;
    private final BotPlayer bot2;
    private final BotPlayer bot3;
    private final Table table;
    private final Dealer dealer;
    private final Scanner scanner;
    private final TurnManager turnManager;
    private final TurnCycleEvaluator turnCycleEvaluator;
    private final BidManager bidManager;

    public GameManager(HumanPlayer humanPlayer, BotPlayer bot1, BotPlayer bot2, BotPlayer bot3, Dealer dealer,
                       Table table, Scanner scanner, TurnManager turnManager, TurnCycleEvaluator turnCycleEvaluator, BidManager bidManager) {
        this.humanPlayer = humanPlayer;
        this.bot1 = bot1;
        this.bot2 = bot2;
        this.bot3 = bot3;
        this.dealer = dealer;
        this.table = table;
        this.scanner = scanner;
        this.turnManager = turnManager;
        this.turnCycleEvaluator = turnCycleEvaluator;
        this.bidManager = bidManager;
    }

    public void start() {
        Player firstPlayerToBid = chooseFirstPlayerToBid(scanner);
        dealer.dealCardsToPlayer(humanPlayer, bot1, bot2, bot3);
        Player firstPlayer = bidManager.determineTheBidWinner(firstPlayerToBid);
        Suit selectedTramp = firstPlayer.selectTramp();
        for (int i = 0; i < 13; i++) {
            gameTurn(firstPlayer);
            firstPlayer = turnCycleEvaluator.getTurnWinner(table.getPlayedCardsInCurrentRound(), selectedTramp, table.getFirstCardPlayed().suit());
            table.clearCurrentTable();
        }
        System.out.println("game finished");
    }

    private Player chooseFirstPlayerToBid(Scanner scanner) {
        System.out.println("Who should go first? Enter '1' for Human or '2' for Bot1. '3' Bot2. '4' for Bot3.");
        String input = scanner.nextLine();
        while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
            System.out.println("Invalid input. Please enter '1' for Human or '2' for Bot1. '3' for Bot2. '4' for Bot3");
            input = scanner.nextLine();
        }
        switch (input) {
            case "1" -> {
                humanPlayer.setFirstToBid(true);
                System.out.println("Human player goes first to bid.");
                return humanPlayer;
            }
            case "2" -> {
                bot1.setFirstToBid(true);
                System.out.println("Bot1 player goes first to bid.");
                return bot1;
            }
            case "3" -> {
                bot2.setFirstToBid(true);
                System.out.println("Bot2 goes bid first to bid.");
                return bot2;
            }
            default -> {
                bot3.setFirstToBid(true);
                System.out.println("Bot3 goes bid first to bid");
                return bot3;
            }
        }
    }

    public void gameTurn(Player playerWhoGoesFirst) {
        System.out.println(playerWhoGoesFirst.getName() + " is playing ");
        Card selectedCard = playerWhoGoesFirst.playCard();
        table.addCardCurrentRound(playerWhoGoesFirst, selectedCard);

        Player secondPlayer = turnManager.getNextPlayer(playerWhoGoesFirst);
        System.out.println(secondPlayer.getName() + " is playing ");
        table.addCardCurrentRound(secondPlayer, secondPlayer.playCard());

        Player thirdPlayer = turnManager.getNextPlayer(secondPlayer);
        System.out.println(thirdPlayer.getName() + " is playing ");
        selectedCard = playerWhoGoesFirst.getNext().getNext().playCard();
        table.addCardCurrentRound(thirdPlayer, selectedCard);

        Player lastPlayer = turnManager.getNextPlayer(thirdPlayer);
        System.out.println(lastPlayer.getName() + " is playing");
        table.addCardCurrentRound(lastPlayer, lastPlayer.playCard());
        table.displayCurrentTable();
    }
}
