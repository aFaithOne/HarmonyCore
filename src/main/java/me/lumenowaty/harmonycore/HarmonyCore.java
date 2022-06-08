package me.lumenowaty.harmonycore;

import me.lumenowaty.harmonycore.components.enchantments.GlowingEnchantment;
import me.lumenowaty.harmonycore.utils.ChatUtils;
import org.bukkit.plugin.java.JavaPlugin;

public final class HarmonyCore extends JavaPlugin {

    public static final String CORE_NAME = ChatUtils.format("&6[&5HarmonyCore&6]&r");

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
