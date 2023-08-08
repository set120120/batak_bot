package org.example.gameloop;

import org.example.bot.BotPlayer;
import org.example.player.HumanPlayer;
import org.example.player.Player;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Scoreboard {

    private final Map<Player, Integer> scores;

    public Scoreboard(HumanPlayer human, BotPlayer bot1, BotPlayer bot2, BotPlayer bot3) {
        this.scores = new HashMap<>();
        this.scores.put(human, 0);
        this.scores.put(bot1, 0);
        this.scores.put(bot2, 0);
        this.scores.put(bot3, 0);
    }

    public void addScore(Player player, int score) {
        scores.put(player, scores.getOrDefault(player, 0) + score);
    }

    public int getScore(Player player) {
        return scores.getOrDefault(player, 0);
    }

    public Map<Player, Integer> getScores() {
        return Collections.unmodifiableMap(scores);
    }

    @Override
    public String toString() {
        return "Scoreboard{" +
                "scores=" + scores + '}';
    }

}
