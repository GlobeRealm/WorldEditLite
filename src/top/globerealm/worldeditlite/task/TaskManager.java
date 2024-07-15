package top.globerealm.worldeditlite.task;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;
import top.globerealm.worldeditlite.utils.PlayerUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author commandf1
 */
public class TaskManager {

    @SuppressWarnings("unchecked")
    @Nullable
    public static <E extends Task> E getTask(Player player, Class<E> clazz) {
        for (Task task : TASKS) {
            if (!task.getClass().equals(clazz)) {
                continue;
            }
            if (PlayerUtil.isPlayer(player, task.getPlayer())) {
                return (E) task;
            }
        }

        return null;
    }

    private static final List<Task> TASKS = new ArrayList<>();

    public static List<Task> getTasks() {
        return TASKS;
    }

    public static void addTask(Task task) {
        TASKS.add(task);
    }

    public static void removeTask(Task task) {
        TASKS.remove(task);
    }
}
