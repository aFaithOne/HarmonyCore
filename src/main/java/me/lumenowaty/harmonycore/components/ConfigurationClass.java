package me.lumenowaty.harmonycore.components;

import me.lumenowaty.harmonycore.components.interfaces.Injectable;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class ConfigurationClass<T extends JavaPlugin> implements Injectable {

    private T main;
    private final YamlConfig<T> yamlConfig;
    protected FileConfiguration config;

    public ConfigurationClass(String name, T main) {
        this.main = main;
        yamlConfig = new YamlConfig<>(name, main);
        reload();
    }

    public void reload() {
        yamlConfig.createConfig();
        yamlConfig.reload();
        config = yamlConfig.getConfig();
    }

    public abstract void injectData();

    public FileConfiguration getConfig() {
        return config;
    }
}
