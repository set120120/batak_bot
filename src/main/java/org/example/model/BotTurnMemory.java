package org.example.model;

import org.example.gameloop.Card;
import org.example.player.Player;

public final class BotTurnMemory {

    private Player player;

    private Card card;
    public BotTurnMemory() {
    }

    public BotTurnMemory(Player player, Card card) {
        this.player = player;
        this.card = card;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }




    @Override
    public String toString() {
        return "BotTurnMemory{" +
                "player=" + player.getName() +
                ", card=" + card +
                '}';
    }
}
