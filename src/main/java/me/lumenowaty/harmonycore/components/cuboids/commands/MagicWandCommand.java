package me.lumenowaty.harmonycore.components.cuboids.commands;

import me.lumenowaty.harmonycore.HarmonyCore;
import me.lumenowaty.harmonycore.components.cuboids.HWand;
import me.lumenowaty.harmonycore.utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class MagicWandCommand implements CommandExecutor {

    private HarmonyCore core;

    public MagicWandCommand(HarmonyCore core) {
        this.core = core;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (! (sender instanceof Player)) {
            sender.sendMessage(ChatUtils.format(HarmonyCore.getPluginConfig().playerCommand));
            return false;
        }
        Player actor = (Player) sender;
        ItemStack wand = HWand.WAND;
        actor.getInventory().addItem(HWand.WAND);
        return true;
    }
}
