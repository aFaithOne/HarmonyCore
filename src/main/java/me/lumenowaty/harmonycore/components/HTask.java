package me.lumenowaty.harmonycore.components;

import me.lumenowaty.harmonycore.components.interfaces.Taskable;
import org.bukkit.Bukkit;

public abstract class HTask implements Taskable {

    protected int id;

    @Override
    public void stop() {
        Bukkit.getScheduler().cancelTask(id);
    }
}
