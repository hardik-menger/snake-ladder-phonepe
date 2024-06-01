package org.example.entity.actionelements;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.Player;

@Data
@NoArgsConstructor
public class Ladder implements ActionElement {
    private int top;
    private int bottom;

    public Ladder(int bottom, int top) throws IllegalArgumentException {
        if (bottom > top) {
            throw new IllegalArgumentException("Ladder cannot go down");
        }
        this.bottom = bottom;
        this.top = top;
    }

    @Override
    public int calculateJump(int position) {
        return top;
    }

    @Override
    public void logEvent(Player player, int roll) {
        System.out.printf("%s rolled a %d and climbed the ladder at %d and moved from %d to %d%n", player.getName(), roll, bottom, bottom, calculateJump(bottom));
    }

    @Override
    public void applyPunishMent(Player player) {
    }
}
