package top.globerealm.worldeditlite.listeners;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import top.globerealm.worldeditlite.task.TaskManager;
import top.globerealm.worldeditlite.task.impl.ReplaceTask;

/**
 * @author commandf1
 */
public class ReplaceTaskListener implements Listener {

    @EventHandler
    public void onPlayerBreak(BlockBreakEvent event) {
        var player = event.getPlayer();
        var block = event.getBlock();
        var mainHandItem = player.getInventory().getItemInMainHand();
        if (!mainHandItem.getType().equals(Material.WOODEN_AXE)) {
            return;
        }

        if (!player.getGameMode().equals(GameMode.CREATIVE)
        && !player.hasPermission("worldeditlite.use")) {
            return;
        }

        event.setCancelled(true);
        ReplaceTask task = TaskManager.getTask(player, ReplaceTask.class);
        if (task == null) {
            task = new ReplaceTask(player);
        }

        if (task.getFirst() == null) {
            task.setFirst(block.getLocation());
            player.sendMessage("You've chosen the §c" + "first part " + "§f" + "\n" + block.getLocation());
            TaskManager.removeTask(task);
            TaskManager.addTask(task);
        } else if (task.getSecond() == null) {
            task.setSecond(block.getLocation());
            player.sendMessage("You've chosen the §a" + "second part " + "§f" + "\n" + block.getLocation());
            TaskManager.removeTask(task);
            TaskManager.addTask(task);
        } else {
            TaskManager.removeTask(task);
            player.sendMessage("You started to choose a new part.");
            this.onPlayerBreak(event);
        }
    }
}
