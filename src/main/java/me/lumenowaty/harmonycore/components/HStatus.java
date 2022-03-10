package me.lumenowaty.harmonycore.components;

import me.lumenowaty.harmonycore.components.interfaces.Statusable;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

public final class HStatus implements Statusable, Serializable {

    private boolean status;
    @Nullable
    private String description;

    public HStatus() {
        this.status = true;
        this.description = null;
    }

    @Override
    public boolean getStatus() {
        return this.status;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}
