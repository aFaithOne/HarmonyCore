package me.lumenowaty.harmonycore.utils;

import me.lumenowaty.harmonycore.components.annotations.ConfigPath;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InjectorUtils {

    public static List<Field> getFields(Object object) {
        return Arrays.stream(object.getClass().getFields())
                .filter(s -> s.isAnnotationPresent(ConfigPath.class)).collect(Collectors.toList());
    }

}
