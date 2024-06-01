package org.example.entity.actionelements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.Player;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Crocodile implements ActionElement {
    private int position;

    @Override
    public int calculateJump(int position) {
        return position - 5;
    }

    @Override
    public void logEvent(Player player, int roll) {
        System.out.printf("%s rolled a %d and bitten by crocodile at %d and moved from %d to %d%n", player.getName(), roll, position, position, calculateJump(position));
    }

    @Override
    public void applyPunishMent(Player player) {
    }

}
