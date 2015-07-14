package com.minegusta.mgenchanter.listeners;

import com.minegusta.mgenchanter.main.MGEnchanter;
import com.minegusta.mgenchanter.manager.EnchantmentManager;
import com.minegusta.mgenchanter.menu.EnchantingMenu;
import com.minegusta.mgenchanter.util.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class EnchantingListener implements Listener
{
    @EventHandler
    public void onEnchantingtableInteract(PlayerInteractEvent e)
    {
        if(e.hasBlock() && e.getClickedBlock().getType() == Material.ENCHANTMENT_TABLE)
        {
            e.setCancelled(true);

            if(e.getPlayer().getLevel() < 25)
            {
                ChatUtil.sendFormattedMessage(e.getPlayer(), "You need atleast 25 levels to enchant an item!", "You only have " + e.getPlayer().getLevel() + ".");
                return;
            }

            if(!EnchantmentManager.hasBooksNear(e.getClickedBlock()))
            {
                ChatUtil.sendFormattedMessage(e.getPlayer(), "This enchanting table needs more bookcases!", "It needs at least 20 to work.");
                return;
            }

            EnchantingMenu.openMenu(e.getPlayer());
        }
    }

    @EventHandler
    public void onEnchantingMenuClick(InventoryClickEvent e)
    {
        if(!(e.getWhoClicked() instanceof Player))return;

        Player p = (Player) e.getWhoClicked();

        if(e.getClickedInventory() == null)return;

        if(EnchantingMenu.invs.containsKey(e.getClickedInventory()))
        {
            e.setCancelled(true);

            if(e.getSlot() == 2)
            {
                if(p.getLevel() < 25)
                {
                    ChatUtil.sendFormattedMessage(p, "You need atleast 25 levels to enchant an item!", "You only have " + p.getLevel() + ".");
                    return;
                }
                if(EnchantmentManager.process(p, e.getCursor()))
                {
                    p.setLevel(p.getLevel() - 25);

                    final Location l = p.getLocation();
                    for(int i = 0; i < 4; i++)
                    {
                        final int k = i;
                        Bukkit.getScheduler().scheduleSyncDelayedTask(MGEnchanter.getPlugin(), ()-> l.getWorld().spigot().playEffect(l, Effect.FLYING_GLYPH, 0, 0, 1, k * 0.5F, 1, 1/30, 30, 30));
                    }
                }
            }
        }

    }
}
