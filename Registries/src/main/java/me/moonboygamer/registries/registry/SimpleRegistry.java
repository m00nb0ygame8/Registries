package me.moonboygamer.registries.registry;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class SimpleRegistry<T extends Registerable> implements Registry<T>{
    private Set<RegistryEntry<T>> entries;
    private RegistryStatus status;

    private String name;

    private SimpleRegistry(String name) {
        this.name = name;
        this.entries = Collections.emptySet();
        this.status = RegistryStatus.INACTIVE;
        RegistryTracker.getInstance().registerRegistry(this);
    }

    @Override
    public RegistryEntry<T> register(T registerable) throws IllegalAccessException {
        if(!this.status.equals(RegistryStatus.FROZEN)) {
            RegistryEntry<T> entry = RegistryEntry.of(registerable);
            this.entries.add(entry);
            if(this.status == RegistryStatus.INACTIVE) {
                this.status = RegistryStatus.ACTIVE;
            }
            return entry;
        }
        throw new IllegalAccessException("Registry is frozen and cannot be modified.");
    }

    @Override
    public List<RegistryEntry<T>> getEntries() {
        return this.entries.stream().toList();
    }

    public static SimpleRegistry create(String name) {
        return new SimpleRegistry(name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public RegistryStatus getStatus() {
        return this.status;
    }

    @Override
    public void freeze() {
        this.status = RegistryStatus.FROZEN;
    }
}
