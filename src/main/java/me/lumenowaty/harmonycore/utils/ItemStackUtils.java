package me.lumenowaty.harmonycore.utils;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;

import java.util.HashMap;
import java.util.Map;

public class ItemStackUtils {

    public static Map<Enchantment, Integer> parseEnchantments(Map<String, Integer> enchantments) throws IllegalArgumentException {
        Map<Enchantment, Integer> parsedEnchantment = new HashMap<>();

        enchantments.keySet()
                .forEach(s -> parsedEnchantment.put(Enchantment.getByKey(NamespacedKey.minecraft(s)), enchantments.get(s)));

        return parsedEnchantment;
    }
}
