package me.lumenowaty.harmonycore.components;

import me.lumenowaty.harmonycore.components.annotations.ConfigItem;
import me.lumenowaty.harmonycore.utils.ItemStackFromConfigBuilder;
import me.lumenowaty.harmonycore.components.interfaces.Injectable;
import me.lumenowaty.harmonycore.injectors.DataInjector;
import me.lumenowaty.harmonycore.utils.ChatUtils;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class HItemData implements Injectable {

    private final FileConfiguration config;
    private final String path;

    @ConfigItem(itemField = "name")
    public String name;
    @ConfigItem(itemField = "lore")
    public List<String> lore;
    @ConfigItem(itemField = "enchantments")
    public Map<String, String> enchantments;
    @ConfigItem(itemField = "amount")
    public String amount;
    @ConfigItem(itemField = "material")
    public String material;
    @ConfigItem(itemField = "glow")
    public String glow;

    public HItemData(FileConfiguration config, String path) {
        System.out.println("tworze klase HItem");
        this.config = config;
        this.path = path;

        injectData();
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

    @Override
    public void injectData() {
        DataInjector.injectClassDataFromFile(this, config, path);
    }
}
