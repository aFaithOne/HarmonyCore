package me.lumenowaty.harmonycore.components.cuboids;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.plugin.java.JavaPlugin;

public class Structure<T extends JavaPlugin> {

    private T main;
    private final Territory territory;
    private Material[][][] schema;
    private int copyTaskID;
    private int pasteTaskID;
    private int removeBlockTaskID;

    public Structure(T main, Territory territory) {
        this.main = main;
        this.territory = territory;
    }

    public void saveToSchema() {
        copyTaskID = Bukkit.getScheduler().scheduleSyncDelayedTask(main, () -> {
            int sizeX = territory.getMax().getX() + 1 - territory.getMin().getX();
            int sizeY = territory.getMax().getY() + 1 - territory.getMin().getY();
            int sizeZ = territory.getMax().getZ() + 1 - territory.getMin().getZ();

            schema = new Material[sizeX][sizeY][sizeZ];

            for (int i = 0; i < sizeX; i++) {
                for (int j = 0; j < sizeY; j++) {
                    for (int k = 0; k < sizeZ; k++) {
                        int a = territory.getMin().getX()+i;
                        int b = territory.getMin().getY()+j;
                        int c = territory.getMin().getZ()+k;

                        schema[i][j][k] = (new Location(
                                territory.getMax().getLocation().getWorld(), a, b, c)
                                .getBlock().getType());
                    }
                }
            }
            cancelCopyTask();
        }, 0L);
    }

    public void loadSchema() {
        pasteTaskID = Bukkit.getScheduler().scheduleSyncDelayedTask(main, () -> {
            int sizeX = territory.getMax().getX() + 1 - territory.getMin().getX();
            int sizeY = territory.getMax().getY() + 1 - territory.getMin().getY();
            int sizeZ = territory.getMax().getZ() + 1 - territory.getMin().getZ();

            for (int i = 0; i < sizeX; i++) {
                for (int j = 0; j < sizeY; j++) {
                    for (int k = 0; k < sizeZ; k++) {
                        int a = territory.getMin().getX()+i;
                        int b = territory.getMin().getY()+j;
                        int c = territory.getMin().getZ()+k;

                        new Location(territory.getMax().getLocation().getWorld(), a, b, c).getBlock().setType(schema[i][j][k]);
                    }
                }
            }
            cancelPasteTask();
        }, 0L);
    }

    public void removeBlock(Material material) {
        removeBlockTaskID = Bukkit.getScheduler().scheduleSyncDelayedTask(main, () -> {
            int sizeX = territory.getMax().getX() + 1 - territory.getMin().getX();
            int sizeY = territory.getMax().getY() + 1 - territory.getMin().getY();
            int sizeZ = territory.getMax().getZ() + 1 - territory.getMin().getZ();

            for (int i = 0; i < sizeX; i++) {
                for (int j = 0; j < sizeY; j++) {
                    for (int k = 0; k < sizeZ; k++) {
                        int a = territory.getMin().getX()+i;
                        int b = territory.getMin().getY()+j;
                        int c = territory.getMin().getZ()+k;

                        Block block = new Location(territory.getMax().getLocation().getWorld(), a, b, c).getBlock();
                        Material type = block.getType();
                        if (type.equals(material)) {
                            block.setType(Material.AIR);
                        }
                    }
                }
            }
            cancelPasteTask();
        }, 0L);
    }

    private void cancelCopyTask() {
        Bukkit.getScheduler().cancelTask(copyTaskID);
    }

    private void cancelPasteTask() {
        Bukkit.getScheduler().cancelTask(pasteTaskID);
    }

    private void cancelRemoveBlockTask() {
        Bukkit.getScheduler().cancelTask(removeBlockTaskID);
    }
}
