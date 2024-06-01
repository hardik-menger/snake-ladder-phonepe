package org.example.util.diceroller;

import org.example.strategy.movementstrategy.MovementStrategyContext;
import org.example.util.diceroller.impl.DiceRoller;

import java.util.Random;

public class RandomDiceRoller implements DiceRoller {
    private final MovementStrategyContext movementStrategyContext;
    private final int numberOfDies;
    private final Random random;

    public RandomDiceRoller(MovementStrategyContext movementStrategyContext, int numberOfDies) {
        this.movementStrategyContext = movementStrategyContext;
        this.numberOfDies = numberOfDies;
        this.random = new Random();
    }

    public int rollDice() {
        int[] diceRolls = new int[numberOfDies];
        for (int i = 0; i < numberOfDies; i++) {
            diceRolls[i] = random.nextInt(6) + 1;
        }
        return movementStrategyContext.calculateRoll(diceRolls);
    }
}
