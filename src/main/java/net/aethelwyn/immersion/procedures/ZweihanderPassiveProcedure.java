package net.aethelwyn.immersion.procedures;

import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.aethelwyn.immersion.enchantment.AccustomedEnchantment;
import net.aethelwyn.immersion.ImmersionModElements;
import net.aethelwyn.immersion.ImmersionMod;

import java.util.Map;

@ImmersionModElements.ModElement.Tag
public class ZweihanderPassiveProcedure extends ImmersionModElements.ModElement {
	public ZweihanderPassiveProcedure(ImmersionModElements instance) {
		super(instance, 534);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ImmersionMod.LOGGER.warn("Failed to load dependency entity for procedure ZweihanderPassive!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((!((EnchantmentHelper.getEnchantmentLevel(AccustomedEnchantment.enchantment,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) == 1))) {
			if ((!(((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.SHIELD, (int) (1)).getItem())
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == new ItemStack(Items.TOTEM_OF_UNDYING, (int) (1)).getItem()))
					|| (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)).getCount()) == 0)))) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(
							new StringTextComponent((new TranslationTextComponent("msg.zweihander.held.fail").getString())), (true));
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, (int) 20, (int) 1, (false), (false)));
			}
		}
	}
}
