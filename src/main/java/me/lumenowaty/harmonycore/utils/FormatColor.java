package me.lumenowaty.harmonycore.utils;

import net.md_5.bungee.api.ChatColor;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FormatColor {

    public static final Pattern HEX_PATTERN = Pattern.compile("#[a-fA-f0-9]{6}");

    public static String hexFormat(String toFormat) {
        Matcher match = HEX_PATTERN.matcher(toFormat);

        while(match.find()) {
            String hex = toFormat.substring(match.start(), match.end());
            toFormat = toFormat.replace(hex, ChatColor.of(hex) + "");
            match = HEX_PATTERN.matcher(toFormat);
        }
        return toFormat;
    }

    public static String ccFormat(String toFormat) {
        return ChatColor.translateAlternateColorCodes('&', toFormat);
    }

    public static List<String> ccFormat(List<String> toFormat) {
        return toFormat.stream()
                .map(s -> ChatColor.translateAlternateColorCodes('&', s))
                .collect(Collectors.toList());
    }

    public static String format(String toFormat) {
        toFormat = hexFormat(toFormat);
        toFormat = ccFormat(toFormat);

        return toFormat;
    }
}
