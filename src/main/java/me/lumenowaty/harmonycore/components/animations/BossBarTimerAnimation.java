package me.lumenowaty.harmonycore.components.animations;


import me.lumenowaty.harmonycore.components.tasks.HRepeatingTask;
import org.bukkit.Bukkit;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public abstract class BossBarTimerAnimation<T extends JavaPlugin> extends HRepeatingTask<T> {

    protected BossBar animatedBar;
    protected BukkitRunnable runnable;

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
        initAnimation();
        this.id = runnable.runTaskTimerAsynchronously(main, 20L*delayed, 2L*period).getTaskId();
    }

    @Override
    public void stop() {
        animatedBar.removeAll();
        Bukkit.getScheduler().cancelTask(this.id);
    }

    public void setStopTask(BukkitRunnable action, long seconds) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(main, () -> {
            stop();
            action.run();
        }, 20L*seconds);
    }

    public void addPlayersToAnimation(List<Player> players) {
        players.forEach(animatedBar::addPlayer);
    }

    public void addPlayerToAnimation(Player player) {
        animatedBar.addPlayer(player);
    }

    public void removePlayerFromAnimation(Player player) {
        animatedBar.removePlayer(player);
    }

    public void removePlayersFromAnimation(List<Player> players) {
        players.forEach(animatedBar::removePlayer);
    }

    public BossBar getAnimatedBar() {
        return animatedBar;
    }

    public BukkitRunnable getRunnable() {
        return runnable;
    }

    public void setRunnable(BukkitRunnable runnable) {
        this.runnable = runnable;
    }

    public abstract void initAnimation();
}