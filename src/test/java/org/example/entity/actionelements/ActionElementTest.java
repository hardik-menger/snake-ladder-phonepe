package org.example.entity.actionelements;

import org.example.entity.Player;
import org.example.entity.actionelements.impl.Crocodile;
import org.example.entity.actionelements.impl.Ladder;
import org.example.entity.actionelements.impl.Mine;
import org.example.entity.actionelements.impl.Snake;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActionElementTest {

    @Test
    public void testCrocodile() {
        ActionElement crocodile = new Crocodile(10); // Assuming crocodile position is 10
        Player player = new Player("Test Player");
        int roll = 6; // Assuming the player rolls a 6
        crocodile.logEvent(player, roll);
        assertEquals(5, crocodile.calculateJump(10)); // Assuming the player was at position 10
    }

    @Test
    public void testLadder() {
        ActionElement ladder = new Ladder(5, 15); // Assuming ladder goes from 5 to 15
        Player player = new Player("Test Player");
        int roll = 4; // Assuming the player rolls a 4
        ladder.logEvent(player, roll);
        assertEquals(15, ladder.calculateJump(5)); // Assuming the player was at position 5
    }

    @Test
    public void testMine() {
        ActionElement mine = new Mine(20); // Assuming mine is at position 20
        Player player = new Player("Test Player");
        int roll = 3; // Assuming the player rolls a 3
        mine.logEvent(player, roll);
        mine.applyPunishMent(player);
        assertEquals(2, player.getTurnsToBeSkipped()); // Assuming the player loses next two moves
    }

    @Test
    public void testSnake() {
        ActionElement snake = new Snake(25, 10); // Assuming snake goes from 25 to 10
        Player player = new Player("Test Player");
        int roll = 5; // Assuming the player rolls a 5
        snake.logEvent(player, roll);
        assertEquals(10, snake.calculateJump(25)); // Assuming the player was at position 25
    }
}
