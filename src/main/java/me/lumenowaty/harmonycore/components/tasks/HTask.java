package me.lumenowaty.harmonycore.components.tasks;

import me.lumenowaty.harmonycore.components.annotations.Warning;
import me.lumenowaty.harmonycore.components.interfaces.Taskable;
import org.bukkit.Bukkit;

public abstract class HTask implements Taskable {

    protected int id;

    public void run() {
        task();
    }

    @Warning(info = "Do not use. Please use 'run' method.")
    abstract void task();

    @Override
    public void stop() {
        Bukkit.getScheduler().cancelTask(id);
    }
}
