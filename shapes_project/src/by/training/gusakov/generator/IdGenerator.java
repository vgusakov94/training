package by.training.gusakov.generator;

import java.util.UUID;

public class IdGenerator {

    private IdGenerator() {
    }

    public static String generatorID() {
        UUID uniqueKey = UUID.randomUUID();
        String id = uniqueKey.toString();
        return id;
    }

}
