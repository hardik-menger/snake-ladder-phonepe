package org.example.entity.boardelement;

import org.example.entity.Player;

public interface BoardElement {
    int calculateJump(int position);

    void applyPunishMent(Player player);

    void logEvent(Player player, int roll);
}
