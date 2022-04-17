package me.lumenowaty.harmonycore.components.graphicinterfaces;

import me.lumenowaty.harmonycore.api.API;
import me.lumenowaty.harmonycore.components.collections.HMap;
import me.lumenowaty.harmonycore.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.io.Serializable;

public abstract class GraphicInterface extends HMap<Integer, Button> implements Listener, InventoryHolder, Serializable {

    protected String permission;
    protected Inventory menu;
    protected int rows;
    protected String menuName;

    public GraphicInterface(String permission) {
        this.permission = permission;
    }

    @EventHandler
    public void onPlayerClick(InventoryClickEvent event) {
        if (event.getClickedInventory() == null) return;

        if (! (event.getWhoClicked() instanceof Player actor)) return;

        if (! (isInstanceOfHolder(event.getClickedInventory().getHolder()))) return;

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

    protected void loadInventory(GraphicInterface holder) {
        menu = Bukkit.createInventory(holder, 9 * rows, ChatUtils.format(menuName));
        updateInventory();
    }

    protected abstract boolean isInstanceOfHolder(InventoryHolder holder);

    public void updateInventory() {
        super.map.keySet().forEach(s-> menu.setItem(s, super.map.get(s).getButtonItem().getItem()));
    }

    public abstract void loadButtons();
}