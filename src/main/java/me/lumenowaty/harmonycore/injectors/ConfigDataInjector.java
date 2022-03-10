package me.lumenowaty.harmonycore.injectors;

import me.lumenowaty.harmonycore.components.annotations.ConfigPath;
import me.lumenowaty.harmonycore.utils.InjectorUtils;
import org.bukkit.configuration.file.FileConfiguration;

import java.lang.reflect.Field;
import java.util.List;

public final class ConfigDataInjector {

    public static void injectClassDataFromFile(Object object, FileConfiguration configuration) {
        inject(object, configuration);
    }

    private static void inject(Object object, FileConfiguration configuration) {
        List<Field> fields = InjectorUtils.getFields(object);

        for (Field f : fields) {
            ConfigPath reader = f.getAnnotation(ConfigPath.class);
            f.setAccessible(true);
            try {
                if (reader == null) continue;
                f.set(object, configuration.get(reader.path()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


