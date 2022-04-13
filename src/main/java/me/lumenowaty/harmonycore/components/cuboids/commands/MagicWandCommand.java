package me.lumenowaty.harmonycore.components.cuboids.commands;

import me.lumenowaty.harmonycore.HarmonyCore;
import me.lumenowaty.harmonycore.components.api.API;
import me.lumenowaty.harmonycore.components.cuboids.MagicWand;
import me.lumenowaty.harmonycore.components.cuboids.SelectedTerritory;
import me.lumenowaty.harmonycore.utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MagicWandCommand implements CommandExecutor {

    private HarmonyCore core;

    public MagicWandCommand(HarmonyCore core) {
        this.core = core;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (! (sender instanceof Player actor)) {
            sender.sendMessage(ChatUtils.format(API.pluginConfig.playerCommand));
            return false;
        }

        if (! (actor.hasPermission("harmonyCore.magicWand") || actor.isOp())) {
            sender.sendMessage(API.pluginConfig.noPermission);
            return false;
        }
        actor.getInventory().addItem(MagicWand.WAND);
        API.selectedTerritory.put(actor.getUniqueId(), new SelectedTerritory.MagicSelect());
        return true;
    }
}
