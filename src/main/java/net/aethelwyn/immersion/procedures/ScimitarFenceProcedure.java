package net.aethelwyn.immersion.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.aethelwyn.immersion.enchantment.QuickStepsEnchantment;
import net.aethelwyn.immersion.ImmersionModElements;
import net.aethelwyn.immersion.ImmersionMod;

import java.util.Map;

@ImmersionModElements.ModElement.Tag
public class ScimitarFenceProcedure extends ImmersionModElements.ModElement {
	public ScimitarFenceProcedure(ImmersionModElements instance) {
		super(instance, 590);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ImmersionMod.LOGGER.warn("Failed to load dependency entity for procedure ScimitarFence!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				ImmersionMod.LOGGER.warn("Failed to load dependency itemstack for procedure ScimitarFence!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (((EnchantmentHelper.getEnchantmentLevel(QuickStepsEnchantment.enchantment,
				((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
						: ItemStack.EMPTY))) == 1)) {
			entity.setMotion(((entity.getMotion().getX()) * 2.75), ((entity.getMotion().getY()) * 2.75), ((entity.getMotion().getZ()) * 2.75));
		} else if (((EnchantmentHelper.getEnchantmentLevel(QuickStepsEnchantment.enchantment,
				((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
						: ItemStack.EMPTY))) == 2)) {
			entity.setMotion(((entity.getMotion().getX()) * 3.5), ((entity.getMotion().getY()) * 3.5), ((entity.getMotion().getZ()) * 3.5));
		} else if (((EnchantmentHelper.getEnchantmentLevel(QuickStepsEnchantment.enchantment,
				((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
						: ItemStack.EMPTY))) == 3)) {
			entity.setMotion(((entity.getMotion().getX()) * 4.25), ((entity.getMotion().getY()) * 4.25), ((entity.getMotion().getZ()) * 4.25));
		} else {
			entity.setMotion(((entity.getMotion().getX()) * 2), ((entity.getMotion().getY()) * 2), ((entity.getMotion().getZ()) * 2));
		}
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).getCooldownTracker().setCooldown(((itemstack)).getItem(), (int) 60);
	}
}
