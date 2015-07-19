package com.minegusta.mgenchanter.listeners;

import com.minegusta.mgenchanter.util.ChatUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class VillagerListener implements Listener {

    @EventHandler
    public void onVillagerTrade(InventoryClickEvent e)
    {
        if(e.getClickedInventory() != null && e.getClickedInventory().getType() == InventoryType.MERCHANT && e.getWhoClicked() instanceof Player)
        {
            ItemStack clickedItem = e.getCurrentItem();
            Player p = (Player) e.getWhoClicked();

            if(clickedItem != null && clickedItem.getType() == Material.ENCHANTED_BOOK)
            {
                ChatUtil.sendFormattedMessage(p, "Enchantments cannot be bought this way!");
                e.setCancelled(true);
            }
        }
    }
}
