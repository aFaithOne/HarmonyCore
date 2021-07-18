package me.lumenowaty.harmonycore.components;

import me.lumenowaty.harmonycore.components.interfaces.SubCommand;
import org.bukkit.command.CommandExecutor;

public abstract class HSubCommand<T extends CommandExecutor> implements SubCommand {

    protected T commandExecutor;

    public HSubCommand(T commandExecutor) {
        this.commandExecutor = commandExecutor;
    }
}
