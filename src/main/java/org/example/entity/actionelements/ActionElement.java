package org.example.entity.actionelements;

import org.example.entity.Player;

public interface ActionElement {
    int calculateJump(int position);

    void applyPunishMent(Player player);

    void logEvent(Player player, int roll);
}
