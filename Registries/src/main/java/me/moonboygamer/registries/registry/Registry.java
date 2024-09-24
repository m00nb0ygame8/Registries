package me.moonboygamer.registries.registry;

import java.util.List;

public interface Registry<T extends Registerable> {
    RegistryEntry<T> register(T registerable) throws IllegalAccessException;
    List<RegistryEntry<T>> getEntries();
    String getName();
    RegistryStatus getStatus();
    void freeze();
}
