
package net.aethelwyn.immersion.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.aethelwyn.immersion.procedures.ZweihanderPassiveProcedure;
import net.aethelwyn.immersion.ImmersionModElements;

import java.util.Map;
import java.util.HashMap;

@ImmersionModElements.ModElement.Tag
public class StoneZweihanderItem extends ImmersionModElements.ModElement {
	@ObjectHolder("immersion:stone_zweihander")
	public static final Item block = null;
	public StoneZweihanderItem(ImmersionModElements instance) {
		super(instance, 523);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 131;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 9f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 15;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Blocks.GRANITE, (int) (1)), new ItemStack(Blocks.DIORITE, (int) (1)),
						new ItemStack(Blocks.ANDESITE, (int) (1)), new ItemStack(Blocks.COBBLESTONE, (int) (1)),
						new ItemStack(Blocks.BLACKSTONE, (int) (1)));
			}
		}, 3, -3.3f, new Item.Properties().group(ItemGroup.COMBAT)) {
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
		}.setRegistryName("stone_zweihander"));
	}
}
