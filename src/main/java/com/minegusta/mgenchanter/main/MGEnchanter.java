package com.minegusta.mgenchanter.main;

import com.minegusta.mgenchanter.listeners.EnchantingListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class MGEnchanter extends JavaPlugin {

    private static Plugin plugin;

    @Override
    public void onEnable()
    {
        plugin = this;
        Bukkit.getPluginManager().registerEvents(new EnchantingListener(), this);
    }

    @Override
    public void onDisable()
    {

    }

    public static Plugin getPlugin()
    {
        return plugin;
    }
}
