package org.example.entity.actionelements;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.Player;

@Data
@NoArgsConstructor
public class Snake implements ActionElement {
    private int tail;
    private int head;

    public Snake(int head, int tail) throws IllegalArgumentException {
        if (tail > head) {
            throw new IllegalArgumentException("Snake cannot go up");
        }
        this.head = head;
        this.tail = tail;
    }

    public void logEvent(Player player, int roll) {
        System.out.printf("%s rolled a %d and bitten by snake at %d and moved from %d to %d%n", player.getName(), roll, head, head, calculateJump(head));
    }

    @Override
    public int calculateJump(int position) {
        return tail;
    }

    @Override
    public void applyPunishMent(Player player) {
    }
}
