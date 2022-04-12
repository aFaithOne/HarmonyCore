package me.lumenowaty.harmonycore.components;

import me.lumenowaty.harmonycore.components.annotations.ConfigItem;
import me.lumenowaty.harmonycore.utils.ItemStackFromConfigBuilder;
import me.lumenowaty.harmonycore.injectors.DataInjector;
import me.lumenowaty.harmonycore.utils.ChatUtils;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class HItemData {

    private final FileConfiguration config;
    private final String path;

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
    private String glow;

    public HItemData(FileConfiguration config, String path) {

        this.config = config;
        this.path = path;
    }

    public HItemData setName(String name) {
        this.name = name;
        return this;
    }

    public HItemData setLore(List<String> lore) {
        this.lore = lore;
        return this;
    }

    public HItemData setEnchantments(Map<String, String> enchantments) {
        this.enchantments = enchantments;
        return this;
    }

    public HItemData setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public HItemData setMaterial(String material) {
        this.material = material;
        return this;
    }

    public HItemData setGlow(String glow) {
        this.glow = glow;
        return this;
    }

    public String getName() {
        if (name == null) return "default";

        return ChatUtils.format(name);
    }

    public List<String> getLore() {
        if (lore == null) return new ArrayList<>();

        return ChatUtils.format(lore);
    }

    public Map<String, Integer> getEnchantments() {
        Map<String, Integer> map = new HashMap<>();

        if (enchantments == null) return map;

        Set<String> strings = enchantments.keySet();

        for (String en : strings) {
            map.put(en, Integer.parseInt(enchantments.get(en)));
        }

        return map;
    }

    public Integer getAmount() {
        if (amount == null) return 1;

        return Integer.parseInt(amount);
    }

    public Material getMaterial() {
        if (material == null) return Material.STONE;

        return Material.getMaterial(material.toUpperCase());
    }

    public boolean isGlow() {
        if (glow == null) return false;

        return Boolean.parseBoolean(glow);
    }

    public ItemStack getItem() {
        ItemStackFromConfigBuilder builder = new ItemStackFromConfigBuilder(getName(), getLore(),getEnchantments(), getAmount(), getMaterial(), isGlow());
        return builder.getItem();
    }

    public HItemData injectData() {
        DataInjector.injectItemDataFromFile(this, config, path);
        return this;
    }
}
