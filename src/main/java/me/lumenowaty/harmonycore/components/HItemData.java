package me.lumenowaty.harmonycore.components;

import me.lumenowaty.harmonycore.components.annotations.ConfigItem;
import org.bukkit.Material;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HItemData {

    @ConfigItem(itemField = "name")
    private String name;
    @ConfigItem(itemField = "lore")
    private List<String> lore;
    @ConfigItem(itemField = "enchantments")
    private Map<String, String> enchantments;
    @ConfigItem(itemField = "amount")
    private String amount;
    @ConfigItem(itemField = "material")
    private String material;
    @ConfigItem(itemField = "glow")
    private String isGlow;

    public String getName() {
        return name;
    }

    public List<String> getLore() {
        return lore;
    }

    public Map<String, Integer> getEnchantments() {
        Map<String, Integer> map = new HashMap<>();
        Set<String> strings = enchantments.keySet();
        for (String en : strings) {
            map.put(en, Integer.parseInt(enchantments.get(en)));
        }
        return map;
    }

    public Integer getAmount() {
        return Integer.parseInt(amount);
    }

    public Material getMaterial() {
        return Material.getMaterial(material);
    }

    public boolean getIsGlow() {
        return Boolean.parseBoolean(isGlow);
    }
}
