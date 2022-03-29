package me.lumenowaty.harmonycore.components.tasks;

import me.lumenowaty.harmonycore.HarmonyCore;
import me.lumenowaty.harmonycore.components.interfaces.Taskable;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;


public abstract class HTask implements Taskable {

    protected int id;

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
    public void setStopTask(Runnable action, int time) {
        new BukkitRunnable() {

            @Override
            public void run() {
                stop();
            }
        }.runTaskLaterAsynchronously(HarmonyCore.getInstance(), 20L * time);
    }
}
