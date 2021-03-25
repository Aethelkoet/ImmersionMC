package net.aethelwyn.immersion.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.aethelwyn.immersion.enchantment.DisarmEnchantment;
import net.aethelwyn.immersion.ImmersionModElements;
import net.aethelwyn.immersion.ImmersionMod;

import java.util.Map;

@ImmersionModElements.ModElement.Tag
public class HookbladePassiveProcedure extends ImmersionModElements.ModElement {
	public HookbladePassiveProcedure(ImmersionModElements instance) {
		super(instance, 389);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ImmersionMod.LOGGER.warn("Failed to load dependency entity for procedure HookbladePassive!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ImmersionMod.LOGGER.warn("Failed to load dependency x for procedure HookbladePassive!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ImmersionMod.LOGGER.warn("Failed to load dependency y for procedure HookbladePassive!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ImmersionMod.LOGGER.warn("Failed to load dependency z for procedure HookbladePassive!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ImmersionMod.LOGGER.warn("Failed to load dependency world for procedure HookbladePassive!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((EnchantmentHelper.getEnchantmentLevel(DisarmEnchantment.enchantment,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) == 3)) {
			if ((Math.random() < 0.035)) {
				if ((((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)).getCount()) != 0)) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).copy()));
						entityToSpawn.setPickupDelay((int) 100);
						world.addEntity(entityToSpawn);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.OFF_HAND, true);
					}
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY);
						((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) entity).container.func_234641_j_());
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your offhand has been disarmed for 5 seconds"), (true));
					}
				}
			} else if ((Math.random() < 0.05)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
							(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).copy()));
					entityToSpawn.setPickupDelay((int) 60);
					world.addEntity(entityToSpawn);
				}
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your mainhand has been disarmed for 3 seconds"), (true));
				}
			}
		} else if (((EnchantmentHelper.getEnchantmentLevel(DisarmEnchantment.enchantment,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) == 2)) {
			if ((Math.random() < 0.02)) {
				if ((((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)).getCount()) != 0)) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).copy()));
						entityToSpawn.setPickupDelay((int) 80);
						world.addEntity(entityToSpawn);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.OFF_HAND, true);
					}
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY);
						((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) entity).container.func_234641_j_());
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your offhand has been disarmed for 4 seconds"), (true));
					}
				}
			} else if ((Math.random() < 0.03)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
							(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).copy()));
					entityToSpawn.setPickupDelay((int) 40);
					world.addEntity(entityToSpawn);
				}
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your mainhand has been disarmed for 2 seconds"), (true));
				}
			}
		} else if (((EnchantmentHelper.getEnchantmentLevel(DisarmEnchantment.enchantment,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) == 1)) {
			if ((Math.random() < 0.01)) {
				if ((((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)).getCount()) != 0)) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).copy()));
						entityToSpawn.setPickupDelay((int) 40);
						world.addEntity(entityToSpawn);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.OFF_HAND, true);
					}
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY);
						((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) entity).container.func_234641_j_());
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your offhand has been disarmed for 2 seconds"), (true));
					}
				}
			}
		} else {
			if ((Math.random() < 0.005)) {
				if ((((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)).getCount()) != 0)) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).copy()));
						entityToSpawn.setPickupDelay((int) 20);
						world.addEntity(entityToSpawn);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.OFF_HAND, true);
					}
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY);
						((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) entity).container.func_234641_j_());
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your offhand has been disarmed for 1 second"), (true));
					}
				}
			}
		}
	}
}
