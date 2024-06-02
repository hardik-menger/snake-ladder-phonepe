package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.example.config.GameConfig;
import org.example.strategy.movementstrategy.MovementStrategyContext;
import org.example.util.diceroller.impl.InputDiceRoller;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            GameConfig config = mapper.readValue(new File("src/main/resources/config.yml"), GameConfig.class);
            //SnakeAndLadder game = new SnakeAndLadder(config, new FakeDiceRoller());
            SnakeAndLadder game = new SnakeAndLadder(config, new InputDiceRoller(new MovementStrategyContext(config.movementStrategy), config.numberOfDies));
            game.playGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
