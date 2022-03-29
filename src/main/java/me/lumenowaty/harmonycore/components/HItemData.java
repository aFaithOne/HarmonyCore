package me.lumenowaty.harmonycore.components;

import me.lumenowaty.harmonycore.components.annotations.ConfigItem;
import me.lumenowaty.harmonycore.components.enchantments.HEnchantmentsHolder;
import me.lumenowaty.harmonycore.components.graphicinterfaces.ItemStackFromConfigBuilder;
import me.lumenowaty.harmonycore.components.interfaces.Injectable;
import me.lumenowaty.harmonycore.injectors.ItemStackInjector;
import me.lumenowaty.harmonycore.utils.ChatUtils;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HItemData implements Injectable {

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

        injectData();
    }

    public String getName() {
        return ChatUtils.format(name);
    }

    public List<String> getLore() {
        return ChatUtils.format(lore);
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

    public boolean isGlow() {
        return Boolean.parseBoolean(glow);
    }

    public ItemStack getItem() {
        ItemStackFromConfigBuilder builder = new ItemStackFromConfigBuilder(getName(), getLore(),getEnchantments(), getAmount(), getMaterial(), isGlow());
        return builder.getItem();
    }

    @Override
    public void injectData() {
        ItemStackInjector.injectClassDataFromFile(this, config, path);
    }
}
