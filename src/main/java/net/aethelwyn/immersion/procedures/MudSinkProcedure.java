package net.aethelwyn.immersion.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;

import net.aethelwyn.immersion.ImmersionModElements;
import net.aethelwyn.immersion.ImmersionMod;

import java.util.Map;
import java.util.Collection;

@ImmersionModElements.ModElement.Tag
public class MudSinkProcedure extends ImmersionModElements.ModElement {
	public MudSinkProcedure(ImmersionModElements instance) {
		super(instance, 425);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ImmersionMod.LOGGER.warn("Failed to load dependency entity for procedure MudSink!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ImmersionMod.LOGGER.warn("Failed to load dependency world for procedure MudSink!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 10, (int) 3, (true), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 10, (int) 3, (true), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, (int) 10, (int) 1, (true), (false)));
		entity.setMotion((entity.getMotion().getX()), ((entity.getMotion().getY()) / 3), (entity.getMotion().getZ()));
		if ((!(entity instanceof LivingEntity ? (((LivingEntity) entity).getCreatureAttribute() == CreatureAttribute.UNDEAD) : false))) {
			if (((new Object() {
				boolean check(Entity _entity) {
					if (_entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == Effects.SLOWNESS)
								return true;
						}
					}
					return false;
				}
			}.check(entity)) || (new Object() {
				boolean check(Entity _entity) {
					if (_entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == Effects.MINING_FATIGUE)
								return true;
						}
					}
					return false;
				}
			}.check(entity)))) {
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private IWorld world;
					public void start(IWorld world, int waitTicks) {
						this.waitTicks = waitTicks;
						MinecraftForge.EVENT_BUS.register(this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						while (((new Object() {
							boolean check(Entity _entity) {
								if (_entity instanceof LivingEntity) {
									Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
									for (EffectInstance effect : effects) {
										if (effect.getPotion() == Effects.SLOWNESS)
											return true;
									}
								}
								return false;
							}
						}.check(entity)) || (new Object() {
							boolean check(Entity _entity) {
								if (_entity instanceof LivingEntity) {
									Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
									for (EffectInstance effect : effects) {
										if (effect.getPotion() == Effects.MINING_FATIGUE)
											return true;
									}
								}
								return false;
							}
						}.check(entity)))) {
							new Object() {
								private int ticks = 0;
								private float waitTicks;
								private IWorld world;
								public void start(IWorld world, int waitTicks) {
									this.waitTicks = waitTicks;
									MinecraftForge.EVENT_BUS.register(this);
									this.world = world;
								}

								@SubscribeEvent
								public void tick(TickEvent.ServerTickEvent event) {
									if (event.phase == TickEvent.Phase.END) {
										this.ticks += 1;
										if (this.ticks >= this.waitTicks)
											run();
									}
								}

								private void run() {
									if (entity instanceof LivingEntity) {
										((LivingEntity) entity).attackEntityFrom(new DamageSource("mud").setDamageBypassesArmor(), (float) 1);
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 20);
							continue;
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 200);
			}
		}
	}
}
