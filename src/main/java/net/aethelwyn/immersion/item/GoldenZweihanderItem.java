
package net.aethelwyn.immersion.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.Entity;

import net.aethelwyn.immersion.procedures.ZweihanderPassiveProcedure;
import net.aethelwyn.immersion.ImmersionModElements;

import java.util.Map;
import java.util.HashMap;

@ImmersionModElements.ModElement.Tag
public class GoldenZweihanderItem extends ImmersionModElements.ModElement {
	@ObjectHolder("immersion:golden_zweihander")
	public static final Item block = null;
	public GoldenZweihanderItem(ImmersionModElements instance) {
		super(instance, 524);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 32;
			}

			public float getEfficiency() {
				return 2f;
			}

			public float getAttackDamage() {
				return 8f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 22;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.GOLD_INGOT, (int) (1)));
			}
		}, 3, -3.4f, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
				super.inventoryTick(itemstack, world, entity, slot, selected);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				if (selected) {
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ZweihanderPassiveProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("golden_zweihander"));
	}
}
