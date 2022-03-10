package me.lumenowaty.harmonycore.injectors;

import me.lumenowaty.harmonycore.components.annotations.ConfigItem;
import me.lumenowaty.harmonycore.utils.InjectorUtils;
import org.bukkit.configuration.file.FileConfiguration;

import java.lang.reflect.Field;
import java.util.List;

public class ItemStackInjector {

    public static void injectClassDataFromFile(Object object, FileConfiguration configuration, String pathToItem) {
        inject(object, configuration, pathToItem);
    }

    private static void inject(Object object, FileConfiguration configuration, String pathToItem) {
        List<Field> fields = InjectorUtils.getFields(object);

        for (Field f : fields) {
            ConfigItem reader = f.getAnnotation(ConfigItem.class);
            f.setAccessible(true);
            try {
                if (reader == null) continue;
                if (f.getName().equals(reader.itemField())) continue;

                f.set(object, configuration.get(pathToItem + "." + reader.itemField()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
