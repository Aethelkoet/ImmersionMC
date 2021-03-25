package net.aethelwyn.immersion.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.aethelwyn.immersion.item.AugerGemItem;
import net.aethelwyn.immersion.block.TorisciteBricksBlock;
import net.aethelwyn.immersion.block.TorisciteBrickWallBlock;
import net.aethelwyn.immersion.block.TorisciteBrickStairsBlock;
import net.aethelwyn.immersion.block.PolishedTorisciteBlock;
import net.aethelwyn.immersion.block.OrnateTorisciteBricksBlock;
import net.aethelwyn.immersion.block.GemGildedOrnateTorisciteBricksBlock;
import net.aethelwyn.immersion.block.CorinthPortalBlock;
import net.aethelwyn.immersion.block.CobbledTorisciteWallBlock;
import net.aethelwyn.immersion.block.ChiselledTorisciteBricksBlock;
import net.aethelwyn.immersion.ImmersionModElements;
import net.aethelwyn.immersion.ImmersionMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Comparator;

@ImmersionModElements.ModElement.Tag
public class PROCPortalStructureProcedure extends ImmersionModElements.ModElement {
	public PROCPortalStructureProcedure(ImmersionModElements instance) {
		super(instance, 557);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ImmersionMod.LOGGER.warn("Failed to load dependency entity for procedure PROCPortalStructure!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ImmersionMod.LOGGER.warn("Failed to load dependency x for procedure PROCPortalStructure!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ImmersionMod.LOGGER.warn("Failed to load dependency y for procedure PROCPortalStructure!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ImmersionMod.LOGGER.warn("Failed to load dependency z for procedure PROCPortalStructure!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ImmersionMod.LOGGER.warn("Failed to load dependency world for procedure PROCPortalStructure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((((((((world.getBlockState(new BlockPos((int) (x - 2), (int) (y - 4), (int) (z + 1)))).getBlock() == PolishedTorisciteBlock.block
				.getDefaultState().getBlock())
				&& ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 4), (int) (z + 2)))).getBlock() == PolishedTorisciteBlock.block
						.getDefaultState().getBlock()))
				&& (((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 4), (int) (z - 2)))).getBlock() == PolishedTorisciteBlock.block
						.getDefaultState().getBlock())
						&& ((world.getBlockState(new BlockPos((int) (x + 2), (int) (y - 4), (int) (z - 1))))
								.getBlock() == PolishedTorisciteBlock.block.getDefaultState().getBlock())))
				&& ((((world.getBlockState(new BlockPos((int) (x + 2), (int) (y - 4), (int) (z + 1)))).getBlock() == PolishedTorisciteBlock.block
						.getDefaultState().getBlock())
						&& ((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 4), (int) (z + 2))))
								.getBlock() == PolishedTorisciteBlock.block.getDefaultState().getBlock()))
						&& (((world.getBlockState(new BlockPos((int) (x - 2), (int) (y - 4), (int) (z - 1))))
								.getBlock() == PolishedTorisciteBlock.block.getDefaultState().getBlock())
								&& ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 4), (int) (z - 2))))
										.getBlock() == PolishedTorisciteBlock.block.getDefaultState().getBlock()))))
				&& (((((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 4), (int) (z - 1)))).getBlock() == TorisciteBricksBlock.block
						.getDefaultState().getBlock())
						&& ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 4), (int) (z + 1)))).getBlock() == TorisciteBricksBlock.block
								.getDefaultState().getBlock()))
						&& (((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 4), (int) (z - 1)))).getBlock() == TorisciteBricksBlock.block
								.getDefaultState().getBlock())
								&& ((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 4), (int) (z + 1))))
										.getBlock() == TorisciteBricksBlock.block.getDefaultState().getBlock())))
						&& ((((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 4), (int) z))).getBlock() == TorisciteBricksBlock.block
								.getDefaultState().getBlock())
								&& ((world.getBlockState(new BlockPos((int) (x - 2), (int) (y - 4), (int) z)))
										.getBlock() == TorisciteBricksBlock.block.getDefaultState().getBlock()))
								&& (((world.getBlockState(new BlockPos((int) x, (int) (y - 4), (int) (z - 1))))
										.getBlock() == TorisciteBricksBlock.block.getDefaultState().getBlock())
										&& ((world.getBlockState(new BlockPos((int) x, (int) (y - 4), (int) (z - 2))))
												.getBlock() == TorisciteBricksBlock.block.getDefaultState().getBlock())))))
				&& ((((((world.getBlockState(new BlockPos((int) (x - 2), (int) (y - 4), (int) (z - 2)))).getBlock() == TorisciteBricksBlock.block
						.getDefaultState().getBlock())
						&& ((world.getBlockState(new BlockPos((int) (x - 2), (int) (y - 4), (int) (z + 2)))).getBlock() == TorisciteBricksBlock.block
								.getDefaultState().getBlock()))
						&& (((world.getBlockState(new BlockPos((int) (x + 2), (int) (y - 4), (int) (z - 2)))).getBlock() == TorisciteBricksBlock.block
								.getDefaultState().getBlock())
								&& ((world.getBlockState(new BlockPos((int) (x + 2), (int) (y - 4), (int) (z + 2))))
										.getBlock() == TorisciteBricksBlock.block.getDefaultState().getBlock())))
						&& ((((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 4), (int) (z + 3))))
								.getBlock() == TorisciteBricksBlock.block.getDefaultState().getBlock())
								&& ((world.getBlockState(new BlockPos((int) (x + 2), (int) (y - 4), (int) (z + 3))))
										.getBlock() == TorisciteBricksBlock.block.getDefaultState().getBlock()))
								&& (((world.getBlockState(new BlockPos((int) (x + 3), (int) (y - 4), (int) (z + 1))))
										.getBlock() == TorisciteBricksBlock.block.getDefaultState().getBlock())
										&& ((world.getBlockState(new BlockPos((int) (x + 3), (int) (y - 4), (int) (z + 2))))
												.getBlock() == TorisciteBricksBlock.block.getDefaultState().getBlock()))))
						&& (((((world.getBlockState(new BlockPos((int) (x + 3), (int) (y - 4), (int) (z + 3))))
								.getBlock() == OrnateTorisciteBricksBlock.block.getDefaultState().getBlock())
								&& ((world.getBlockState(new BlockPos((int) (x - 3), (int) (y - 4), (int) (z + 1))))
										.getBlock() == TorisciteBricksBlock.block.getDefaultState().getBlock()))
								&& (((world.getBlockState(new BlockPos((int) (x - 3), (int) (y - 4), (int) (z + 2))))
										.getBlock() == TorisciteBricksBlock.block.getDefaultState().getBlock())
										&& (((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 4), (int) (z + 3))))
												.getBlock() == TorisciteBricksBlock.block.getDefaultState().getBlock())
												&& ((world.getBlockState(new BlockPos((int) (x - 2), (int) (y - 4), (int) (z + 3))))
														.getBlock() == TorisciteBricksBlock.block.getDefaultState().getBlock()))))
								&& ((((((world.getBlockState(new BlockPos((int) (x - 3), (int) (y - 4), (int) (z + 3))))
										.getBlock() == ChiselledTorisciteBricksBlock.block.getDefaultState().getBlock())
										&& ((world.getBlockState(new BlockPos((int) (x + 3), (int) (y - 4), (int) (z - 1))))
												.getBlock() == TorisciteBricksBlock.block.getDefaultState().getBlock()))
										&& (((world.getBlockState(new BlockPos((int) (x + 3), (int) (y - 4), (int) (z - 2))))
												.getBlock() == TorisciteBricksBlock.block.getDefaultState().getBlock())
												&& ((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 4), (int) (z - 3))))
														.getBlock() == TorisciteBricksBlock.block.getDefaultState().getBlock())))
										&& ((((world.getBlockState(new BlockPos((int) (x + 2), (int) (y - 4), (int) (z - 3))))
												.getBlock() == TorisciteBricksBlock.block.getDefaultState().getBlock())
												&& ((world.getBlockState(new BlockPos((int) (x + 3), (int) (y - 4), (int) (z - 3))))
														.getBlock() == ChiselledTorisciteBricksBlock.block.getDefaultState().getBlock()))
												&& (((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 4), (int) (z - 3))))
														.getBlock() == TorisciteBricksBlock.block.getDefaultState().getBlock())
														&& ((world.getBlockState(new BlockPos((int) (x - 2), (int) (y - 4), (int) (z - 3))))
																.getBlock() == TorisciteBricksBlock.block.getDefaultState().getBlock()))))
										&& (((((world.getBlockState(new BlockPos((int) (x - 3), (int) (y - 4), (int) (z - 1))))
												.getBlock() == TorisciteBricksBlock.block.getDefaultState().getBlock())
												&& ((world.getBlockState(new BlockPos((int) (x - 3), (int) (y - 4), (int) (z - 2))))
														.getBlock() == TorisciteBricksBlock.block.getDefaultState().getBlock()))
												&& (((world.getBlockState(new BlockPos((int) (x - 3), (int) (y - 4), (int) (z - 3))))
														.getBlock() == ChiselledTorisciteBricksBlock.block.getDefaultState().getBlock())
														&& ((world.getBlockState(new BlockPos((int) (x + 2), (int) (y - 4), (int) (z + 2))))
																.getBlock() == OrnateTorisciteBricksBlock.block.getDefaultState().getBlock())))
												&& ((((world.getBlockState(new BlockPos((int) (x - 2), (int) (y - 4), (int) (z + 2))))
														.getBlock() == OrnateTorisciteBricksBlock.block.getDefaultState().getBlock())
														&& ((world.getBlockState(new BlockPos((int) (x + 2), (int) (y - 4), (int) (z - 2))))
																.getBlock() == OrnateTorisciteBricksBlock.block.getDefaultState().getBlock()))
														&& (((world.getBlockState(new BlockPos((int) (x - 2), (int) (y - 4), (int) (z - 2))))
																.getBlock() == OrnateTorisciteBricksBlock.block.getDefaultState().getBlock())
																&& ((world.getBlockState(new BlockPos((int) x, (int) (y - 4), (int) z)))
																		.getBlock() == OrnateTorisciteBricksBlock.block.getDefaultState()
																				.getBlock()))))))))
				&& ((((((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 3), (int) z))).getBlock() == TorisciteBrickStairsBlock.block
						.getDefaultState().getBlock())
						&& ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 3), (int) z))).getBlock() == TorisciteBrickStairsBlock.block
								.getDefaultState().getBlock()))
						&& (((world.getBlockState(new BlockPos((int) x, (int) (y - 3), (int) (z + 1)))).getBlock() == TorisciteBrickStairsBlock.block
								.getDefaultState().getBlock())
								&& ((world.getBlockState(new BlockPos((int) x, (int) (y - 3), (int) (z - 1))))
										.getBlock() == TorisciteBrickStairsBlock.block.getDefaultState().getBlock())))
						&& ((((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 3), (int) (z + 1))))
								.getBlock() == TorisciteBrickStairsBlock.block.getDefaultState().getBlock())
								&& ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 3), (int) (z + 1))))
										.getBlock() == TorisciteBrickStairsBlock.block.getDefaultState().getBlock()))
								&& (((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 3), (int) (z - 1))))
										.getBlock() == TorisciteBrickStairsBlock.block.getDefaultState().getBlock())
										&& ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 3), (int) (z - 1))))
												.getBlock() == TorisciteBrickStairsBlock.block.getDefaultState().getBlock()))))
						&& ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == GemGildedOrnateTorisciteBricksBlock.block
								.getDefaultState().getBlock())
								&& ((world.getBlockState(new BlockPos((int) x, (int) (y - 3), (int) z)))
										.getBlock() == GemGildedOrnateTorisciteBricksBlock.block.getDefaultState().getBlock()))
								&& ((((world.getBlockState(new BlockPos((int) (x + 2), (int) y, (int) (z + 2))))
										.getBlock() == GemGildedOrnateTorisciteBricksBlock.block.getDefaultState().getBlock())
										&& ((world.getBlockState(new BlockPos((int) (x - 2), (int) y, (int) (z + 2))))
												.getBlock() == GemGildedOrnateTorisciteBricksBlock.block.getDefaultState().getBlock()))
										&& (((world.getBlockState(new BlockPos((int) (x + 2), (int) y, (int) (z - 2))))
												.getBlock() == GemGildedOrnateTorisciteBricksBlock.block.getDefaultState().getBlock())
												&& ((world.getBlockState(new BlockPos((int) (x - 2), (int) y, (int) (z - 2))))
														.getBlock() == GemGildedOrnateTorisciteBricksBlock.block.getDefaultState().getBlock()))))))
				&& (((((world.getBlockState(new BlockPos((int) (x + 2), (int) (y - 3), (int) (z + 2)))).getBlock() == TorisciteBrickWallBlock.block
						.getDefaultState().getBlock())
						&& ((world.getBlockState(new BlockPos((int) (x - 2), (int) (y - 3), (int) (z + 2))))
								.getBlock() == TorisciteBrickWallBlock.block.getDefaultState().getBlock()))
						&& (((world.getBlockState(new BlockPos((int) (x + 2), (int) (y - 3), (int) (z - 2))))
								.getBlock() == TorisciteBrickWallBlock.block.getDefaultState().getBlock())
								&& ((world.getBlockState(new BlockPos((int) (x - 2), (int) (y - 3), (int) (z - 2))))
										.getBlock() == TorisciteBrickWallBlock.block.getDefaultState().getBlock())))
						&& (((((world.getBlockState(new BlockPos((int) (x + 2), (int) (y - 1), (int) (z + 2))))
								.getBlock() == TorisciteBrickWallBlock.block.getDefaultState().getBlock())
								&& ((world.getBlockState(new BlockPos((int) (x - 2), (int) (y - 1), (int) (z + 2))))
										.getBlock() == TorisciteBrickWallBlock.block.getDefaultState().getBlock()))
								&& (((world.getBlockState(new BlockPos((int) (x + 2), (int) (y - 1), (int) (z - 2))))
										.getBlock() == TorisciteBrickWallBlock.block.getDefaultState().getBlock())
										&& ((world.getBlockState(new BlockPos((int) (x - 2), (int) (y - 1), (int) (z - 2))))
												.getBlock() == TorisciteBrickWallBlock.block.getDefaultState().getBlock())))
								&& ((((world.getBlockState(new BlockPos((int) (x + 2), (int) (y - 2), (int) (z + 2))))
										.getBlock() == CobbledTorisciteWallBlock.block.getDefaultState().getBlock())
										&& ((world.getBlockState(new BlockPos((int) (x - 2), (int) (y - 2), (int) (z + 2))))
												.getBlock() == CobbledTorisciteWallBlock.block.getDefaultState().getBlock()))
										&& (((world.getBlockState(new BlockPos((int) (x + 2), (int) (y - 2), (int) (z - 2))))
												.getBlock() == CobbledTorisciteWallBlock.block.getDefaultState().getBlock())
												&& ((world.getBlockState(new BlockPos((int) (x - 2), (int) (y - 2), (int) (z - 2))))
														.getBlock() == CobbledTorisciteWallBlock.block.getDefaultState().getBlock()))))))) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(AugerGemItem.block, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), CorinthPortalBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) (y - 2), (int) z), CorinthPortalBlock.block.getDefaultState(), 3);
				{
					List<Entity> _entfound = world
							.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(x - (5 / 2d), y - (5 / 2d), z - (5 / 2d), x + (5 / 2d), y + (5 / 2d), z + (5 / 2d)), null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof ServerPlayerEntity) {
							Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entityiterator).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("immersion:advancement_thinking_with_portals"));
							AdvancementProgress _ap = ((ServerPlayerEntity) entityiterator).getAdvancements().getProgress(_adv);
							if (!_ap.isDone()) {
								Iterator _iterator = _ap.getRemaningCriteria().iterator();
								while (_iterator.hasNext()) {
									String _criterion = (String) _iterator.next();
									((ServerPlayerEntity) entityiterator).getAdvancements().grantCriterion(_adv, _criterion);
								}
							}
						}
					}
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_portal.spawn")),
							SoundCategory.NEUTRAL, (float) 1, (float) 0.4);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_portal.spawn")),
							SoundCategory.NEUTRAL, (float) 1, (float) 0.4, false);
				}
			}
		}
	}

	@SubscribeEvent
	public void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		PlayerEntity entity = event.getPlayer();
		if (event.getHand() != entity.getActiveHand()) {
			return;
		}
		double i = event.getPos().getX();
		double j = event.getPos().getY();
		double k = event.getPos().getZ();
		IWorld world = event.getWorld();
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
