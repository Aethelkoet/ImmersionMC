
package net.aethelwyn.immersion.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import net.aethelwyn.immersion.item.WoodenLancerItem;
import net.aethelwyn.immersion.item.StoneLancerItem;
import net.aethelwyn.immersion.item.NetheriteLancerItem;
import net.aethelwyn.immersion.item.IronLancerItem;
import net.aethelwyn.immersion.item.GoldenLancerItem;
import net.aethelwyn.immersion.item.DiamondLancerItem;
import net.aethelwyn.immersion.ImmersionModElements;

@ImmersionModElements.ModElement.Tag
public class ChargeEnchantment extends ImmersionModElements.ModElement {
	@ObjectHolder("immersion:charge")
	public static final Enchantment enchantment = null;
	public ChargeEnchantment(ImmersionModElements instance) {
		super(instance, 472);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("charge"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.RARE, EnchantmentType.WEAPON, slots);
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
		public boolean canApplyAtEnchantingTable(ItemStack stack) {
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
