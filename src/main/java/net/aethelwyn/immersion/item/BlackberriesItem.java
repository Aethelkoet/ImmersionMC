
package net.aethelwyn.immersion.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.aethelwyn.immersion.ImmersionModElements;

@ImmersionModElements.ModElement.Tag
public class BlackberriesItem extends ImmersionModElements.ModElement {
	@ObjectHolder("immersion:blackberries")
	public static final Item block = null;
	public BlackberriesItem(ImmersionModElements instance) {
		super(instance, 490);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(1).saturation(0.5f).build()));
			setRegistryName("blackberries");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
