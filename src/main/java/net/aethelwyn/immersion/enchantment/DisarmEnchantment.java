
package net.aethelwyn.immersion.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import net.aethelwyn.immersion.item.WoodenHookbladeItem;
import net.aethelwyn.immersion.item.StoneHookbladeItem;
import net.aethelwyn.immersion.item.NetheriteHookbladeItem;
import net.aethelwyn.immersion.item.IronHookbladeItem;
import net.aethelwyn.immersion.item.GoldenHookbladeItem;
import net.aethelwyn.immersion.item.DiamondHookbladeItem;
import net.aethelwyn.immersion.ImmersionModElements;

@ImmersionModElements.ModElement.Tag
public class DisarmEnchantment extends ImmersionModElements.ModElement {
	@ObjectHolder("immersion:disarm")
	public static final Enchantment enchantment = null;
	public DisarmEnchantment(ImmersionModElements instance) {
		super(instance, 388);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("disarm"));
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
			return 3;
		}

		@Override
		public boolean canApplyAtEnchantingTable(ItemStack stack) {
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
