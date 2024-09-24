package me.moonboygamer.registries.registry;

public class RegistryEntry<T extends Registerable> {
    private final T registerable;

    private RegistryEntry(T registerable) {
        this.registerable = registerable;
    }

    public static <K extends Registerable> RegistryEntry of(K registerable) {
        return new RegistryEntry(registerable);
    }

    public T get() {
        return registerable;
    }
}
