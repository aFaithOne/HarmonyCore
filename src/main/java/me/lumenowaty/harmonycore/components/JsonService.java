package me.lumenowaty.harmonycore.components;

import com.google.gson.Gson;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public final class JsonService<S> {

    private final Gson gson;
    private final Path path;
    private S object;


    public JsonService(JavaPlugin main, S object, String fileName, Path path) {
        this.gson = new Gson();
        this.object = object;
        this.path = Path.of(
                main.getDataFolder() + File.separator +
                        path + File.separator +
                        fileName + File.separator + "json");
    }

    public boolean saveObjectDataToJson() {
        try {
            Writer writer = Files.newBufferedWriter(path);
            gson.toJson(object, writer);
            return true;
        } catch (IOException e) {
            ExceptionPrinter.logException(e.getLocalizedMessage());
            return false;
        }
    }

    public boolean readObjectDataFromJson(Class<S> clazz) {
        try {
            Reader reader = Files.newBufferedReader(path);
            this.object = gson.fromJson(reader, clazz);
            return true;
        } catch (IOException e) {
            ExceptionPrinter.logException(e.getLocalizedMessage());
            return false;
        }
    }

    public Optional<S> getObject() {
        return Optional.ofNullable(object);
    }
}
