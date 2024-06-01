package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.example.config.GameConfig;
import org.example.entity.Player;
import org.example.entity.boardelement.*;
import org.example.strategy.movementstrategy.MovementStrategyContext;
import org.example.util.RandomDiceRoller;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.example.Constants.START_POSITION;

public class Main {

    private final int boardSize;
    private final RandomDiceRoller diceRoller;
    private final Map<Integer, BoardElement> boardElements = new HashMap<>();
    private final List<Player> players = new ArrayList<>();

    public Main(GameConfig config) throws IllegalArgumentException {
        this.boardSize = config.boardSize;
        this.diceRoller = new RandomDiceRoller(new MovementStrategyContext(config.movementStrategy), config.numberOfDies);
        this.players.addAll(config.players);
        initializeBoardElements(config);
    }

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            GameConfig config = mapper.readValue(new File("src/main/resources/config.yml"), GameConfig.class);
            Main game = new Main(config);
            game.playGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeBoardElements(GameConfig config) {
        config.snakes.forEach((start, end) -> boardElements.put(start, new Snake(start, end)));
        config.ladders.forEach((start, end) -> boardElements.put(start, new Ladder(start, end)));
        config.crocodiles.forEach(position -> boardElements.put(position, new Crocodile(position)));
        config.mines.forEach(position -> boardElements.put(position, new Mine(position)));
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
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
                scanner.nextLine();
            }
        }
    }

    private void setNewPosition(Player player) {
        int roll = diceRoller.rollDice();
        int oldPosition = player.getPosition();
        int newPosition = oldPosition + roll;

        if (newPosition > boardSize * boardSize) {
            System.out.printf("%s rolled a %d and went out of bounds!%n", player.getName(), roll);
            return;
        }
        BoardElement element = boardElements.get(newPosition);
        if (element != null) {
            element.logEvent(player, roll);
            element.applyPunishMent(player);
            newPosition = element.calculateJump(newPosition);
        } else {
            System.out.printf("%s rolled a %d and moved from %d to %d%n", player.getName(), roll, player.getPosition(), newPosition);
        }
        player.setPosition(newPosition);
    }

    private void checkForPlayerCollision(Player currentPlayer) {
        for (Player player : players) {
            if (player != currentPlayer && player.getPosition() == currentPlayer.getPosition()) {
                System.out.printf("%s collided with %s and is sent back to start%n", player.getName(), currentPlayer.getName());
                player.setPosition(START_POSITION);
            }
        }
    }
}
