package by.training.gusakov.warehouse;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static Warehouse instance;
    private Map<String, PyramidParameters> parametersMap;

    private Warehouse() {
        parametersMap = new HashMap<>();
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public void remove(Long key) {
        parametersMap.remove(key);
    }

    public PyramidParameters put(String key, PyramidParameters pyramidParameters) {
        return parametersMap.put(key, pyramidParameters);
    }

    public PyramidParameters get(String key) {
        return parametersMap.get(key);
    }
}