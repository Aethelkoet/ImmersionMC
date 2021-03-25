package net.aethelwyn.immersion.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.aethelwyn.immersion.enchantment.VenomousEnchantment;
import net.aethelwyn.immersion.ImmersionModElements;
import net.aethelwyn.immersion.ImmersionMod;

import java.util.Map;

@ImmersionModElements.ModElement.Tag
public class EnchantmentHandlerScimitarProcedure extends ImmersionModElements.ModElement {
	public EnchantmentHandlerScimitarProcedure(ImmersionModElements instance) {
		super(instance, 314);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ImmersionMod.LOGGER.warn("Failed to load dependency entity for procedure EnchantmentHandlerScimitar!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				ImmersionMod.LOGGER.warn("Failed to load dependency itemstack for procedure EnchantmentHandlerScimitar!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (((EnchantmentHelper.getEnchantmentLevel(VenomousEnchantment.enchantment, (itemstack))) == 1)) {
			if (((Math.random() < 0.3) && (!((entity instanceof TameableEntity) ? ((TameableEntity) entity).isTamed() : false)))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 80, (int) 1, (false), (false)));
			}
		} else if (((EnchantmentHelper.getEnchantmentLevel(VenomousEnchantment.enchantment, (itemstack))) == 2)) {
			if (((Math.random() < 0.3) && (!((entity instanceof TameableEntity) ? ((TameableEntity) entity).isTamed() : false)))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 80, (int) 2, (false), (false)));
			} else if (((Math.random() < 0.5) && (!((entity instanceof TameableEntity) ? ((TameableEntity) entity).isTamed() : false)))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 40, (int) 1, (false), (false)));
			}
		} else if (((EnchantmentHelper.getEnchantmentLevel(VenomousEnchantment.enchantment, (itemstack))) == 3)) {
			if (((Math.random() < 0.3) && (!((entity instanceof TameableEntity) ? ((TameableEntity) entity).isTamed() : false)))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 80, (int) 3, (false), (false)));
			} else if (((Math.random() < 0.6) && (!((entity instanceof TameableEntity) ? ((TameableEntity) entity).isTamed() : false)))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 40, (int) 2, (false), (false)));
			}
		}
	}
}
