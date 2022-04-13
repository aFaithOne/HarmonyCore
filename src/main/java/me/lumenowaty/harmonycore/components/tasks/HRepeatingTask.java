package me.lumenowaty.harmonycore.components.tasks;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class HRepeatingTask<T extends JavaPlugin> extends HTask {

    protected final int period;
    protected final int delayed;

    public HRepeatingTask(T main, int period, int delayed) {
        super(main);
        this.period = period;
        this.delayed = delayed;
    }

    public int getPeriod() {
        return period;
    }

    public int getDelayed() {
        return delayed;
    }
}
