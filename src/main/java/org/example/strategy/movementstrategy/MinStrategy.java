package org.example.strategy.movementstrategy;

import java.util.Arrays;

public class MinStrategy implements MovementStrategy {
    @Override
    public int calculateRoll(int[] diceRolls) {
        return Arrays.stream(diceRolls).min().getAsInt();
    }
}
