package com.minegusta.mgenchanter.enchantments;

import org.bukkit.enchantments.Enchantment;

public enum EnchantmentType
{
    SHARPNESS(Enchantment.DAMAGE_ALL, 3),
    EFFICIENCY(Enchantment.DIG_SPEED, 5),
    SMITE(Enchantment.DAMAGE_UNDEAD, 4),
    BANE_OF_THE_ARTHROPODS(Enchantment.DAMAGE_ARTHROPODS, 4),
    FIRE_ASPECT(Enchantment.FIRE_ASPECT, 2),
    KNOCKBACK(Enchantment.KNOCKBACK, 2),
    PUNCH(Enchantment.ARROW_KNOCKBACK, 3),
    POWER(Enchantment.ARROW_DAMAGE, 3),
    INFINITY(Enchantment.ARROW_INFINITE, 1),
    FLAME(Enchantment.ARROW_FIRE, 2),
    SILK_TOUCH(Enchantment.SILK_TOUCH, 1),
    UNBREAKING(Enchantment.DURABILITY, 3),
    DEPTH_STRIDER(Enchantment.DEPTH_STRIDER, 3),
    PROTECTION(Enchantment.PROTECTION_ENVIRONMENTAL, 3),
    PROTECTION_EXPLOSION(Enchantment.PROTECTION_EXPLOSIONS, 3),
    PROTECTION_FIRE(Enchantment.PROTECTION_FIRE, 3),
    PROTECTION_FALL(Enchantment.PROTECTION_FALL, 3),
    PROTECTION_PROJECTILE(Enchantment.PROTECTION_PROJECTILE, 3),
    UNDERWATER_BREAKING(Enchantment.WATER_WORKER, 1),
    UNDERWATER_BREATHING(Enchantment.OXYGEN, 3),
    FORTUNE(Enchantment.LOOT_BONUS_BLOCKS, 1),
    LOOTING(Enchantment.LOOT_BONUS_MOBS, 1),
    LUCK(Enchantment.LUCK, 3),
    LURE(Enchantment.LURE, 3),

    THORNS(Enchantment.THORNS, 2);




    private Enchantment enchantment;
    private int maxLevel;

    private EnchantmentType(Enchantment enchantment, int maxLevel)
    {
        this.maxLevel = maxLevel;
        this.enchantment = enchantment;
    }

    public Enchantment getEnchantment()
    {
        return enchantment;
    }

    public int getMaxLevel()
    {
        return maxLevel;
    }
}

