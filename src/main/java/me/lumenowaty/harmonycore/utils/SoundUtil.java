package me.lumenowaty.harmonycore.utils;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.List;

public class SoundUtil {

    public static void playSound(List<Player> players, Sound sound) {
        players.forEach(p -> p.playSound(p.getLocation(), sound, 3, 1));
    }
}
