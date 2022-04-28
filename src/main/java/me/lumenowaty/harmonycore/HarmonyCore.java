package me.lumenowaty.harmonycore;

import me.lumenowaty.harmonycore.components.enchantments.GlowingEnchantment;
import org.bukkit.plugin.java.JavaPlugin;

public final class HarmonyCore extends JavaPlugin {

    private static HarmonyCore harmonyCore;

    @Override
    public void onEnable() {
        harmonyCore = this;
        loadCustomEnchantments();
    }

    @Override
    public void onDisable() {

    }

    private void loadCustomEnchantments() {
       GlowingEnchantment.load();
    }

    public static HarmonyCore getInstance() {
        return harmonyCore;
    }
}
