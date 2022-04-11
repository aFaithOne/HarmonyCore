package me.lumenowaty.harmonycore;

import me.lumenowaty.harmonycore.components.configs.PluginConfig;
import me.lumenowaty.harmonycore.components.cuboids.HWand;
import me.lumenowaty.harmonycore.components.cuboids.commands.MagicWandCommand;
import me.lumenowaty.harmonycore.components.enchantments.GlowingEnchantment;
import org.bukkit.plugin.java.JavaPlugin;

public final class HarmonyCore extends JavaPlugin {

    private static HarmonyCore harmonyCore;
    private static PluginConfig pluginConfig;

    @Override
    public void onEnable() {


        harmonyCore = this;
        pluginConfig = new PluginConfig("config", this);
        pluginConfig.injectData();

        loadCustomEnchantments();
        loadComponents();
        registerCommands();
    }

    @Override
    public void onDisable() {

    }

    private void registerCommands() {
        getCommand("magicWand").setExecutor(new MagicWandCommand(this));
    }

    private void loadCustomEnchantments() {
       GlowingEnchantment.load();
    }

    private void loadComponents() {
        HWand.load();
    }

    public static HarmonyCore getInstance() {
        return harmonyCore;
    }

    public static PluginConfig getPluginConfig() {
        return pluginConfig;
    }
}
