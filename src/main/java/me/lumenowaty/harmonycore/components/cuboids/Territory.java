package me.lumenowaty.harmonycore.components.cuboids;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Territory implements Serializable {

    private String world;

    private int xMin;
    private int yMin;
    private int zMin;

    private int xMax;
    private int yMax;
    private int zMax;

    public Territory(Location firstLocation, Location secondLocation) {
        sortLocations(firstLocation, secondLocation);
    }

    private void sortLocations(Location location, Location location2) {
        xMin = Math.min(location.getBlockX(), location2.getBlockX());
        zMin = Math.min(location.getBlockZ(), location2.getBlockZ());
        yMin = Math.min(location.getBlockY(), location2.getBlockY());
        xMax = Math.max(location.getBlockX(), location2.getBlockX());
        zMax = Math.max(location.getBlockZ(), location2.getBlockZ());
        yMax = Math.max(location.getBlockY(), location2.getBlockY());
        world = location.getWorld().getName();
    }

    private boolean isLocationInside(Location location) {
        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();
        World world = location.getWorld();

        return  (! (x > xMax ||
                y > yMax ||
                z > zMax ||
                x < xMin ||
                y < yMin ||
                z < zMin ||
                !Objects.equals(world, Bukkit.getWorld(this.world))));
    }

    public boolean isLocationInsideTerritory(Location location) {
        return isLocationInside(location);
    }

    @Override
    public String toString() {
        return "world: " + world +
                " x1: " + xMin +
                " y1: " + yMin +
                " z1: " + zMin +
                " x2: " + xMax +
                " y2: " + yMax +
                " z2: " + zMax;
    }

    public List<String> toStringArray() {
        return Arrays.asList("world: " + world,
                " x1: " + xMin,
                " y1: " + yMin,
                " z1: " + zMin,
                " x2: " + xMax,
                " y2: " + yMax,
                " z2: " + zMax);
    }
}
