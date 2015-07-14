package com.minegusta.mgenchanter.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatUtil
{
    public static void sendFormattedMessage(Player p, String... strings)
    {
        p.sendMessage(ChatColor.YELLOW + "=-=-=" + ChatColor.GOLD + "MG Enchanter" + ChatColor.YELLOW + "=-=-=");
        for(String s : strings)
        {
            p.sendMessage(ChatColor.GRAY + s);
        }
        p.sendMessage(ChatColor.YELLOW + "=-=-= =-= =-=-=");
    }
}
