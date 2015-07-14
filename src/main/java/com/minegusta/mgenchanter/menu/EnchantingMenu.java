package com.minegusta.mgenchanter.menu;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

public class EnchantingMenu
{
    public static ConcurrentMap<Inventory, Boolean> invs = Maps.newConcurrentMap();

    public static void openMenu(Player p)
    {
        Inventory inv = Bukkit.createInventory(p, 9, ChatColor.DARK_PURPLE + "Enchanting Table");
        for(int i = 0; i < inv.getSize(); i++)
        {
            inv.setItem(i, createStack(Material.STAINED_GLASS_PANE, 1, "", ""));
        }

        inv.setItem(1, createStack(Material.BOOK, 0, ChatColor.LIGHT_PURPLE + "Enchanting", ChatColor.GREEN + "Place your item", ChatColor.GREEN + "next to this.", ChatColor.DARK_GREEN + "--->", ChatColor.LIGHT_PURPLE + "Cost: " + ChatColor.AQUA + "25"));
        inv.setItem(2, new ItemStack(Material.AIR));


        p.openInventory(inv);
        invs.put(inv, true);
    }

    public static void update(Inventory inv, boolean itemSlot)
    {
        if(itemSlot)
        {
            if(inv.getItem(2) != null || inv.getItem(2).getType() != Material.AIR)inv.setItem(2, new ItemStack(Material.AIR));
            else inv.setItem(2, createStack(Material.ITEM_FRAME, 0, ChatColor.DARK_PURPLE + "Item Slot", ChatColor.LIGHT_PURPLE + "Place Item", ChatColor.LIGHT_PURPLE + "Here."));
        }

        for(ItemStack i : inv.getContents())
        {
            if(i.getType() == Material.STAINED_GLASS_PANE)
            {
                int newData = i.getDurability() + 1;
                if(newData > 14) newData = 0;
                i.setDurability((short) newData);
            }
        }
    }

    private static ItemStack createStack(Material m, int data, String name, String... lore)
    {
        return new ItemStack(m, 1, (byte)data)
        {
            {
                ItemMeta meta = getItemMeta();
                List<String> loreList = Lists.newArrayList(lore);
                meta.setDisplayName(name);
                meta.setLore(loreList);
                setItemMeta(meta);
            }
        };
    }
}
