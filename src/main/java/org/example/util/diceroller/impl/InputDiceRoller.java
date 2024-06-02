package org.example.util.diceroller.impl;

import org.example.strategy.movementstrategy.MovementStrategyContext;
import org.example.util.diceroller.DiceRoller;

import java.util.Scanner;

public class InputDiceRoller implements DiceRoller {
    private final MovementStrategyContext movementStrategyContext;
    private final int numberOfDies;
    private final Scanner sc = new Scanner(System.in);

    public InputDiceRoller(MovementStrategyContext movementStrategyContext, int numberOfDies) {
        this.movementStrategyContext = movementStrategyContext;
        this.numberOfDies = numberOfDies;
    }

    public int rollDice() {
        int[] diceRolls = new int[numberOfDies];
        for (int i = 0; i < numberOfDies; i++) {
            int diceValue;
            while (true) {
                diceValue = sc.nextInt();
                if (diceValue >= 1 && diceValue <= 6) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a value between 1 and 6.");
                }
            }
            diceRolls[i] = diceValue;
        }
        return movementStrategyContext.calculateRoll(diceRolls);
    }
}
