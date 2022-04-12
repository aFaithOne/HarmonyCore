package me.lumenowaty.harmonycore.components.configs;

import me.lumenowaty.harmonycore.HarmonyCore;
import me.lumenowaty.harmonycore.components.ConfigurationClass;
import me.lumenowaty.harmonycore.components.annotations.ConfigPath;;
import me.lumenowaty.harmonycore.injectors.DataInjector;

public class PluginConfig extends ConfigurationClass<HarmonyCore> {

    public PluginConfig(String name, HarmonyCore main) {
        super(name, main);
    }

    @Override
    public void injectData() {
        DataInjector.injectClassDataFromFile(this, super.config);
    }

    @ConfigPath(path = "messages.player-command")
    public String playerCommand;

    @ConfigPath(path ="messages.empty-enchantment")
    public String emptyEnchantment;

    @ConfigPath(path = "messages.magicWand-second-selection")
    public String magicWandSecondSelection;

    @ConfigPath(path = "messages.magicWand-first-selection")
    public String magicWandFirstSelection;

}
