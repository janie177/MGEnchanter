package com.minegusta.mgenchanter.enchantments;

import com.google.common.collect.Lists;
import org.bukkit.Material;

import java.util.List;

public enum ItemType
{
    WEAPON(2, 4, new EnchantmentType[]{EnchantmentType.LOOTING, EnchantmentType.UNBREAKING, EnchantmentType.SHARPNESS, EnchantmentType.BANE_OF_THE_ARTHROPODS, EnchantmentType.SMITE, EnchantmentType.FIRE_ASPECT, EnchantmentType.KNOCKBACK}, Lists.newArrayList(Material.GOLD_SWORD, Material.IRON_SWORD, Material.WOOD_SWORD, Material.STONE_SWORD,Material.DIAMOND_SWORD, Material.IRON_AXE, Material.WOOD_AXE, Material.DIAMOND_AXE, Material.GOLD_AXE, Material.STONE_AXE)),
    BOW(2, 4, new EnchantmentType[]{EnchantmentType.UNBREAKING, EnchantmentType.INFINITY, EnchantmentType.PUNCH, EnchantmentType.POWER, EnchantmentType.FLAME}, Lists.newArrayList(Material.BOW)),
    FISHING_ROD(1,3, new EnchantmentType[]{EnchantmentType.LUCK, EnchantmentType.LURE, EnchantmentType.UNBREAKING}, Lists.newArrayList(Material.FISHING_ROD)),
    TOOLS(2,4, new EnchantmentType[]{EnchantmentType.UNBREAKING, EnchantmentType.EFFICIENCY, EnchantmentType.SILK_TOUCH, EnchantmentType.FORTUNE, }, Lists.newArrayList(Material.WOOD_SPADE, Material.STONE_SPADE, Material.IRON_SPADE, Material.DIAMOND_SPADE, Material.GOLD_SPADE, Material.WOOD_HOE, Material.STONE_HOE, Material.GOLD_HOE, Material.IRON_HOE, Material.DIAMOND_HOE, Material.DIAMOND_PICKAXE, Material.IRON_PICKAXE, Material.STONE_PICKAXE, Material.WOOD_PICKAXE, Material.GOLD_PICKAXE, Material.SHEARS)),
    HELMET(2, 4, new EnchantmentType[]{EnchantmentType.UNBREAKING, EnchantmentType.PROTECTION, EnchantmentType.PROTECTION_EXPLOSION, EnchantmentType.PROTECTION_FIRE, EnchantmentType.PROTECTION_PROJECTILE, EnchantmentType.UNDERWATER_BREAKING, EnchantmentType.UNDERWATER_BREATHING}, Lists.newArrayList(Material.LEATHER_HELMET, Material.GOLD_HELMET, Material.IRON_HELMET, Material.CHAINMAIL_HELMET, Material.DIAMOND_HELMET)),
    BOOTS(2, 4, new EnchantmentType[]{EnchantmentType.UNBREAKING, EnchantmentType.PROTECTION, EnchantmentType.PROTECTION_EXPLOSION, EnchantmentType.PROTECTION_FALL, EnchantmentType.PROTECTION_FIRE, EnchantmentType.PROTECTION_PROJECTILE, EnchantmentType.DEPTH_STRIDER}, Lists.newArrayList(Material.LEATHER_BOOTS, Material.IRON_BOOTS, Material.GOLD_BOOTS, Material.CHAINMAIL_BOOTS, Material.DIAMOND_BOOTS)),
    ARMOUR(2,4, new EnchantmentType[]{EnchantmentType.UNBREAKING, EnchantmentType.PROTECTION, EnchantmentType.PROTECTION_EXPLOSION, EnchantmentType.PROTECTION_FIRE, EnchantmentType.PROTECTION_PROJECTILE, EnchantmentType.THORNS}, Lists.newArrayList(Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_LEGGINGS, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.GOLD_CHESTPLATE, Material.GOLD_LEGGINGS)),
    UNENCHANTABLE(0, 0, null, null);

    private EnchantmentType[] enchantmentTypes;
    private int maxAmount;
    private int totalMaxAmount;
    private List<Material> materials;

    private ItemType(int maxAmount, int totalMaxAmount, EnchantmentType[] enchantmentTypes, List<Material> materials)
    {
        this.maxAmount = maxAmount;
        this.totalMaxAmount = totalMaxAmount;
        this.enchantmentTypes = enchantmentTypes;
        this.materials = materials;
    }

    public int getMaxAmount()
    {
        return maxAmount;
    }

    public int getTotalMaxAmount()
    {
        return totalMaxAmount;
    }

    public EnchantmentType[] getEnchantmentTypes()
    {
        return enchantmentTypes;
    }

    public List<Material> getMaterials()
    {
        return materials;
    }

    public static ItemType getItemType(Material m)
    {
        for(ItemType type : ItemType.values())
        {
            if(type.getMaterials().contains(m))
            {
                return type;
            }
        }
        return UNENCHANTABLE;
    }



}
