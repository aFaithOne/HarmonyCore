package me.lumenowaty.harmonycore.components.graphicinterfaces;

import me.lumenowaty.harmonycore.components.HItemData;
import me.lumenowaty.harmonycore.components.annotations.Optional;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.function.Consumer;

public class Button implements Serializable {

    private HItemData buttonItem;
    @Optional
    private Consumer<Player> action;

    public Button(@NotNull HItemData buttonItem, @Nullable Consumer<Player> action) {
        this.buttonItem = buttonItem;
        this.action = action;
    }

    public HItemData getButtonItem() {
        return buttonItem;
    }

    public Button setButtonItem(HItemData buttonItem) {
        this.buttonItem = buttonItem;
        return this;
    }

    public Consumer<Player> getAction() {
        return action;
    }

    public Button setAction(Consumer<Player> action) {
        this.action = action;
        return this;
    }
}
