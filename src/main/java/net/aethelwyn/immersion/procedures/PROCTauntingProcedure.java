package net.aethelwyn.immersion.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.aethelwyn.immersion.world.TauntingEnabledGameRule;
import net.aethelwyn.immersion.enchantment.CurseOfTauntingEnchantment;
import net.aethelwyn.immersion.ImmersionModElements;
import net.aethelwyn.immersion.ImmersionMod;

import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;

@ImmersionModElements.ModElement.Tag
public class PROCTauntingProcedure extends ImmersionModElements.ModElement {
	public PROCTauntingProcedure(ImmersionModElements instance) {
		super(instance, 594);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				ImmersionMod.LOGGER.warn("Failed to load dependency sourceentity for procedure PROCTaunting!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ImmersionMod.LOGGER.warn("Failed to load dependency world for procedure PROCTaunting!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		IWorld world = (IWorld) dependencies.get("world");
		if (((EnchantmentHelper.getEnchantmentLevel(CurseOfTauntingEnchantment.enchantment,
				((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0))) {
			if (((world.getWorldInfo().getGameRulesInstance().getBoolean(TauntingEnabledGameRule.gamerule)) == (true))) {
				if ((Math.random() < 0.3)) {
					if ((Math.random() < 0.001)) {
						if (sourceentity instanceof ServerPlayerEntity) {
							Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) sourceentity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("immersion:advancement_big_woop"));
							AdvancementProgress _ap = ((ServerPlayerEntity) sourceentity).getAdvancements().getProgress(_adv);
							if (!_ap.isDone()) {
								Iterator _iterator = _ap.getRemaningCriteria().iterator();
								while (_iterator.hasNext()) {
									String _criterion = (String) _iterator.next();
									((ServerPlayerEntity) sourceentity).getAdvancements().grantCriterion(_adv, _criterion);
								}
							}
						}
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((new TranslationTextComponent("taunting.insult.rare").getString())), (false));
						}
					} else if ((Math.random() < 0.06)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((new TranslationTextComponent("taunting.insult.1").getString())), (false));
						}
					} else if ((Math.random() < 0.1)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((new TranslationTextComponent("taunting.insult.2").getString())), (false));
						}
					} else if ((Math.random() < 0.17)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((new TranslationTextComponent("taunting.insult.3").getString())), (false));
						}
					} else if ((Math.random() < 0.2)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((new TranslationTextComponent("taunting.insult.4").getString())), (false));
						}
					} else if ((Math.random() < 0.23)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((new TranslationTextComponent("taunting.insult.5").getString())), (false));
						}
					} else if ((Math.random() < 0.27)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((new TranslationTextComponent("taunting.insult.6").getString())), (false));
						}
					} else if ((Math.random() < 0.3)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((new TranslationTextComponent("taunting.insult.7").getString())), (false));
						}
					} else if ((Math.random() < 0.31)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((new TranslationTextComponent("taunting.insult.8").getString())), (false));
						}
					} else if ((Math.random() < 0.35)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((new TranslationTextComponent("taunting.insult.9").getString())), (false));
						}
					} else if ((Math.random() < 0.38)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((new TranslationTextComponent("taunting.insult.10").getString())), (false));
						}
					} else if ((Math.random() < 0.4)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((new TranslationTextComponent("taunting.insult.11").getString())), (false));
						}
					} else if ((Math.random() < 0.42)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((new TranslationTextComponent("taunting.insult.12").getString())), (false));
						}
					} else if ((Math.random() < 0.45)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((new TranslationTextComponent("taunting.insult.13").getString())), (false));
						}
					} else if ((Math.random() < 0.49)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((new TranslationTextComponent("taunting.insult.14").getString())), (false));
						}
					} else if ((Math.random() < 0.53)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((new TranslationTextComponent("taunting.insult.15").getString())), (false));
						}
					} else if ((Math.random() < 0.57)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((new TranslationTextComponent("taunting.insult.16").getString())), (false));
						}
					} else if ((Math.random() < 0.58)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((new TranslationTextComponent("taunting.insult.17").getString())), (false));
						}
					} else if ((Math.random() < 0.6)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((new TranslationTextComponent("taunting.insult.18").getString())), (false));
						}
					} else if ((Math.random() < 0.64)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((new TranslationTextComponent("taunting.insult.19").getString())), (false));
						}
					} else if ((Math.random() < 0.7)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((new TranslationTextComponent("taunting.insult.20").getString())), (false));
						}
					} else if ((Math.random() < 0.73)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((new TranslationTextComponent("taunting.insult.21").getString())), (false));
						}
					} else if ((Math.random() < 0.76)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((new TranslationTextComponent("taunting.insult.22").getString())), (false));
						}
					} else if ((Math.random() < 0.8)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((new TranslationTextComponent("taunting.insult.23").getString())), (false));
						}
					} else if ((Math.random() < 0.84)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((new TranslationTextComponent("taunting.insult.24").getString())), (false));
						}
					} else if ((Math.random() < 0.9)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((new TranslationTextComponent("taunting.insult.25").getString())), (false));
						}
					} else if ((Math.random() < 0.94)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((new TranslationTextComponent("taunting.insult.26").getString())), (false));
						}
					} else if ((Math.random() < 1)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((new TranslationTextComponent("taunting.insult.27").getString())), (false));
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			Entity sourceentity = event.getSource().getTrueSource();
			Entity imediatesourceentity = event.getSource().getImmediateSource();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			double amount = event.getAmount();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("amount", amount);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("imediatesourceentity", imediatesourceentity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
