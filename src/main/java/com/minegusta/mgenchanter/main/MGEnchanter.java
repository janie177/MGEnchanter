package com.minegusta.mgenchanter.main;

import com.minegusta.mgenchanter.commands.EnchantingCommand;
import com.minegusta.mgenchanter.listeners.EnchantingListener;
import com.minegusta.mgenchanter.tasks.EnchantingMenuTask;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class MGEnchanter extends JavaPlugin {

    private static Plugin plugin;

    @Override
    public void onEnable()
    {
        //Plugin
        plugin = this;

        //Listeners
        Bukkit.getPluginManager().registerEvents(new EnchantingListener(), this);

        //Commands
        getCommand("mgenchant").setExecutor(new EnchantingCommand());

        //Tasks
        EnchantingMenuTask.start();
    }

    @Override
    public void onDisable()
    {
        //Stop tasks
        EnchantingMenuTask.stop();

    }

    public static Plugin getPlugin()
    {
        return plugin;
    }
}
