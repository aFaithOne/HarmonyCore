package me.lumenowaty.harmonycore.components;

import me.lumenowaty.harmonycore.HarmonyCore;
import me.lumenowaty.harmonycore.components.interfaces.Savable;

import java.io.File;

@Deprecated
public abstract class HLoader implements Savable {

    protected final String filePath;

    public HLoader(String filePath) {
        this.filePath = HarmonyCore.getInstance().getDataFolder() + File.separator+filePath;
    }
}
