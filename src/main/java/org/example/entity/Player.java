package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.example.Constants.START_POSITION;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    private String name;
    private int position;
    private int turnsToBeSkipped;

    public Player(String name) {
        this.name = name;
        this.position = START_POSITION;
        this.turnsToBeSkipped = 0;
    }

    public Player(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public boolean allowedToPlay() {
        if (turnsToBeSkipped == 0) return true;
        else {
            System.out.println("Player " + name + " skipped ");
            turnsToBeSkipped--;
            return false;
        }
    }

}
