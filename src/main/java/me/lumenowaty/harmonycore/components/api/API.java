package me.lumenowaty.harmonycore.components.api;

import me.lumenowaty.harmonycore.HarmonyCore;
import me.lumenowaty.harmonycore.components.configs.PluginConfig;
import me.lumenowaty.harmonycore.components.cuboids.SelectedTerritory;
import me.lumenowaty.harmonycore.components.enchantments.CustomEnchantments;

public class API {

    public final static SelectedTerritory selectedTerritory = new SelectedTerritory();
    public final static CustomEnchantments customEnchantments = new CustomEnchantments();
    public final static PluginConfig pluginConfig = new PluginConfig("config", HarmonyCore.getInstance()).injectData();

}
