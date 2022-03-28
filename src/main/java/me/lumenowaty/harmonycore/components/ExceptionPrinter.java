package me.lumenowaty.harmonycore.components;

import org.bukkit.Bukkit;

import java.util.Objects;

public class ExceptionPrinter {

    public static void logException(String exception) {
        Bukkit.getOperators().forEach(s -> {
            if (s.isOnline()) Objects.requireNonNull(s.getPlayer()).sendMessage(exception);
        });
    }

    public static void consoleLogException(String info) {
        Bukkit.getLogger().info(info);
    }
}
