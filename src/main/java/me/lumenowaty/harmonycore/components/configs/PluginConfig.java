package me.lumenowaty.harmonycore.components.configs;

import me.lumenowaty.harmonycore.HarmonyCore;
import me.lumenowaty.harmonycore.components.ConfigurationClass;
import me.lumenowaty.harmonycore.components.annotations.ConfigPath;
import me.lumenowaty.harmonycore.injectors.ConfigDataInjector;

public class PluginConfig extends ConfigurationClass<HarmonyCore> {

    public PluginConfig(String name, HarmonyCore main) {
        super(name, main);
    }

    @Override
    public void injectData() {
        ConfigDataInjector.injectClassDataFromFile(this, super.config);
    }

    @ConfigPath(path = "messages.player-command")
    public String playerCommand;
}
