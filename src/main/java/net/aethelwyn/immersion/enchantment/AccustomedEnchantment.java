
package net.aethelwyn.immersion.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import net.aethelwyn.immersion.item.WoodenZweihanderItem;
import net.aethelwyn.immersion.item.StoneZweihanderItem;
import net.aethelwyn.immersion.item.NetheriteZweihanderItem;
import net.aethelwyn.immersion.item.IronZweihanderItem;
import net.aethelwyn.immersion.item.GoldenZweihanderItem;
import net.aethelwyn.immersion.item.DiamondZweihanderItem;
import net.aethelwyn.immersion.ImmersionModElements;

@ImmersionModElements.ModElement.Tag
public class AccustomedEnchantment extends ImmersionModElements.ModElement {
	@ObjectHolder("immersion:accustomed")
	public static final Enchantment enchantment = null;
	public AccustomedEnchantment(ImmersionModElements instance) {
		super(instance, 539);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("accustomed"));
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
			return 1;
		}

		@Override
		public boolean canApplyAtEnchantingTable(ItemStack stack) {
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
