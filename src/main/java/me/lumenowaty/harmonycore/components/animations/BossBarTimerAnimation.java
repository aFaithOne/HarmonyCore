package me.lumenowaty.harmonycore.components.animations;


import me.lumenowaty.harmonycore.components.tasks.HRepeatingTask;
import org.bukkit.Bukkit;
import org.bukkit.boss.BossBar;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class BossBarTimerAnimation<T extends JavaPlugin> extends HRepeatingTask<T> {

    protected BossBar animatedBar;
    protected Runnable runnable;

    public BossBarTimerAnimation(T main, int period, int delayed, BossBar animatedBar) {
        super(main, period, delayed);
        this.animatedBar = animatedBar;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void startTask() {
        this.id = Bukkit.getScheduler().scheduleSyncRepeatingTask(main, this::animationChanges, 20L*delayed, 2L*period);
    }

    @Override
    public void stop() {
        animatedBar.removeAll();
        Bukkit.getScheduler().cancelTask(this.id);
    }

    public void stopWithoutRemovingPlayers() {
        Bukkit.getScheduler().cancelTask(this.id);
    }

    public BossBar getAnimatedBar() {
        return animatedBar;
    }

    public abstract void initAnimation();

    public abstract void animationChanges();
}