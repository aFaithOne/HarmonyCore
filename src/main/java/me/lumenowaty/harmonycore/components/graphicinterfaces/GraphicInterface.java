package me.lumenowaty.harmonycore.components.graphicinterfaces;

import me.lumenowaty.harmonycore.api.API;
import me.lumenowaty.harmonycore.components.collections.HMap;
import me.lumenowaty.harmonycore.utils.ChatUtils;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public abstract class GraphicInterface extends HMap<Integer, Button> implements Listener, InventoryHolder {

    protected String permission;
    protected Inventory menu;

    public GraphicInterface(String permission) {
        this.permission = permission;
    }

    @EventHandler
    public void onPlayerClick(InventoryClickEvent event) {
        if (event.getClickedInventory() == null) return;

        if (! (event.getWhoClicked() instanceof Player actor)) return;

        if (! (event.getClickedInventory().getHolder() instanceof GraphicInterface)) return;

        event.setCancelled(true);

        if (! (actor.hasPermission(permission) || actor.isOp())) {
            actor.sendMessage(ChatUtils.format(API.pluginConfig.noPermission));
            return;
        }

        int index = event.getSlot();
        this.getByKey(index).ifPresent(s -> {
            try {
                s.getAction().accept(actor);
            }catch (NullPointerException exception) {
            }
        });
    }

    protected abstract void loadInventory();

    public abstract void loadButtons();
}
