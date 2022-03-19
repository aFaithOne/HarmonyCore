package me.lumenowaty.harmonycore.components;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class ConfigurationClass<T extends JavaPlugin> {
    
    private final YamlConfig<T> yamlConfig;
    private FileConfiguration config;

    public ConfigurationClass(String name, T main) {
        yamlConfig = new YamlConfig<>(name, main);
        reload();
    }

    public void reload() {
        yamlConfig.createConfig();
        yamlConfig.reload();
        config = yamlConfig.getConfig();
    }

    public FileConfiguration getConfig() {
        return config;
    }
}
