package me.lumenowaty.harmonycore.injectors;

import me.lumenowaty.harmonycore.components.annotations.ConfigItem;
import me.lumenowaty.harmonycore.components.annotations.ConfigPath;
import org.bukkit.configuration.file.FileConfiguration;

import java.lang.reflect.Field;

import static me.lumenowaty.harmonycore.utils.InjectorUtils.getItemFields;
import static me.lumenowaty.harmonycore.utils.InjectorUtils.getConfigFields;

public final class DataInjector {

    public static void injectClassDataFromFile(Object object, FileConfiguration configuration) {
        inject(object, configuration);
    }

    public static void injectClassDataFromFile(Object object, FileConfiguration configuration, String pathToItem) {
        inject(object, configuration, pathToItem);
    }

    private static void inject(Object object, FileConfiguration configuration) {
        for (Field f : getConfigFields(object)) {
            f.setAccessible(true);
            ConfigPath reader = f.getAnnotation(ConfigPath.class);
            try {
                if (reader == null) continue;

                f.set(object, configuration.get(reader.path()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private static void inject(Object object, FileConfiguration configuration, String pathToItem) {
        for (Field f : getItemFields(object)) {
            f.setAccessible(true);

            ConfigItem reader = f.getAnnotation(ConfigItem.class);
            try {
                if (reader == null) continue;

                f.set(object, configuration.get(pathToItem + "." + reader.itemField()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}


