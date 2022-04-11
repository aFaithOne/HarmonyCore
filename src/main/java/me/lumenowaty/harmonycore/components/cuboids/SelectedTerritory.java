package me.lumenowaty.harmonycore.components.cuboids;

import me.lumenowaty.harmonycore.components.collections.HMap;
import org.bukkit.Location;

import java.util.UUID;

public class SelectedTerritory {


    public static class Holder extends HMap<UUID, SelectedTerritory.MagicSelect> {

    }

    static class MagicSelect {
        private Location location;
        private Location location2;

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public Location getLocation2() {
            return location2;
        }

        public void setLocation2(Location location2) {
            this.location2 = location2;
        }
    }
}

