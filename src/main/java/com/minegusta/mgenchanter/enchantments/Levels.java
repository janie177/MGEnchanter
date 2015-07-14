package com.minegusta.mgenchanter.enchantments;

import com.minegusta.mgenchanter.util.RandomUtil;

public class Levels
{
    private static final int level2Chance = 40;
    private static final int level3Chance = 20;
    private static final int level4Chance = 10;
    private static final int level5Chance = 5;
    private static final int level6Chance = 2;

    public static int getLevel(EnchantmentType ench)
    {
        int level = 1;
        int loop = 1;
        while (loop <= ench.getMaxLevel())
        {
            if(RandomUtil.chance(getChance(loop)))
            {
                level = loop;
            }
            loop++;
        }

        return level;
    }

    private static int getChance(int level)
    {
        int returned;
        switch (level)
        {
            case 2: returned = level2Chance;
                break;
            case 3: returned = level3Chance;
                break;
            case 4: returned = level4Chance;
                break;
            case 5: returned = level5Chance;
                break;
            case 6: returned = level6Chance;
                break;
            default: returned = 100;
        }
        return returned;
    }
}
