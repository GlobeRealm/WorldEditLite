package top.globerealm.worldeditlite.utils;

import org.bukkit.Location;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;

public class BlockUtil {
    /**
     * 获取两个位置之间的所有块。
     * @param startLoc 起始位置
     * @param endLoc 结束位置
     * @return 块的列表
     */
    public static List<Block> getBlocksBetween(Location startLoc, Location endLoc) {
        var blocks = new ArrayList<Block>();
        var world = startLoc.getWorld();
        int startX = startLoc.getBlockX();
        int startY = startLoc.getBlockY();
        int startZ = startLoc.getBlockZ();
        int endX = endLoc.getBlockX();
        int endY = endLoc.getBlockY();
        int endZ = endLoc.getBlockZ();

        // 确定遍历的起始和结束索引
        int minBlockX = Math.min(startX, endX);
        int maxBlockX = Math.max(startX, endX);
        int minBlockY = Math.min(startY, endY);
        int maxBlockY = Math.max(startY, endY);
        int minBlockZ = Math.min(startZ, endZ);
        int maxBlockZ = Math.max(startZ, endZ);

        // 遍历所有块
        for (int x = minBlockX; x <= maxBlockX; x++) {
            for (int y = minBlockY; y <= maxBlockY; y++) {
                for (int z = minBlockZ; z <= maxBlockZ; z++) {
                    Block block = world.getBlockAt(x, y, z);
                    blocks.add(block);
                }
            }
        }

        return blocks;
    }
}
