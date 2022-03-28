package me.lumenowaty.harmonycore.utils;

public class HMath {

    public static int getRandomInRange(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
