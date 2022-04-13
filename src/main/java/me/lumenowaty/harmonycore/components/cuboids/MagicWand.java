package me.lumenowaty.harmonycore.components.cuboids;

import me.lumenowaty.harmonycore.components.HItemData;
import me.lumenowaty.harmonycore.api.API;
import org.bukkit.inventory.ItemStack;



public class MagicWand {

    public static ItemStack WAND = new HItemData(API.pluginConfig.getConfig(), "wand")
            .injectData()
            .setAmount("1")
            .setGlow("true")
            .setMaterial("WOODEN_AXE").getItem();

}
