package org.example.config;


import org.example.entity.Player;

import java.util.List;
import java.util.Map;

public class GameConfig {
    public int boardSize;
    public int numberOfSnakes;
    public int numberOfCrocodiles;
    public int numberOfLadders;
    public int numberOfDies;
    public int numberOfMines;
    public String movementStrategy;
    public Map<Integer, Integer> snakes;
    public List<Integer> crocodiles;
    public Map<Integer, Integer> ladders;
    public List<Integer> mines;
    public List<Player> players;

    public GameConfig() {
    }

    public GameConfig(int boardSize, int numberOfSnakes, int numberOfCrocodiles, int numberOfLadders, int numberOfDies, int numberOfMines, String movementStrategy, Map<Integer, Integer> snakes, List<Integer> crocodiles, Map<Integer, Integer> ladders, List<Integer> mines, List<Player> players) {
        this.boardSize = boardSize;
        this.numberOfSnakes = numberOfSnakes;
        this.numberOfCrocodiles = numberOfCrocodiles;
        this.numberOfLadders = numberOfLadders;
        this.numberOfDies = numberOfDies;
        this.numberOfMines = numberOfMines;
        this.movementStrategy = movementStrategy;
        this.snakes = snakes;
        this.crocodiles = crocodiles;
        this.mines = mines;
        this.ladders = ladders;
        this.players = players;
    }
}


