package org.example.util.diceroller;

import org.example.strategy.movementstrategy.MovementStrategy;
import org.example.strategy.movementstrategy.impl.MaxStrategy;
import org.example.strategy.movementstrategy.impl.MinStrategy;
import org.example.strategy.movementstrategy.impl.SumStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovementStrategyTest {

    @Test
    public void testMaxStrategy() {
        MovementStrategy strategy = new MaxStrategy();
        assertEquals(6, strategy.calculateRoll(new int[]{1, 2, 3, 4, 5, 6}));
        assertEquals(10, strategy.calculateRoll(new int[]{10, 9, 8}));
        assertEquals(7, strategy.calculateRoll(new int[]{7, 7, 7}));
    }

    @Test
    public void testMinStrategy() {
        MovementStrategy strategy = new MinStrategy();
        assertEquals(1, strategy.calculateRoll(new int[]{1, 2, 3, 4, 5, 6}));
        assertEquals(8, strategy.calculateRoll(new int[]{10, 9, 8}));
        assertEquals(7, strategy.calculateRoll(new int[]{7, 7, 7}));
    }

    @Test
    public void testSumStrategy() {
        MovementStrategy strategy = new SumStrategy();
        assertEquals(21, strategy.calculateRoll(new int[]{1, 2, 3, 4, 5, 6}));
        assertEquals(27, strategy.calculateRoll(new int[]{10, 9, 8}));
        assertEquals(21, strategy.calculateRoll(new int[]{7, 7, 7}));
    }
}
