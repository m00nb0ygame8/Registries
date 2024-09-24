package me.moonboygamer.registries.registry;

import java.util.ArrayList;
import java.util.List;

public class RegistryTracker {
    private static final RegistryTracker INSTANCE = new RegistryTracker();
    private List<Registry> registries;

    private RegistryTracker() {
        registries = new ArrayList<>();
    }

    public static RegistryTracker getInstance() {
        return INSTANCE;
    }

    public void registerRegistry(Registry<?> registry) {
            registries.add(registry);
    }

    public List<Registry> getRegistries() {
        return null;
    }

}
