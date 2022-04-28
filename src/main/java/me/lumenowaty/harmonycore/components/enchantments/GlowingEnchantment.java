package me.lumenowaty.harmonycore.components.enchantments;

import me.lumenowaty.harmonycore.HarmonyCore;
import me.lumenowaty.harmonycore.components.ExceptionPrinter;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.Arrays;

public class GlowingEnchantment extends Enchantment {

    private static final NamespacedKey enchKey = new NamespacedKey(HarmonyCore.class.getName().toLowerCase(), "glowing");

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


    public static void load() {
        System.out.println("test");
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
        }
        catch (Exception e) {
            System.out.println("3");
            e.printStackTrace();
        }
        try {
            GlowingEnchantment glow = new GlowingEnchantment(enchKey);
            Enchantment.registerEnchantment(glow);
            System.out.println("hejo");
            System.out.println(Arrays.toString(Enchantment.values()));
        }
        catch (IllegalArgumentException e){
            System.out.println("1");
            ExceptionPrinter.logException(e.getMessage());
        }
        catch(Exception e){
            System.out.println("2");
            e.printStackTrace();
        }
    }

    public static Enchantment getEnchantment() {
        System.out.println(Arrays.toString(Enchantment.values()));
        return Enchantment.getByKey(enchKey);
    }
}
