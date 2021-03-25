package net.aethelwyn.immersion.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.aethelwyn.immersion.item.WoodenLancerItem;
import net.aethelwyn.immersion.item.StoneLancerItem;
import net.aethelwyn.immersion.item.NetheriteLancerItem;
import net.aethelwyn.immersion.item.IronLancerItem;
import net.aethelwyn.immersion.item.GoldenLancerItem;
import net.aethelwyn.immersion.item.DiamondLancerItem;
import net.aethelwyn.immersion.ImmersionModElements;
import net.aethelwyn.immersion.ImmersionMod;

import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;

@ImmersionModElements.ModElement.Tag
public class PROCAdvancementLancerProcedure extends ImmersionModElements.ModElement {
	public PROCAdvancementLancerProcedure(ImmersionModElements instance) {
		super(instance, 544);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ImmersionMod.LOGGER.warn("Failed to load dependency entity for procedure PROCAdvancementLancer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(WoodenLancerItem.block, (int) (1)))
				: false)
				|| ((entity instanceof PlayerEntity)
						? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(StoneLancerItem.block, (int) (1)))
						: false))
				|| ((((entity instanceof PlayerEntity)
						? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(GoldenLancerItem.block, (int) (1)))
						: false)
						|| ((entity instanceof PlayerEntity)
								? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(IronLancerItem.block, (int) (1)))
								: false))
						|| (((entity instanceof PlayerEntity)
								? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(DiamondLancerItem.block, (int) (1)))
								: false)
								|| ((entity instanceof PlayerEntity)
										? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(NetheriteLancerItem.block, (int) (1)))
										: false))))) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("immersion:advancement_strike_first_think_later"));
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
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}