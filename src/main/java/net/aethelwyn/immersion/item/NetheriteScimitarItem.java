
package net.aethelwyn.immersion.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;

import net.aethelwyn.immersion.procedures.ScimitarFenceProcedure;
import net.aethelwyn.immersion.procedures.EnchantmentHandlerScimitarProcedure;
import net.aethelwyn.immersion.ImmersionModElements;

import java.util.Map;
import java.util.HashMap;

@ImmersionModElements.ModElement.Tag
public class NetheriteScimitarItem extends ImmersionModElements.ModElement {
	@ObjectHolder("immersion:netherite_scimitar")
	public static final Item block = null;
	public NetheriteScimitarItem(ImmersionModElements instance) {
		super(instance, 90);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2031;
			}

			public float getEfficiency() {
				return 2f;
			}

			public float getAttackDamage() {
				return 5f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 15;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.NETHERITE_INGOT, (int) (1)));
			}
		}, 3, -1.9f, new Item.Properties().group(ItemGroup.COMBAT).isImmuneToFire()) {
			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = retval.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("itemstack", itemstack);
					ScimitarFenceProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}

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
					$_dependencies.put("itemstack", itemstack);
					EnchantmentHandlerScimitarProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("netherite_scimitar"));
	}
}
