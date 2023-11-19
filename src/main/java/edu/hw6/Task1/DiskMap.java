package edu.hw6.Task1;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DiskMap implements Map<String, String> {
    private final String filePath;
    private HashMap<String, String> map;

    public DiskMap(String filePath) {
        this.filePath = filePath;
        this.map = new HashMap<>();
        load();
    }

    private void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    map.put(parts[0], parts[1]);
                }
            }
        } catch (IOException ex) {
            ex.getStackTrace();
        }
    }

    private void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (var entry : map.entrySet()) {
                String formattedEntry = String.format("%s:%s", entry.getKey(), entry.getValue());
                writer.write(formattedEntry);
                writer.newLine();
            }

        } catch (IOException e) {
            // Handle any IO exception here
            e.printStackTrace();
        }
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return map.get(key);
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        String previousVal = map.put(key, value);
        save();
        return previousVal;
    }

    @Override
    public String remove(Object key) {
        String toRemove = map.remove(key);
        save();
        return toRemove;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        map.putAll(m);
        save();
    }

    @Override
    public void clear() {
        map.clear();
        save();
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        return map.keySet();
    }

    @NotNull
    @Override
    public Collection<String> values() {
        return map.values();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        return map.entrySet();
    }
}
