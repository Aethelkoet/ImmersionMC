
package net.aethelwyn.immersion.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.Blocks;

import net.aethelwyn.immersion.procedures.HookbladePassiveProcedure;
import net.aethelwyn.immersion.ImmersionModElements;

import java.util.Map;
import java.util.HashMap;

@ImmersionModElements.ModElement.Tag
public class WoodenHookbladeItem extends ImmersionModElements.ModElement {
	@ObjectHolder("immersion:wooden_hookblade")
	public static final Item block = null;
	public WoodenHookbladeItem(ImmersionModElements instance) {
		super(instance, 91);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 59;
			}

			public float getEfficiency() {
				return 2f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 15;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Blocks.OAK_PLANKS, (int) (1)), new ItemStack(Blocks.SPRUCE_PLANKS, (int) (1)),
						new ItemStack(Blocks.BIRCH_PLANKS, (int) (1)), new ItemStack(Blocks.JUNGLE_PLANKS, (int) (1)),
						new ItemStack(Blocks.ACACIA_PLANKS, (int) (1)), new ItemStack(Blocks.DARK_OAK_PLANKS, (int) (1)),
						new ItemStack(Blocks.CRIMSON_PLANKS, (int) (1)), new ItemStack(Blocks.WARPED_PLANKS, (int) (1)));
			}
		}, 3, -2.6f, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					HookbladePassiveProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("wooden_hookblade"));
	}
}