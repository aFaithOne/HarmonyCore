package me.lumenowaty.harmonycore.components.cuboids;

import org.bukkit.Location;
import org.bukkit.World;

import java.util.Objects;

public class Territory {

    private Location minLocation;
    private Location maxLocation;

    public Territory(Location firstLocation, Location secondLocation) {
        sortLocations(firstLocation, secondLocation);
    }

    private void sortLocations(Location location, Location location2) {
        int xMin = Math.min(location.getBlockX(), location2.getBlockX());
        int zMin = Math.min(location.getBlockZ(), location2.getBlockZ());
        int yMin = Math.min(location.getBlockY(), location2.getBlockY());
        int xMax = Math.max(location.getBlockX(), location2.getBlockX());
        int zMax = Math.max(location.getBlockZ(), location2.getBlockZ());
        int yMax = Math.max(location.getBlockY(), location2.getBlockY());
        World world = location.getWorld();

        minLocation = new Location(world, xMin, yMin, zMin);
        maxLocation = new Location(world, xMax, yMax, zMax);
    }

    private boolean isLocationInside(Location location) {
        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();
        World world = location.getWorld();

        return  (! (x > maxLocation.getBlockX() ||
                y > maxLocation.getBlockY() ||
                z > maxLocation.getBlockZ() ||
                x < minLocation.getBlockX() ||
                y < minLocation.getBlockY() ||
                z < minLocation.getBlockZ() ||
                !Objects.equals(world, maxLocation.getWorld())));
    }

    public boolean isLocationInsideTerritory(Location location) {
        return isLocationInside(location);
    }

    @Override
    public String toString() {
        return "world: " + minLocation.getWorld() +
                " x1: " + minLocation.getBlockX() +
                " y1: " + minLocation.getBlockY() +
                " z1: " + minLocation.getBlockZ() +
                " x2: " + maxLocation.getBlockX() +
                " y2: " + maxLocation.getBlockY() +
                " z2: " + maxLocation.getBlockZ();
    }
}
