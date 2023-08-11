package org.example.gameloop;

import org.example.bot.BotPlayer;
import org.example.enums.Suit;
import org.example.player.HumanPlayer;
import org.example.player.Player;

import java.util.HashMap;
import java.util.Map;
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
    private final TurnCycleEvaluator turnCycleEvaluator;
    private final BidManager bidManager;
    private Map<Player, Card> cardsPlayedCycle = new HashMap<>();
    private Suit gameTramp;
    private Suit firstCardsSuit;

    public GameManager(HumanPlayer humanPlayer, BotPlayer bot1, BotPlayer bot2, BotPlayer bot3, Dealer dealer,
                       Table table, Scoreboard scoreboard, Scanner scanner, TurnManager turnManager, TurnCycleEvaluator turnCycleEvaluator, BidManager bidManager) {
        this.humanPlayer = humanPlayer;
        this.bot1 = bot1;
        this.bot2 = bot2;
        this.bot3 = bot3;
        this.dealer = dealer;
        this.table = table;
        this.scoreboard = scoreboard;
        this.scanner = scanner;
        this.turnManager = turnManager;
        this.turnCycleEvaluator = turnCycleEvaluator;
        this.bidManager = bidManager;
    }

    public void start() {
        Player firstPlayerToBid = chooseFirstPlayerToBid(scanner);
        dealer.dealCardsToPlayer(humanPlayer, bot1, bot2, bot3);
        player = bidManager.determineTheBidWinner(firstPlayerToBid);
        gameTramp = player.selectTramp();
        for (int i = 0; i < 13; i++) {
            oneGameCycle();
            player = turnCycleEvaluator.findMostValuableCardsOwner(cardsPlayedCycle, gameTramp, firstCardsSuit);
            cardsPlayedCycle.clear();
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

    public void oneGameCycle() {
        System.out.println(player.getName() + " is playing ");
        Card selectedCard = player.playCard();
        firstCardsSuit = selectedCard.suit();
        cardsPlayedCycle.put(player, selectedCard);
        selectedCard = player.getNext().playCard();
        System.out.println(player.getNext().getName() + " is playing ");
        cardsPlayedCycle.put(player.getNext(), selectedCard);
        selectedCard = player.getNext().getNext().playCard();
        System.out.println(player.getNext().getNext().getName() + " is playing ");
        cardsPlayedCycle.put(player.getNext().getNext(), selectedCard);
        selectedCard = player.getNext().getNext().getNext().playCard();
        cardsPlayedCycle.put(player.getNext().getNext().getNext(), selectedCard);
        System.out.println(player.getNext().getNext().getNext().getName() + " is playing ");
        System.out.println(cardsPlayedCycle.values());
        System.out.println(player.getName());
    }
}
