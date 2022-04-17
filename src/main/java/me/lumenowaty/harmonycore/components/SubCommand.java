package me.lumenowaty.harmonycore.components;

import me.lumenowaty.harmonycore.components.interfaces.CommandExecutable;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;

public abstract class SubCommand<T extends CommandExecutor> implements CommandExecutable, TabCompleter {

    protected T commandExecutor;

    public SubCommand(T commandExecutor) {
        this.commandExecutor = commandExecutor;
    }
}
