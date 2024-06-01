package org.example.util.diceroller;

import org.example.util.diceroller.impl.DiceRoller;

public class FakeDiceRoller implements DiceRoller {
    int[] diceRolls = {
            6, 1, 6, 4, 4, 6, 5, 4, 1, 6, 6, 2, 6, 6, 5, 2, 2, 5, 3, 5, 6, 3, 2, 3, 3, 5, 3, 4, 2, 5,
            2, 5, 2, 6, 3, 3, 5, 2, 5, 6, 5, 1, 4, 2, 5, 4, 1, 6, 3, 4, 1, 1, 1, 5, 6, 3
    };
    int i = 0;

    public int rollDice() {
        return diceRolls[i++];
    }
}
