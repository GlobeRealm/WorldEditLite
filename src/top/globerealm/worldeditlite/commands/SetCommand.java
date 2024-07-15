package top.globerealm.worldeditlite.commands;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.globerealm.worldeditlite.task.TaskManager;
import top.globerealm.worldeditlite.task.impl.ReplaceTask;
import top.globerealm.worldeditlite.utils.BlockUtil;

/**
 * @author commandf1
 */
public class SetCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player player)) {
            commandSender.sendMessage("§cYou must be a player to use this command.");
            return true;
        }

        var task = TaskManager.getTask(player, ReplaceTask.class);
        if (task == null || task.getFirst() == null || task.getSecond() == null) {
            commandSender.sendMessage("You haven't chosen locations yet.");
            return true;
        }

        if (strings.length != 1) {
            commandSender.sendMessage("Check your args!");
            return true;
        }

        var blockId = strings[0].trim();
        Material blockType;

        blockType = this.getMaterialByName(blockId);

        if (blockType == null || !blockType.isBlock()) {
            player.sendMessage("Can not find the block id.");
            return true;
        }

        var blocks = BlockUtil.getBlocksBetween(task.getFirst(), task.getSecond());

        for (Block block : blocks) {
            block.setType(blockType);
        }

        return true;
    }

    @Nullable
    private Material getMaterialByName(String name) {
        for (Material value : Material.values()) {
            if (value.name().equalsIgnoreCase(name)) {
                return value;
            }
        }

        return null;
    }
}
