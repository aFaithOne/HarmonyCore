package me.lumenowaty.harmonycore.components.graphicinterfaces;

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