package top.globerealm.worldeditlite.task.impl;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import top.globerealm.worldeditlite.task.Task;

/**
 * @author commandf1
 */
public class ReplaceTask implements Task {
    public ReplaceTask(Player player) {
        this.player = player;
    }

    private final Player player;

    private Location first, second;

    @Override
    public Player getPlayer() {
        return player;
    }

    public Location getFirst() {
        return first;
    }

    public void setFirst(Location first) {
        this.first = first;
    }

    public Location getSecond() {
        return second;
    }

    public void setSecond(Location second) {
        this.second = second;
    }
}
