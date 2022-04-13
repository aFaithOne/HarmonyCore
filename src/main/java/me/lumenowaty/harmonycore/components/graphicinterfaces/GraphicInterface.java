package me.lumenowaty.harmonycore.components.graphicinterfaces;

import me.lumenowaty.harmonycore.api.API;
import me.lumenowaty.harmonycore.components.collections.HMap;
import me.lumenowaty.harmonycore.utils.ChatUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public abstract class GraphicInterface extends HMap<Integer, Button> implements Listener {

    protected String permission;

    public GraphicInterface(String permission) {
        this.permission = permission;
    }

    @EventHandler
    public void onPlayerClick(InventoryClickEvent event) {
        if (event.getClickedInventory() == null) return;

        if (! (event.getWhoClicked() instanceof Player actor)) return;

        if (! (actor.hasPermission(permission) || actor.isOp())) {
            actor.sendMessage(ChatUtils.format(API.pluginConfig.noPermission));
            return;
        }

        int index = event.getSlot();
        this.getByKey(index).ifPresent(s -> s.getAction().run());
    }

    public void setButton(int index, Button button) {
        this.put(index, button);
    }
}
