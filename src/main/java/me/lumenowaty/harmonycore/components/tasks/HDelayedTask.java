package me.lumenowaty.harmonycore.components.tasks;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class HDelayedTask<T extends JavaPlugin> extends HTask {

    protected final int delayed;

    protected HDelayedTask(T main, int delayed) {
        super(main);
        this.delayed = delayed;
    }


}
