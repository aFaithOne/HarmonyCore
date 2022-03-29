package me.lumenowaty.harmonycore;

import me.lumenowaty.harmonycore.components.configs.PluginConfig;
import me.lumenowaty.harmonycore.components.cuboids.commands.MagicWandCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class HarmonyCore extends JavaPlugin {

    private static HarmonyCore harmonyCore;
    private static PluginConfig pluginConfig;

    @Override
    public void onEnable() {
        harmonyCore = this;
        pluginConfig = new PluginConfig("config", this);
        pluginConfig.injectData();

        registerCommands();
    }

    @Override
    public void onDisable() {

    }

    private void registerCommands() {
        getCommand("magicWand").setExecutor(new MagicWandCommand(this));
    }

    public static HarmonyCore getInstance() {
        return harmonyCore;
    }

    @NotNull
    public static PluginConfig getPluginConfig() {
        return pluginConfig;
    }
}
