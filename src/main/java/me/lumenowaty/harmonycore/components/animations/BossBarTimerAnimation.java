package me.lumenowaty.harmonycore.components.animations;


import me.lumenowaty.harmonycore.components.tasks.HRepeatingTask;
import org.bukkit.Bukkit;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public abstract class BossBarTimerAnimation<T extends JavaPlugin> extends HRepeatingTask<T> {

    protected BossBar bossBar;

    public BossBarTimerAnimation(T main, int period, int delayed) {
        super(main, period, delayed);
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
        bossBar.removeAll();
        Bukkit.getScheduler().cancelTask(this.id);
    }

    public void addPlayersToAnimation(List<Player> players) {
        players.forEach(bossBar::addPlayer);
    }

    public void addPlayerToAnimation(Player player) {
        bossBar.addPlayer(player);
    }

    public void removePlayerFromAnimation(Player player) {
        bossBar.removePlayer(player);
    }

    public void removePlayersFromAnimation(List<Player> players) {
        players.forEach(bossBar::removePlayer);
    }

    public BossBar getBossBar() {
        return bossBar;
    }

    public abstract void animationChanges();
}