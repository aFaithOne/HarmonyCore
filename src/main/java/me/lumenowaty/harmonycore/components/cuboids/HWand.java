package me.lumenowaty.harmonycore.components.cuboids;

import me.lumenowaty.harmonycore.HarmonyCore;
import me.lumenowaty.harmonycore.components.HItemData;
import org.bukkit.inventory.ItemStack;

public class HWand {

    public static ItemStack WAND;

    public static void load() {
        HItemData wand = new HItemData(HarmonyCore.getPluginConfig().getConfig(), "wand");
        wand.amount = "1";
        wand.glow = "true";
        wand.material = "WOODEN_AXE";
        WAND =  wand.getItem();
    }


}
