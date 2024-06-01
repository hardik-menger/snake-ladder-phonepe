package org.example;

import org.example.config.GameConfig;
import org.example.entity.Player;
import org.example.util.diceroller.DiceRoller;
import org.example.util.diceroller.impl.FixedDiceRoller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.example.Constants.START_POSITION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SnakeAndLadderTest {

    private final int boardSize = 10;
    private final int numberOfDice = 1;
    private final List<Player> players = Arrays.asList(new Player("Player1"), new Player("Player2"));
    private SnakeAndLadder snakeAndLadder;

    @BeforeEach
    public void setUp() {
        GameConfig config = new GameConfig();
        config.boardSize = boardSize;
        config.numberOfDies = numberOfDice;
        config.players = players;
        config.movementStrategy = "max"; // or any strategy you want to test
        config.snakes = new HashMap<>();
        config.snakes.put(25, 10); // Add some test snakes
        config.ladders = new HashMap<>();
        config.ladders.put(5, 15); // Add some test ladders
        config.crocodiles = Arrays.asList(20); // Add some test crocodiles
        config.mines = Arrays.asList(30); // Add some test mines

        snakeAndLadder = new SnakeAndLadder(config, new FixedDiceRoller(3));
    }

    @Test
    public void testInitialization() {
        assertNotNull(snakeAndLadder);
        assertEquals(boardSize, snakeAndLadder.getBoardSize());
        assertEquals(players.size(), snakeAndLadder.getPlayers().size());
    }

    @Test
    public void testPlayerMovement() {
        Player player = snakeAndLadder.getPlayers().get(0);
        player.setPosition(5); // Set player position to a ladder start position

        // Mock the dice roller to ensure predictable rolls for testing
        DiceRoller diceRoller = new FixedDiceRoller(3); // Assuming a roll of 3
        snakeAndLadder.setNewPosition(player);

        // Check if the player moved to ladder top position
        assertEquals(8, player.getPosition());
    }

    @Test
    public void testPlayerCollision() {
        Player player1 = snakeAndLadder.getPlayers().get(0);
        Player player2 = snakeAndLadder.getPlayers().get(1);
        player1.setPosition(5);
        player2.setPosition(5); // Both players at the same position (start of ladder)
        snakeAndLadder.checkForPlayerCollision(player2);

        // Check if player2 collided with player1 and was sent back to start
        assertEquals(START_POSITION, player1.getPosition());
        assertEquals(5, player2.getPosition());
    }

    // Add more test cases to cover different scenarios such as winning conditions, interactions with board elements, etc.
}
