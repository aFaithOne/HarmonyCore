package me.lumenowaty.harmonycore.components.enchantments;

import me.lumenowaty.harmonycore.HarmonyCore;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.Objects;

public class GlowingEnchantment extends Enchantment {

    public GlowingEnchantment(@NotNull NamespacedKey key) {
        super(key);
    }

    @NotNull
    @Override
    public String getName() {
        return "Glowing";
    }

    @Override
    public int getMaxLevel() {
        return 0;
    }

    @Override
    public int getStartLevel() {
        return 0;
    }

    @NotNull
    @Override
    public EnchantmentTarget getItemTarget() {
        return null;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    @Override
    public boolean conflictsWith(@NotNull Enchantment other) {
        return false;
    }

    @Override
    public boolean canEnchantItem(@NotNull ItemStack item) {
        return false;
    }

    static {
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            GlowingEnchantment glow = new GlowingEnchantment(
                    Objects.requireNonNull(NamespacedKey.fromString("harmonycore.glowing", HarmonyCore.getInstance())));
            Enchantment.registerEnchantment(glow);
            HEnchantmentsHolder.myEnchantments.add("GLOW", glow);
        }
        catch (IllegalArgumentException e){
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
