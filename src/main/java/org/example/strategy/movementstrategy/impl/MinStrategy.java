package org.example.strategy.movementstrategy.impl;

import org.example.strategy.movementstrategy.MovementStrategy;

import java.util.Arrays;

public class MinStrategy implements MovementStrategy {
    @Override
    public int calculateRoll(int[] diceRolls) {
        return Arrays.stream(diceRolls).min().getAsInt();
    }
}
