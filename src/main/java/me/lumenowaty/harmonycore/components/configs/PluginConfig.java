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
    public PluginConfig injectData() {
        DataInjector.injectClassDataFromFile(this, super.config);
        return this;
    }

    @ConfigPath(path = "messages.player-command")
    public String playerCommand;

    @ConfigPath(path ="messages.empty-enchantment")
    public String emptyEnchantment;

    @ConfigPath(path = "messages.magicWand-second-selection")
    public String magicWandSecondSelection;

    @ConfigPath(path = "messages.magicWand-first-selection")
    public String magicWandFirstSelection;

    @ConfigPath(path ="messages.no-permission")
    public String noPermission;

    @ConfigPath(path = "messages.nullable-command")
    public String nullableCommand;

}
