package me.lumenowaty.harmonycore.components.tasks;

import me.lumenowaty.harmonycore.components.interfaces.Taskable;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;


public abstract class HTask<T extends JavaPlugin> implements Taskable {

    protected T main;
    protected int id;

    public HTask(T main) {
        this.main = main;
    }

    @Override
    public void run() {
        startTask();
    }

    @Override
    public void stop() {
        Bukkit.getScheduler().cancelTask(id);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setStopTask(Runnable action, long seconds) {
        new BukkitRunnable() {

            @Override
            public void run() {
                stop();
                action.run();
            }
        }.runTaskLaterAsynchronously(main, 20L * seconds);
    }

    protected abstract void startTask();
}
