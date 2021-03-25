package net.aethelwyn.immersion.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.aethelwyn.immersion.ImmersionModElements;
import net.aethelwyn.immersion.ImmersionMod;

import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;

@ImmersionModElements.ModElement.Tag
public class PROCAdvancementHomeBrewedAttitudeProcedure extends ImmersionModElements.ModElement {
	public PROCAdvancementHomeBrewedAttitudeProcedure(ImmersionModElements instance) {
		super(instance, 367);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ImmersionMod.LOGGER.warn("Failed to load dependency entity for procedure PROCAdvancementHomeBrewedAttitude!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("immersion:logic_beetroot_juice")))
						.isDone()
				: false)
				&& (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
						? ((ServerPlayerEntity) entity).getAdvancements()
								.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
										.getAdvancement(new ResourceLocation("immersion:logic_carrot_juice")))
								.isDone()
						: false))
				&& ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
						? ((ServerPlayerEntity) entity).getAdvancements()
								.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
										.getAdvancement(new ResourceLocation("immersion:logic_apple_juice")))
								.isDone()
						: false)
						&& (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
								? ((ServerPlayerEntity) entity).getAdvancements()
										.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
												.getAdvancement(new ResourceLocation("immersion:logic_cactus_wine")))
										.isDone()
								: false)))
				&& (((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
						? ((ServerPlayerEntity) entity).getAdvancements()
								.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
										.getAdvancement(new ResourceLocation("immersion:logic_blackcurrant_juice")))
								.isDone()
						: false)
						&& (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
								? ((ServerPlayerEntity) entity).getAdvancements()
										.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
												.getAdvancement(new ResourceLocation("immersion:logic_strawberry_juice")))
										.isDone()
								: false))
						&& (((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
								? ((ServerPlayerEntity) entity).getAdvancements()
										.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
												.getAdvancement(new ResourceLocation("immersion:logic_blackberry_juice")))
										.isDone()
								: false)
								&& (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
										? ((ServerPlayerEntity) entity).getAdvancements()
												.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
														.getAdvancement(new ResourceLocation("immersion:logic_berry_wine")))
												.isDone()
										: false))
								&& ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
										? ((ServerPlayerEntity) entity).getAdvancements()
												.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
														.getAdvancement(new ResourceLocation("immersion:logic_grape_wine")))
												.isDone()
										: false)
										&& (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
												? ((ServerPlayerEntity) entity).getAdvancements()
														.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
																.getAdvancement(new ResourceLocation("immersion:logic_chorus_wine")))
														.isDone()
												: false)))))) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("immersion:advancement_home_brewed_attitude"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onAdvancement(AdvancementEvent event) {
		PlayerEntity entity = event.getPlayer();
		double i = entity.getPosX();
		double j = entity.getPosY();
		double k = entity.getPosZ();
		Advancement advancement = event.getAdvancement();
		World world = entity.world;
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("advancement", advancement);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
