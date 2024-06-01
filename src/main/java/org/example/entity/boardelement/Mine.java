package org.example.entity.boardelement;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.Player;

@Data
@NoArgsConstructor
public class Mine implements BoardElement {
    private int noOfTurnsToBeSkipped = 2;
    private int position;

    public Mine(int position) {
        this.position = position;
    }

    @Override
    public int calculateJump(int position) {
        return position;
    }

    @Override
    public void logEvent(Player player, int roll) {
        System.out.printf("%s rolled a %d and stood on a mine at %d and lost next two moves%n", player.getName(), roll, position);
    }

    @Override
    public void applyPunishMent(Player player) {
        player.setTurnsToBeSkipped(2);
    }
}
