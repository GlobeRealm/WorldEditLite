package top.globerealm.worldeditlite.utils;

import org.bukkit.entity.Player;

/**
 * @author commandf1
 */
public class PlayerUtil {
    public static boolean isPlayer(Player player, Player target) {
        return player.getUniqueId().toString().equals(target.getUniqueId().toString())
                && player.getName().equals(target.getName());
    }
}
