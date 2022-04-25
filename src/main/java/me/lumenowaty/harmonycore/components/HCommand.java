package me.lumenowaty.harmonycore.components;

import me.lumenowaty.harmonycore.api.API;
import org.bukkit.command.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class HCommand<T extends JavaPlugin> implements CommandExecutor, TabCompleter {

    protected String command;
    protected String permission;
    protected T plugin;

    public HCommand(String command, String permission, T plugin) {
        this.command = command;
        this.permission = permission;
        this.plugin = plugin;
    }

    public void registerCommand() {
        try {
            PluginCommand command = plugin.getCommand(this.command);
            command.setExecutor(this);
            command.setTabCompleter(this);
            command.setPermission(permission);

        }catch (NullPointerException ex) {
            ExceptionPrinter.logException(API.pluginConfig.nullableCommand);
        }
    }

    @Override
    public abstract boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args);

    @Nullable
    @Override
    public abstract List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String alias, @NotNull String[] args);
}
