package org.example.util.diceroller;


import org.example.strategy.movementstrategy.MovementStrategyContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MovementStrategyContextTest {

    @Test
    public void testSumStrategyContext() {
        MovementStrategyContext context = new MovementStrategyContext("SUM");
        assertEquals(21, context.calculateRoll(new int[]{1, 2, 3, 4, 5, 6}));
    }

    @Test
    public void testMaxStrategyContext() {
        MovementStrategyContext context = new MovementStrategyContext("MAX");
        assertEquals(6, context.calculateRoll(new int[]{1, 2, 3, 4, 5, 6}));
    }

    @Test
    public void testMinStrategyContext() {
        MovementStrategyContext context = new MovementStrategyContext("MIN");
        assertEquals(1, context.calculateRoll(new int[]{1, 2, 3, 4, 5, 6}));
    }

    @Test
    public void testInvalidStrategyContext() {
        assertThrows(IllegalArgumentException.class, () -> {
            new MovementStrategyContext("INVALID");
        });
    }
}
