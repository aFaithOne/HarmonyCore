package me.lumenowaty.harmonycore.components.enchantments;

import me.lumenowaty.harmonycore.components.collections.HMap;
import org.bukkit.enchantments.Enchantment;
import org.jetbrains.annotations.NotNull;

public class HEnchantmentsHolder {

    public static HMap<@NotNull String, Enchantment> myEnchantments = new HMap();
}
