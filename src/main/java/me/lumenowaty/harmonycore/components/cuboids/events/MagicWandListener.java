package me.lumenowaty.harmonycore.components.cuboids.events;

import me.lumenowaty.harmonycore.api.API;
import me.lumenowaty.harmonycore.components.cuboids.MagicWand;
import me.lumenowaty.harmonycore.components.cuboids.SelectedTerritory;
import me.lumenowaty.harmonycore.utils.ChatUtils;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.UUID;

public class MagicWandListener implements Listener {

    @EventHandler
    public void magicWandOnRightClick(PlayerInteractEvent event) {
        if (event.getHand() == EquipmentSlot.OFF_HAND) return;

        Player actor = event.getPlayer();
        if (! MagicWand.WAND.isSimilar(actor.getInventory().getItemInMainHand())) return;

        if (! (actor.hasPermission("harmonyCore.magicWand") || actor.isOp())) return;

        Block clickedBlock = event.getClickedBlock();

        if (clickedBlock == null) return;

        event.setCancelled(true);

        Action action = event.getAction();
        SelectedTerritory selectedTerritory = API.selectedTerritory;
        UUID uuid = actor.getUniqueId();

        if (! selectedTerritory.containsKey(uuid)) {
            selectedTerritory.put(uuid, new SelectedTerritory.MagicSelect());
        }

        if (Action.LEFT_CLICK_BLOCK.equals(action)) {
            API.selectedTerritory.getByKey(uuid).get().setFirst(clickedBlock.getLocation());
            actor.sendMessage(ChatUtils.format(API.pluginConfig.magicWandFirstSelection));
        }

        if (Action.RIGHT_CLICK_BLOCK.equals(action)) {
            API.selectedTerritory.getByKey(uuid).get().setSecond(clickedBlock.getLocation());
            actor.sendMessage(ChatUtils.format(API.pluginConfig.magicWandSecondSelection));
        }
    }

    @EventHandler
    public void playerQuit(PlayerQuitEvent event) {
        API.selectedTerritory.remove(event.getPlayer().getUniqueId());
    }
}
