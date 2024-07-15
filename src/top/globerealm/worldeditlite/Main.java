package top.globerealm.worldeditlite;

import org.bukkit.plugin.java.JavaPlugin;
import top.globerealm.worldeditlite.commands.SetCommand;
import top.globerealm.worldeditlite.listeners.ReplaceTaskListener;

import java.util.Objects;

/**
 * @author commandf1
 */
public class Main extends JavaPlugin {
    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        Objects.requireNonNull(this.getCommand("/set")).setExecutor(new SetCommand());

        this.getServer().getPluginManager().registerEvents(new ReplaceTaskListener(), this);
    }

    @Override
    public void onDisable() {
        instance = null;
    }
}
