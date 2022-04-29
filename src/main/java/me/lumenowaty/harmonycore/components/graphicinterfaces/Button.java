package me.lumenowaty.harmonycore.components.graphicinterfaces;

import me.lumenowaty.harmonycore.components.HItemData;
import me.lumenowaty.harmonycore.components.annotations.Optional;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.function.Consumer;

public class Button implements Serializable {

    private final int id;
    private HItemData buttonItem;
    @Optional
    private Consumer<Player> action;

    public Button(@NotNull HItemData buttonItem, @Nullable Consumer<Player> action, int id) {
        this.buttonItem = buttonItem;
        this.action = action;
        this.id = id;
    }

    public void insertButtonIntoInterface(GraphicInterface graphicInterface) {
        graphicInterface.set(id, this);
    }

    public void insertButtonAsDefaultIntoInterface(GraphicInterface graphicInterface) {
        for (int i = 0; i < (graphicInterface.rows * 9); i++) {
            graphicInterface.set(i, this);
        }
    }

    public int getId() {
        return id;
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
