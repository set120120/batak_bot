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
    private Player player;
    private final Table table;
    private final Dealer dealer;
    private final Scoreboard scoreboard;
    private final Scanner scanner;
    private final TurnManager turnManager;
    private final BidManager bidManager;

    public GameManager(HumanPlayer humanPlayer, BotPlayer bot1, BotPlayer bot2, BotPlayer bot3, Dealer dealer,
                       Table table, Scoreboard scoreboard, Scanner scanner, TurnManager turnManager, BidManager bidManager) {
        this.humanPlayer = humanPlayer;
        this.bot1 = bot1;
        this.bot2 = bot2;
        this.bot3 = bot3;
        this.dealer = dealer;
        this.table = table;
        this.scoreboard = scoreboard;
        this.scanner = scanner;
        this.turnManager = turnManager;
        this.bidManager = bidManager;
    }

    public void start() {
        chooseFirstPlayerToBid(scanner);
        dealer.dealCardsToPlayer(humanPlayer, bot1, bot2, bot3);
        player = bidManager.determineTheBidWinner();
//        humanPlayer.logHand();
//        bot1.logHand();
//        bot2.logHand();
//        bot3.logHand();
        Suit gameTramp = bidManager.selectGameTramp(player);
        oneGameCycle();
        humanPlayer.logHand();
        bot1.logHand();
        bot2.logHand();
        bot3.logHand();
        player.logHand();
       // Suit gameTramp = player.selectTramp();
    }

    private void chooseFirstPlayerToBid(Scanner scanner) {
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
            }
            case "2" -> {
                bot1.setFirstToBid(true);
                System.out.println("Bot1 player goes first to bid.");
            }
            case "3" -> {
                bot2.setFirstToBid(true);
                System.out.println("Bot2 goes bid first to bid.");
            }
            default -> {
                bot3.setFirstToBid(true);
                System.out.println("Bot3 goes bid first to bid");
            }
        }
    }

    private void playTurnHuman() {
        System.out.println("*********************Human Player Turn*****************");
        table.displayCurrentTable();

        Card playedCard = humanPlayer.playCard();
        turnManager.nextTurnForGame();
    }

    private void playTurnBot(BotPlayer bot) {
        System.out.println("*********************" + bot.getName() + " Turn*****************");
        table.displayCurrentTable();

        Card playedCard = bot.playCard();
        turnManager.nextTurnForGame();
    }

    public void oneGameCycle() {
        for (int i = 0; i<4; i++){
            player.playCard();
           // player.logHand();
            turnManager.nextTurnForGame();
        }
        System.out.println("adadawsda");
    }

}
