package me.lumenowaty.harmonycore.utils;

import me.lumenowaty.harmonycore.HarmonyCore;
import me.lumenowaty.harmonycore.components.api.API;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ItemStackFromConfigBuilder implements Listener {

    private final String name;
    private final List<String> lore;
    private final Map<String, Integer> stringEnchantments;
    private final int amount;
    private final Material material;
    private final boolean isGlow;

    private Map<Enchantment, Integer> enchantments;

    public ItemStackFromConfigBuilder(String name, List<String> lore, Map<String, Integer> stringEnchantments, int amount, Material material, boolean isGlow) {
        this.name = name;
        this.lore = lore;
        this.stringEnchantments = stringEnchantments;
        this.amount = amount;
        this.material = material;
        this.isGlow = isGlow;
    }

    private void parseEnchantments() {
        try {
            enchantments = ItemStackUtils.parseEnchantments(stringEnchantments);
        } catch(IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }

    public ItemStack getItem() {
        parseEnchantments();

        ItemStack itemStack = new ItemStack(material, amount);
        itemStack.addUnsafeEnchantments(enchantments);

        ItemMeta itemMeta = itemStack.getItemMeta();

        if (itemMeta == null) return itemStack;

        itemMeta.setLore(lore);
        itemMeta.setDisplayName(name);
        itemStack.setItemMeta(itemMeta);

        String key = "GLOWING";

        if (isGlow) API.customEnchantments.getByKey(key).ifPresentOrElse(
                (s) -> itemStack.addUnsafeEnchantment(s, 0),
                () -> {
                    throw new NullPointerException(ChatUtils.format(HarmonyCore.getPluginConfig().emptyEnchantment)
                            .replaceAll("%ench%", key));
                });


        return itemStack;
    }
}

