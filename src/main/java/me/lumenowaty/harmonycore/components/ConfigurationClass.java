package me.lumenowaty.harmonycore.components;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.Serializable;

public abstract class ConfigurationClass<T extends JavaPlugin> implements Serializable {

    private final T main;
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

    public abstract ConfigurationClass<T> injectData();

    public FileConfiguration getConfig() {
        return config;
    }
}
