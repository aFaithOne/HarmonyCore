package me.lumenowaty.harmonycore.utils;

import me.lumenowaty.harmonycore.components.ExceptionPrinter;

public class ParseUtil {

    public static int parseInt(String toParse) {
        try {
            return Integer.parseInt(toParse);
        } catch (NumberFormatException ex) {
            ExceptionPrinter.consoleLogException("Returned a 0 value because cannot parse String: " + toParse);
            return 0;
        }
    }

    public static boolean parseBoolean(String toParse) {
        try {
            return Boolean.parseBoolean(toParse);
        } catch (NumberFormatException ex) {
            ExceptionPrinter.consoleLogException("Returned false because cannot parse String: " + toParse);
            return false;
        }
    }
}
