
package net.aethelwyn.immersion.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import net.aethelwyn.immersion.item.WoodenZweihanderItem;
import net.aethelwyn.immersion.item.WoodenScimitarItem;
import net.aethelwyn.immersion.item.WoodenLancerItem;
import net.aethelwyn.immersion.item.WoodenHookbladeItem;
import net.aethelwyn.immersion.item.StoneZweihanderItem;
import net.aethelwyn.immersion.item.StoneScimitarItem;
import net.aethelwyn.immersion.item.StoneLancerItem;
import net.aethelwyn.immersion.item.StoneHookbladeItem;
import net.aethelwyn.immersion.item.NetheriteZweihanderItem;
import net.aethelwyn.immersion.item.NetheriteScimitarItem;
import net.aethelwyn.immersion.item.NetheriteLancerItem;
import net.aethelwyn.immersion.item.NetheriteHookbladeItem;
import net.aethelwyn.immersion.item.IronZweihanderItem;
import net.aethelwyn.immersion.item.IronScimitarItem;
import net.aethelwyn.immersion.item.IronLancerItem;
import net.aethelwyn.immersion.item.IronHookbladeItem;
import net.aethelwyn.immersion.item.GoldenZweihanderItem;
import net.aethelwyn.immersion.item.GoldenScimitarItem;
import net.aethelwyn.immersion.item.GoldenLancerItem;
import net.aethelwyn.immersion.item.GoldenHookbladeItem;
import net.aethelwyn.immersion.item.DiamondZweihanderItem;
import net.aethelwyn.immersion.item.DiamondScimitarItem;
import net.aethelwyn.immersion.item.DiamondLancerItem;
import net.aethelwyn.immersion.item.DiamondHookbladeItem;
import net.aethelwyn.immersion.ImmersionModElements;

@ImmersionModElements.ModElement.Tag
public class HeresyEnchantment extends ImmersionModElements.ModElement {
	@ObjectHolder("immersion:heresy")
	public static final Enchantment enchantment = null;
	public HeresyEnchantment(ImmersionModElements instance) {
		super(instance, 540);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("heresy"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.UNCOMMON, EnchantmentType.WEAPON, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 5;
		}

		@Override
		protected boolean canApplyTogether(Enchantment ench) {
			if (ench == VenomousEnchantment.enchantment)
				return true;
			if (ench == StunningEnchantment.enchantment)
				return true;
			if (ench == WitheredBiteEnchantment.enchantment)
				return true;
			if (ench == CurseOfWarpingEnchantment.enchantment)
				return true;
			if (ench == DisarmEnchantment.enchantment)
				return true;
			if (ench == ChargeEnchantment.enchantment)
				return true;
			if (ench == AccustomedEnchantment.enchantment)
				return true;
			if (ench == Enchantments.KNOCKBACK)
				return true;
			if (ench == Enchantments.FIRE_ASPECT)
				return true;
			if (ench == Enchantments.LOOTING)
				return true;
			if (ench == Enchantments.SWEEPING)
				return true;
			if (ench == Enchantments.EFFICIENCY)
				return true;
			if (ench == Enchantments.LOYALTY)
				return true;
			if (ench == Enchantments.IMPALING)
				return true;
			if (ench == Enchantments.RIPTIDE)
				return true;
			if (ench == Enchantments.CHANNELING)
				return true;
			if (ench == Enchantments.MENDING)
				return true;
			if (ench == Enchantments.VANISHING_CURSE)
				return true;
			return false;
		}

		@Override
		public boolean canApplyAtEnchantingTable(ItemStack stack) {
			if (stack.getItem() == new ItemStack(WoodenScimitarItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(StoneScimitarItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(GoldenScimitarItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(IronScimitarItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(DiamondScimitarItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(NetheriteScimitarItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(WoodenHookbladeItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(StoneHookbladeItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(GoldenHookbladeItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(IronHookbladeItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(DiamondHookbladeItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(NetheriteHookbladeItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(WoodenLancerItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(StoneLancerItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(GoldenLancerItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(IronLancerItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(DiamondLancerItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(NetheriteLancerItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(WoodenZweihanderItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(StoneZweihanderItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(GoldenZweihanderItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(IronZweihanderItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(DiamondZweihanderItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(NetheriteZweihanderItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.WOODEN_AXE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.STONE_AXE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.IRON_AXE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.GOLDEN_AXE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.DIAMOND_AXE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.NETHERITE_AXE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.WOODEN_SWORD, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.STONE_SWORD, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.IRON_SWORD, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.GOLDEN_SWORD, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.DIAMOND_SWORD, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.NETHERITE_SWORD, (int) (1)).getItem())
				return true;
			return false;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return false;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}
	}
}
