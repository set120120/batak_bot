package org.example;

import org.example.bot.BotPlayer;
import org.example.enums.Suit;
import org.example.enums.Value;
import org.example.gameloop.Card;
import org.example.gameloop.Table;
import org.example.gameloop.TurnManager;
import org.example.player.HumanPlayer;
import org.example.player.Player;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Value k = Value.EIGHT;
        Suit j = Suit.HEARTS;
        List<Player> playerList = new LinkedList<>();
        playerList.add(new HumanPlayer(scanner, "Human"));
        playerList.add(new BotPlayer("Bot1"));
        playerList.add(new BotPlayer("Bot2"));
        playerList.add(new BotPlayer("Bot3"));
        var turnManager = new TurnManager(playerList);

//        System.out.println(turnManager.nextTurn());
//        System.out.println(turnManager.nextTurn());
//        System.out.println(turnManager.nextTurn());
//
//        System.out.println(turnManager.nextTurn());
//        System.out.println(turnManager.nextTurn());


        List<Integer> myList = Arrays.asList(4,5,5,4,5465);
        System.out.println(myList.indexOf(5465));
        System.out.println(Collections.max(myList));
        Table x = new Table();
        Card a = new Card(j, k);


    }
}