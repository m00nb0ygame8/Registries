package me.moonboygamer.registries;

import me.moonboygamer.registries.registry.RegistryTracker;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Registries extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("----------------Registries By MoonBoyGamer----------------");
        Bukkit.getLogger().info("This plugin is a simple registry system for Minecraft plugins.");
        Bukkit.getLogger().info("Registry Information:");
        RegistryTracker.getInstance().getRegistries().forEach(registry -> {
            Bukkit.getLogger().info("Registry: " + registry.getName() + ", Status: " + registry.getStatus());
        });
        Bukkit.getLogger().info("---------------------------------------------------------");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
