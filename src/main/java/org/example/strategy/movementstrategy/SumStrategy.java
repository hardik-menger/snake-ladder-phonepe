package org.example.strategy.movementstrategy;

import java.util.Arrays;

public class SumStrategy implements MovementStrategy {
    @Override
    public int calculateRoll(int[] diceRolls) {
        return Arrays.stream(diceRolls).sum();
    }
}
