package org.example;

import lombok.Data;
import org.example.config.GameConfig;
import org.example.entity.Player;
import org.example.entity.actionelements.ActionElement;
import org.example.entity.actionelements.impl.Crocodile;
import org.example.entity.actionelements.impl.Ladder;
import org.example.entity.actionelements.impl.Mine;
import org.example.entity.actionelements.impl.Snake;
import org.example.util.diceroller.DiceRoller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.Constants.START_POSITION;

@Data
public class SnakeAndLadder {

    private final int boardSize;
    private final DiceRoller diceRoller;
    private final Map<Integer, ActionElement> boardElements = new HashMap<>();
    private final List<Player> players = new ArrayList<>();

    public SnakeAndLadder(GameConfig config, DiceRoller diceRoller) throws IllegalArgumentException {
        this.boardSize = config.boardSize;
        this.diceRoller = diceRoller;
        this.players.addAll(config.players);
        initializeBoardElements(config);
    }

    private void initializeBoardElements(GameConfig config) {
        config.snakes.forEach((start, end) -> boardElements.put(start, new Snake(start, end)));
        config.ladders.forEach((start, end) -> boardElements.put(start, new Ladder(start, end)));
        config.crocodiles.forEach(position -> boardElements.put(position, new Crocodile(position)));
        config.mines.forEach(position -> boardElements.put(position, new Mine(position)));
    }

    public void playGame() {
        boolean gameWon = false;
        while (!gameWon) {
            for (Player player : players) {
                if (player.allowedToPlay()) {
                    setNewPosition(player);
                    if (player.getPosition() == boardSize * boardSize) {
                        System.out.printf("%s has won the game!%n", player.getName());
                        gameWon = true;
                        break;
                    }
                    checkForPlayerCollision(player);
                }
            }
        }
    }

    public void setNewPosition(Player player) {
        int roll = diceRoller.rollDice();
        int oldPosition = player.getPosition();
        int newPosition = oldPosition + roll;

        if (newPosition > boardSize * boardSize) {
            System.out.printf("%s rolled a %d and went out of bounds!%n", player.getName(), roll);
            return;
        }
        ActionElement element = boardElements.get(newPosition);
        if (element != null) {
            element.logEvent(player, roll);
            element.applyPunishMent(player);
            newPosition = element.calculateJump(newPosition);
        } else {
            System.out.printf("%s rolled a %d and moved from %d to %d %n", player.getName(), roll, player.getPosition(), newPosition);
        }
        player.setPosition(newPosition);
    }

    public void checkForPlayerCollision(Player currentPlayer) {
        for (Player player : players) {
            if (player != currentPlayer && player.getPosition() == currentPlayer.getPosition()) {
                System.out.printf("%s collided with %s and is sent back to start%n", player.getName(), currentPlayer.getName());
                player.setPosition(START_POSITION);
            }
        }
    }
}
