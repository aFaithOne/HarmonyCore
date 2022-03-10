package me.lumenowaty.harmonycore.components.cuboids;

import org.bukkit.Location;
import org.bukkit.World;

public class HTerritory {

    private Location minLocation;
    private Location maxLocation;

    public HTerritory(Location firstLocation, Location secondLocation) {
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
                !world.equals(maxLocation.getWorld())));
    }

    public boolean isLocationInsideTerritory(Location location) {
        return isLocationInside(location);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("world: ").append(minLocation.getWorld())
                .append(" x1: ").append(minLocation.getBlockX())
                .append(" y1: ").append(minLocation.getBlockY())
                .append(" z1: ").append(minLocation.getBlockZ())
                .append(" x2: ").append(maxLocation.getBlockX())
                .append(" y2: ").append(maxLocation.getBlockY())
                .append(" z2: ").append(maxLocation.getBlockZ());

        return builder.toString();
    }
}
