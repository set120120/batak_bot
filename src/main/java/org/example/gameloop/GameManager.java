package org.example.gameloop;

import org.example.bot.BotPlayer;
import org.example.enums.Suit;
import org.example.model.BotTurnMemory;
import org.example.player.HumanPlayer;
import org.example.player.Player;

import java.util.List;
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
        for (int turnSequence = 0; turnSequence < 13; turnSequence++) {
            gameTurn(firstPlayer, selectedTramp, turnSequence + 1);
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

    public void gameTurn(Player playerWhoGoesFirst, Suit tramp, int turnSequence) {

        Card firstPlayerCard = playerWhoGoesFirst.playCard(tramp);
        table.addCardCurrentRound(playerWhoGoesFirst, firstPlayerCard);
        table.displayCurrentTable();

        BotTurnMemory first = new BotTurnMemory(playerWhoGoesFirst, firstPlayerCard);

        Player secondPlayer = turnManager.getNextPlayer(playerWhoGoesFirst);
        Card secondPlayerCard = secondPlayer.playCard(tramp);
        table.addCardCurrentRound(secondPlayer, secondPlayerCard);
        table.displayCurrentTable();

        BotTurnMemory second = new BotTurnMemory(secondPlayer, secondPlayerCard);


        Player thirdPlayer = turnManager.getNextPlayer(secondPlayer);
        Card thirdPlayerCard = thirdPlayer.playCard(tramp);
        table.addCardCurrentRound(thirdPlayer, thirdPlayerCard);
        table.displayCurrentTable();

        BotTurnMemory third = new BotTurnMemory(thirdPlayer, thirdPlayerCard);


        Player lastPlayer = turnManager.getNextPlayer(thirdPlayer);
        Card lastPlayerCard = lastPlayer.playCard(tramp);
        table.addCardCurrentRound(lastPlayer, lastPlayerCard);
        table.displayCurrentTable();

        BotTurnMemory last = new BotTurnMemory(lastPlayer, lastPlayerCard);

        List<BotTurnMemory> cards = List.of(first,second,third,last);
        bot1.addCardToMemory(turnSequence, cards);
        bot2.addCardToMemory(turnSequence, cards);
        bot3.addCardToMemory(turnSequence, cards);

        System.out.println("bot 3 memory is: " + bot3.getTurnMemory());

    }
}
