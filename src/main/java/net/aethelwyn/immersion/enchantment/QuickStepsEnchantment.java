
package net.aethelwyn.immersion.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import net.aethelwyn.immersion.ImmersionModElements;

@ImmersionModElements.ModElement.Tag
public class QuickStepsEnchantment extends ImmersionModElements.ModElement {
	@ObjectHolder("immersion:quick_steps")
	public static final Enchantment enchantment = null;
	public QuickStepsEnchantment(ImmersionModElements instance) {
		super(instance, 596);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("quick_steps"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.UNCOMMON, EnchantmentType.ARMOR_FEET, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 3;
		}

		@Override
		protected boolean canApplyTogether(Enchantment ench) {
			if (ench == Enchantments.PROTECTION)
				return true;
			if (ench == Enchantments.FIRE_PROTECTION)
				return true;
			if (ench == Enchantments.FEATHER_FALLING)
				return true;
			if (ench == Enchantments.BLAST_PROTECTION)
				return true;
			if (ench == Enchantments.PROJECTILE_PROTECTION)
				return true;
			if (ench == Enchantments.FROST_WALKER)
				return true;
			if (ench == Enchantments.BINDING_CURSE)
				return true;
			if (ench == Enchantments.MENDING)
				return true;
			if (ench == Enchantments.VANISHING_CURSE)
				return true;
			if (ench == Enchantments.SOUL_SPEED)
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
