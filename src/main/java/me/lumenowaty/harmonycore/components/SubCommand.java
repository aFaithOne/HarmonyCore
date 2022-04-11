package me.lumenowaty.harmonycore.components;

import me.lumenowaty.harmonycore.components.interfaces.CommandExecutable;
import org.bukkit.command.CommandExecutor;

public abstract class SubCommand<T extends CommandExecutor> implements CommandExecutable {

    protected T commandExecutor;

    public SubCommand(T commandExecutor) {
        this.commandExecutor = commandExecutor;
    }
}
