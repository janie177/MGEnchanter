package com.minegusta.mgenchanter.tasks;

import com.google.common.collect.Maps;
import com.minegusta.mgenchanter.main.MGEnchanter;
import com.minegusta.mgenchanter.menu.EnchantingMenu;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import java.util.concurrent.ConcurrentMap;

public class EnchantingMenuTask
{
    private static int id = -1;
    private static boolean updateSlow = false;

    public static void start()
    {
        id = Bukkit.getScheduler().scheduleSyncRepeatingTask(MGEnchanter.getPlugin(), ()->
        {
            EnchantingMenu.invs.keySet().stream().forEach(inv ->
            {
                if(inv.getViewers().size() == 0)
                {
                    EnchantingMenu.invs.remove(inv);
                }
                else
                {
                    EnchantingMenu.update(inv, updateSlow);
                }
            });
            updateSlow = !updateSlow;
        },5,5);
    }

    public static void stop()
    {
        if(id != -1)
        {
            Bukkit.getScheduler().cancelTask(id);
        }
    }
}
