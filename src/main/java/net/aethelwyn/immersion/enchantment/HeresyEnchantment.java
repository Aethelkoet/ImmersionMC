
package net.aethelwyn.immersion.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

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
		public boolean isTreasureEnchantment() {
			return true;
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
