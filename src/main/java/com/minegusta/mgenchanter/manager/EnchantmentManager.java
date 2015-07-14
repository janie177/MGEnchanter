package com.minegusta.mgenchanter.manager;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.minegusta.mgenchanter.enchantments.EnchantmentType;
import com.minegusta.mgenchanter.enchantments.ItemType;
import com.minegusta.mgenchanter.enchantments.Levels;
import com.minegusta.mgenchanter.util.ChatUtil;
import com.minegusta.mgenchanter.util.RandomUtil;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

public class EnchantmentManager
{
    public static ConcurrentMap<Location, Long> cooldowns = Maps.newConcurrentMap();

    public static boolean process(Player p, ItemStack i)
    {
        ItemType type = ItemType.getItemType(i.getType());
        if(type == ItemType.UNENCHANTABLE)
        {
            ChatUtil.sendFormattedMessage(p, "This item cannot be enchanted.", "Please try again with an enchantable item.");
            return false;
        }

        int enchantmentsAlreadyAdded = i.getEnchantments().size();

        int totalMaxAmount = type.getTotalMaxAmount();

        int addable = totalMaxAmount - enchantmentsAlreadyAdded;

        if(addable < 1)
        {
            ChatUtil.sendFormattedMessage(p, "This item already has too many enchantments!", "To enchant, please use another item.");
            return false;
        }

        int amountAdded = addable;

        if(addable > type.getMaxAmount())
        {
            amountAdded = type.getMaxAmount();
        }

        //Apply the enchantments
        EnchantmentType[] enchantments = type.getEnchantmentTypes();

        List<EnchantmentType> possibilities = Lists.newArrayList();

        for(EnchantmentType enchantmentType : enchantments)
        {
            if(!i.containsEnchantment(enchantmentType.getEnchantment()))
            {
                possibilities.add(enchantmentType);
            }
        }

        if(possibilities.size() < 1)
        {
            ChatUtil.sendFormattedMessage(p, "This item already has all the possible enchantments!", "Please use another item.");
            return false;
        }

        for(int x = 0; x < amountAdded; x++)
        {
            if(possibilities.size() < 1)
            {
                break;
            }
            EnchantmentType typeAdded = possibilities.get(RandomUtil.randomNumber(possibilities.size()) - 1);

            i.addEnchantment(typeAdded.getEnchantment(), Levels.getLevel(typeAdded));

            possibilities.remove(typeAdded);
        }

        ChatUtil.sendFormattedMessage(p, "You enchanted an item!", "It cost you 25 levels.");
        return true;
    }

    public static boolean hasBooksNear(Block b)
    {
        if(cooldowns.containsKey(b.getLocation()) && TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - cooldowns.get(b.getLocation())) < 2)
        {
            return false;
        }
        int radius = 2;
        int books = 0;
        for(int x = -radius; x <= radius; x++)
        {
            for(int y = -radius; y <= radius; y++)
            {
                for(int z = -radius; z <= radius; z++)
                {
                    if(b.getRelative(z, y, z).getType() == Material.BOOKSHELF) books++;
                }
            }
        }
        cooldowns.put(b.getLocation(), System.currentTimeMillis());
        return books > 19;

    }
}
