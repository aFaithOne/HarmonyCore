package me.lumenowaty.harmonycore;

import org.bukkit.plugin.java.JavaPlugin;

public final class HarmonyCore extends JavaPlugin {

    private static HarmonyCore harmonyCore;

    @Override
    public void onEnable() {
        harmonyCore = this;

    }

    @Override
    public void onDisable() {

    }

    public static HarmonyCore getInstance() {
        return harmonyCore;
    }
}
