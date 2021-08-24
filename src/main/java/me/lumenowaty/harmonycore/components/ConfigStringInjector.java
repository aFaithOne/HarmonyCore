package me.lumenowaty.harmonycore.components;

import me.lumenowaty.harmonycore.components.annotations.ConfigPath;
import org.bukkit.configuration.file.FileConfiguration;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class ConfigStringInjector {

    public static void injectClassDataFromFile(Object object, FileConfiguration configuration) {
        inject(object, configuration);
    }

    private static void inject(Object object, FileConfiguration configuration) {
        List<Field> fields = Arrays.stream(object.getClass().getFields())
                .filter(s -> s.isAnnotationPresent(ConfigPath.class)).collect(Collectors.toList());

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


