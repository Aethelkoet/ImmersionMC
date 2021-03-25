package net.aethelwyn.immersion.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.server.MinecraftServer;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.block.Blocks;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.aethelwyn.immersion.enchantment.WitheredBiteEnchantment;
import net.aethelwyn.immersion.ImmersionModElements;
import net.aethelwyn.immersion.ImmersionMod;

import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;

@ImmersionModElements.ModElement.Tag
public class EnchantmentHandlerWitheredBiteProcedure extends ImmersionModElements.ModElement {
	public EnchantmentHandlerWitheredBiteProcedure(ImmersionModElements instance) {
		super(instance, 375);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ImmersionMod.LOGGER.warn("Failed to load dependency entity for procedure EnchantmentHandlerWitheredBite!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				ImmersionMod.LOGGER.warn("Failed to load dependency sourceentity for procedure EnchantmentHandlerWitheredBite!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ImmersionMod.LOGGER.warn("Failed to load dependency x for procedure EnchantmentHandlerWitheredBite!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ImmersionMod.LOGGER.warn("Failed to load dependency y for procedure EnchantmentHandlerWitheredBite!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ImmersionMod.LOGGER.warn("Failed to load dependency z for procedure EnchantmentHandlerWitheredBite!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ImmersionMod.LOGGER.warn("Failed to load dependency world for procedure EnchantmentHandlerWitheredBite!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((EnchantmentHelper.getEnchantmentLevel(WitheredBiteEnchantment.enchantment,
				((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))) == 1)) {
			if ((EntityTypeTags.getCollection()
					.getTagByID(new ResourceLocation(("immersion:overworld_skeletons").toLowerCase(java.util.Locale.ENGLISH)))
					.contains(entity.getType()))) {
				if ((Math.random() < 0.7)) {
					if (!entity.world.isRemote())
						entity.remove();
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new WitherSkeletonEntity(EntityType.WITHER_SKELETON, (World) world);
						entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
				}
			}
			if ((Math.random() < 0.1)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 60, (int) 3, (false), (false)));
			} else {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 45, (int) 1, (false), (false)));
			}
			if ((Math.random() < 0.3)) {
				if (((EnchantmentHelper.getEnchantmentLevel(Enchantments.LOOTING,
						((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))) == 3)) {
					if ((Math.random() < 0.085)) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Blocks.WITHER_ROSE, (int) (1)));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
						if (sourceentity instanceof ServerPlayerEntity) {
							Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) sourceentity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("immersion:advancement_harbinger_of_death"));
							AdvancementProgress _ap = ((ServerPlayerEntity) sourceentity).getAdvancements().getProgress(_adv);
							if (!_ap.isDone()) {
								Iterator _iterator = _ap.getRemaningCriteria().iterator();
								while (_iterator.hasNext()) {
									String _criterion = (String) _iterator.next();
									((ServerPlayerEntity) sourceentity).getAdvancements().grantCriterion(_adv, _criterion);
								}
							}
						}
					}
				} else if (((EnchantmentHelper.getEnchantmentLevel(Enchantments.LOOTING,
						((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))) == 2)) {
					if ((Math.random() < 0.05)) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Blocks.WITHER_ROSE, (int) (1)));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
						if (sourceentity instanceof ServerPlayerEntity) {
							Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) sourceentity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("immersion:advancement_harbinger_of_death"));
							AdvancementProgress _ap = ((ServerPlayerEntity) sourceentity).getAdvancements().getProgress(_adv);
							if (!_ap.isDone()) {
								Iterator _iterator = _ap.getRemaningCriteria().iterator();
								while (_iterator.hasNext()) {
									String _criterion = (String) _iterator.next();
									((ServerPlayerEntity) sourceentity).getAdvancements().grantCriterion(_adv, _criterion);
								}
							}
						}
					}
				} else if (((EnchantmentHelper.getEnchantmentLevel(Enchantments.LOOTING,
						((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))) == 1)) {
					if ((Math.random() < 0.035)) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Blocks.WITHER_ROSE, (int) (1)));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
						if (sourceentity instanceof ServerPlayerEntity) {
							Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) sourceentity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("immersion:advancement_harbinger_of_death"));
							AdvancementProgress _ap = ((ServerPlayerEntity) sourceentity).getAdvancements().getProgress(_adv);
							if (!_ap.isDone()) {
								Iterator _iterator = _ap.getRemaningCriteria().iterator();
								while (_iterator.hasNext()) {
									String _criterion = (String) _iterator.next();
									((ServerPlayerEntity) sourceentity).getAdvancements().grantCriterion(_adv, _criterion);
								}
							}
						}
					}
				} else {
					if ((Math.random() < 0.025)) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Blocks.WITHER_ROSE, (int) (1)));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
						if (sourceentity instanceof ServerPlayerEntity) {
							Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) sourceentity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("immersion:advancement_harbinger_of_death"));
							AdvancementProgress _ap = ((ServerPlayerEntity) sourceentity).getAdvancements().getProgress(_adv);
							if (!_ap.isDone()) {
								Iterator _iterator = _ap.getRemaningCriteria().iterator();
								while (_iterator.hasNext()) {
									String _criterion = (String) _iterator.next();
									((ServerPlayerEntity) sourceentity).getAdvancements().grantCriterion(_adv, _criterion);
								}
							}
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
