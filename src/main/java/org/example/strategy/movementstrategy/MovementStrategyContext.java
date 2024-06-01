package org.example.strategy.movementstrategy;

import lombok.Getter;

@Getter
public class MovementStrategyContext implements MovementStrategy {
    private MovementStrategy strategy;

    private MovementStrategyContext(){}

    public MovementStrategyContext(String strategyType){
        strategy=getMovementStrategy(strategyType);
    }

    public int calculateRoll(int[] diceRolls) {
       return strategy.calculateRoll(diceRolls);
    }

    private MovementStrategy getMovementStrategy(String strategyType) {
        return switch (strategyType.toUpperCase()) {
            case "SUM" -> new SumStrategy();
            case "MAX" -> new MaxStrategy();
            case "MIN" -> new MinStrategy();
            default -> throw new IllegalArgumentException("Invalid movement strategy");
        };
    }

}
