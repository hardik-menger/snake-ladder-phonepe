package org.example.util.diceroller.impl;

import lombok.AllArgsConstructor;
import org.example.util.diceroller.DiceRoller;

@AllArgsConstructor
public class FixedDiceRoller implements DiceRoller {
    int diceNumber;

    public int rollDice() {
        return diceNumber;
    }
}
