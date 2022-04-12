package me.lumenowaty.harmonycore.components.cuboids;

import me.lumenowaty.harmonycore.HarmonyCore;
import me.lumenowaty.harmonycore.components.HItemData;
import org.bukkit.inventory.ItemStack;



public class MagicWand {

    public static ItemStack WAND = new HItemData(HarmonyCore.getPluginConfig().getConfig(), "wand")
            .injectData()
            .setAmount("1")
            .setGlow("true")
            .setMaterial("WOODEN_AXE").getItem();

}
