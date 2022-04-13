package me.lumenowaty.harmonycore.components.graphicinterfaces;

import me.lumenowaty.harmonycore.components.HItemData;
import me.lumenowaty.harmonycore.components.annotations.Optional;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Button {

    private HItemData buttonItem;
    private int index;
    @Optional
    private Runnable action;

    public Button(@NotNull HItemData buttonItem, int placeId, @Nullable Runnable action) {
        this.buttonItem = buttonItem;
        this.index = placeId;
        this.action = action;
    }

    public HItemData getButtonItem() {
        return buttonItem;
    }

    public Button setButtonItem(HItemData buttonItem) {
        this.buttonItem = buttonItem;
        return this;
    }

    public int getIndex() {
        return index;
    }

    public Button setIndex(int index) {
        this.index = index;
        return this;
    }

    public Runnable getAction() {
        return action;
    }

    public Button setAction(Runnable action) {
        this.action = action;
        return this;
    }

    public void insertButtonToInventory(Inventory inventory) {
        inventory.setItem(index, buttonItem.getItem());
    }
}
