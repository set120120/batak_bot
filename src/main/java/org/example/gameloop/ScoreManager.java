package org.example.gameloop;

import org.example.bot.BotPlayer;
import org.example.player.HumanPlayer;
import org.example.player.Player;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ScoreManager {

    private final Map<Player, Integer> scores;

    public ScoreManager(HumanPlayer human, BotPlayer bot1, BotPlayer bot2, BotPlayer bot3) {
        this.scores = new HashMap<>();
        this.scores.put(human, 0);
        this.scores.put(bot1, 0);
        this.scores.put(bot2, 0);
        this.scores.put(bot3, 0);
    }

    public void incrementPlayerScore(Player player) {
        scores.put(player, scores.getOrDefault(player, 0) + 1);
    }

    public int getPlayerScore(Player player) {
        return scores.getOrDefault(player, 0);
    }

    public Map<Player, Integer> getAllScores() {
        return Collections.unmodifiableMap(scores);
    }

    @Override
    public String toString() {
        return "Scoreboard{" +
                "scores=" + scores + '}';
    }

}
