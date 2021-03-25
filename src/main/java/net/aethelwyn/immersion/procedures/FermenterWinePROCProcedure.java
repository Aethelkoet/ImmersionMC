package net.aethelwyn.immersion.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.Property;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.aethelwyn.immersion.item.StrawberryJuiceBottleItem;
import net.aethelwyn.immersion.item.StrawberryItem;
import net.aethelwyn.immersion.item.JuicedCarrotBottleItem;
import net.aethelwyn.immersion.item.JuicedBeetrootBottleItem;
import net.aethelwyn.immersion.item.JuicedAppleBottleItem;
import net.aethelwyn.immersion.item.GrapesItem;
import net.aethelwyn.immersion.item.GrapeWineBottleItem;
import net.aethelwyn.immersion.item.ChorusWineBottleItem;
import net.aethelwyn.immersion.item.CactusWineBottleItem;
import net.aethelwyn.immersion.item.BlackcurrantJuiceBottleItem;
import net.aethelwyn.immersion.item.BlackcurrantItem;
import net.aethelwyn.immersion.item.BlackberryJuiceBottleItem;
import net.aethelwyn.immersion.item.BlackberriesItem;
import net.aethelwyn.immersion.item.BerryWineBottleItem;
import net.aethelwyn.immersion.block.FermenterBlock;
import net.aethelwyn.immersion.ImmersionModElements;
import net.aethelwyn.immersion.ImmersionMod;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;

@ImmersionModElements.ModElement.Tag
public class FermenterWinePROCProcedure extends ImmersionModElements.ModElement {
	public FermenterWinePROCProcedure(ImmersionModElements instance) {
		super(instance, 274);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ImmersionMod.LOGGER.warn("Failed to load dependency entity for procedure FermenterWinePROC!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ImmersionMod.LOGGER.warn("Failed to load dependency x for procedure FermenterWinePROC!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ImmersionMod.LOGGER.warn("Failed to load dependency y for procedure FermenterWinePROC!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ImmersionMod.LOGGER.warn("Failed to load dependency z for procedure FermenterWinePROC!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ImmersionMod.LOGGER.warn("Failed to load dependency world for procedure FermenterWinePROC!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(Items.GLASS_BOTTLE, (int) (1)).getItem())) {
			if (((new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(Items.SWEET_BERRIES, (int) (1))
					.getItem())) {
				if ((Math.random() <= 0.35)) {
					if ((!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity)))) {
						if (entity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.GLASS_BOTTLE, (int) (1));
							((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) entity).container.func_234641_j_());
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(BerryWineBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					} else {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(BerryWineBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
							if (_ent != null) {
								final int _sltid = (int) (0);
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, ItemStack.EMPTY);
									}
								});
							}
						}
						{
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							BlockState _bs = FermenterBlock.block.getDefaultState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
								if (_property != null && _bs.get(_property) != null)
									try {
										_bs = _bs.with(_property, (Comparable) entry.getValue());
									} catch (Exception e) {
									}
							}
							world.setBlockState(_bp, _bs, 3);
						}
					}
				} else {
					if ((!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity)))) {
						if (entity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.GLASS_BOTTLE, (int) (1));
							((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) entity).container.func_234641_j_());
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(BerryWineBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					} else {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(BerryWineBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					}
				}
			} else if (((new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(Blocks.CACTUS, (int) (1)).getItem())) {
				if ((Math.random() <= 0.35)) {
					if ((!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity)))) {
						if (entity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.GLASS_BOTTLE, (int) (1));
							((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) entity).container.func_234641_j_());
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(CactusWineBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					} else {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(CactusWineBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					}
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
						if (_ent != null) {
							final int _sltid = (int) (0);
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable) {
									((IItemHandlerModifiable) capability).setStackInSlot(_sltid, ItemStack.EMPTY);
								}
							});
						}
					}
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = FermenterBlock.block.getDefaultState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
							if (_property != null && _bs.get(_property) != null)
								try {
									_bs = _bs.with(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlockState(_bp, _bs, 3);
					}
				} else {
					if ((!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity)))) {
						if (entity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.GLASS_BOTTLE, (int) (1));
							((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) entity).container.func_234641_j_());
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(CactusWineBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					} else {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(CactusWineBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					}
				}
			} else if (((new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(Items.CHORUS_FRUIT, (int) (1))
					.getItem())) {
				if ((Math.random() <= 0.35)) {
					if ((!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity)))) {
						if (entity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.GLASS_BOTTLE, (int) (1));
							((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) entity).container.func_234641_j_());
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(ChorusWineBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					} else {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(ChorusWineBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					}
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
						if (_ent != null) {
							final int _sltid = (int) (0);
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable) {
									((IItemHandlerModifiable) capability).setStackInSlot(_sltid, ItemStack.EMPTY);
								}
							});
						}
					}
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = FermenterBlock.block.getDefaultState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
							if (_property != null && _bs.get(_property) != null)
								try {
									_bs = _bs.with(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlockState(_bp, _bs, 3);
					}
				} else {
					if ((!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity)))) {
						if (entity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.GLASS_BOTTLE, (int) (1));
							((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) entity).container.func_234641_j_());
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(ChorusWineBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					} else {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(ChorusWineBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					}
				}
			} else if (((new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(Items.CARROT, (int) (1)).getItem())) {
				if ((Math.random() <= 0.35)) {
					if ((!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity)))) {
						if (entity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.GLASS_BOTTLE, (int) (1));
							((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) entity).container.func_234641_j_());
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(JuicedCarrotBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					} else {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(JuicedCarrotBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
							if (_ent != null) {
								final int _sltid = (int) (0);
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, ItemStack.EMPTY);
									}
								});
							}
						}
						{
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							BlockState _bs = FermenterBlock.block.getDefaultState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
								if (_property != null && _bs.get(_property) != null)
									try {
										_bs = _bs.with(_property, (Comparable) entry.getValue());
									} catch (Exception e) {
									}
							}
							world.setBlockState(_bp, _bs, 3);
						}
					}
				} else {
					if ((!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity)))) {
						if (entity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.GLASS_BOTTLE, (int) (1));
							((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) entity).container.func_234641_j_());
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(JuicedCarrotBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					} else {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(JuicedCarrotBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					}
				}
			} else if (((new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(Items.APPLE, (int) (1)).getItem())) {
				if ((Math.random() <= 0.35)) {
					if ((!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity)))) {
						if (entity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.GLASS_BOTTLE, (int) (1));
							((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) entity).container.func_234641_j_());
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(JuicedAppleBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					} else {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(JuicedAppleBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
							if (_ent != null) {
								final int _sltid = (int) (0);
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, ItemStack.EMPTY);
									}
								});
							}
						}
						{
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							BlockState _bs = FermenterBlock.block.getDefaultState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
								if (_property != null && _bs.get(_property) != null)
									try {
										_bs = _bs.with(_property, (Comparable) entry.getValue());
									} catch (Exception e) {
									}
							}
							world.setBlockState(_bp, _bs, 3);
						}
					}
				} else {
					if ((!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity)))) {
						if (entity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.GLASS_BOTTLE, (int) (1));
							((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) entity).container.func_234641_j_());
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(JuicedAppleBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					} else {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(JuicedAppleBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					}
				}
			} else if (((new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(Items.BEETROOT, (int) (1)).getItem())) {
				if ((Math.random() <= 0.35)) {
					if ((!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity)))) {
						if (entity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.GLASS_BOTTLE, (int) (1));
							((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) entity).container.func_234641_j_());
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(JuicedBeetrootBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					} else {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(JuicedBeetrootBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
							if (_ent != null) {
								final int _sltid = (int) (0);
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, ItemStack.EMPTY);
									}
								});
							}
						}
						{
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							BlockState _bs = FermenterBlock.block.getDefaultState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
								if (_property != null && _bs.get(_property) != null)
									try {
										_bs = _bs.with(_property, (Comparable) entry.getValue());
									} catch (Exception e) {
									}
							}
							world.setBlockState(_bp, _bs, 3);
						}
					}
				} else {
					if ((!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity)))) {
						if (entity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.GLASS_BOTTLE, (int) (1));
							((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) entity).container.func_234641_j_());
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(JuicedBeetrootBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					} else {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(JuicedBeetrootBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					}
				}
			} else if (((new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(GrapesItem.block, (int) (1)).getItem())) {
				if ((Math.random() <= 0.35)) {
					if ((!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity)))) {
						if (entity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.GLASS_BOTTLE, (int) (1));
							((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) entity).container.func_234641_j_());
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(GrapeWineBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					} else {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(GrapeWineBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
							if (_ent != null) {
								final int _sltid = (int) (0);
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, ItemStack.EMPTY);
									}
								});
							}
						}
						{
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							BlockState _bs = FermenterBlock.block.getDefaultState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
								if (_property != null && _bs.get(_property) != null)
									try {
										_bs = _bs.with(_property, (Comparable) entry.getValue());
									} catch (Exception e) {
									}
							}
							world.setBlockState(_bp, _bs, 3);
						}
					}
				} else {
					if ((!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity)))) {
						if (entity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.GLASS_BOTTLE, (int) (1));
							((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) entity).container.func_234641_j_());
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(GrapeWineBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					} else {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(GrapeWineBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					}
				}
			} else if (((new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(StrawberryItem.block, (int) (1))
					.getItem())) {
				if ((Math.random() <= 0.35)) {
					if ((!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity)))) {
						if (entity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.GLASS_BOTTLE, (int) (1));
							((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) entity).container.func_234641_j_());
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(StrawberryJuiceBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					} else {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(StrawberryJuiceBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
							if (_ent != null) {
								final int _sltid = (int) (0);
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, ItemStack.EMPTY);
									}
								});
							}
						}
						{
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							BlockState _bs = FermenterBlock.block.getDefaultState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
								if (_property != null && _bs.get(_property) != null)
									try {
										_bs = _bs.with(_property, (Comparable) entry.getValue());
									} catch (Exception e) {
									}
							}
							world.setBlockState(_bp, _bs, 3);
						}
					}
				} else {
					if ((!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity)))) {
						if (entity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.GLASS_BOTTLE, (int) (1));
							((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) entity).container.func_234641_j_());
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(StrawberryJuiceBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					} else {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(StrawberryJuiceBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					}
				}
			} else if (((new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(BlackberriesItem.block, (int) (1))
					.getItem())) {
				if ((Math.random() <= 0.35)) {
					if ((!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity)))) {
						if (entity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.GLASS_BOTTLE, (int) (1));
							((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) entity).container.func_234641_j_());
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(BlackberryJuiceBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					} else {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(BlackberryJuiceBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
							if (_ent != null) {
								final int _sltid = (int) (0);
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, ItemStack.EMPTY);
									}
								});
							}
						}
						{
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							BlockState _bs = FermenterBlock.block.getDefaultState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
								if (_property != null && _bs.get(_property) != null)
									try {
										_bs = _bs.with(_property, (Comparable) entry.getValue());
									} catch (Exception e) {
									}
							}
							world.setBlockState(_bp, _bs, 3);
						}
					}
				} else {
					if ((!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity)))) {
						if (entity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.GLASS_BOTTLE, (int) (1));
							((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) entity).container.func_234641_j_());
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(BlackberryJuiceBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					} else {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(BlackberryJuiceBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					}
				}
			} else if (((new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(BlackcurrantItem.block, (int) (1))
					.getItem())) {
				if ((Math.random() <= 0.35)) {
					if ((!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity)))) {
						if (entity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.GLASS_BOTTLE, (int) (1));
							((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) entity).container.func_234641_j_());
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(BlackcurrantJuiceBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					} else {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(BlackcurrantJuiceBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
							if (_ent != null) {
								final int _sltid = (int) (0);
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, ItemStack.EMPTY);
									}
								});
							}
						}
						{
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							BlockState _bs = FermenterBlock.block.getDefaultState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
								if (_property != null && _bs.get(_property) != null)
									try {
										_bs = _bs.with(_property, (Comparable) entry.getValue());
									} catch (Exception e) {
									}
							}
							world.setBlockState(_bp, _bs, 3);
						}
					}
				} else {
					if ((!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayerEntity) {
								return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
							} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
								NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
										.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
								return _npi != null && _npi.getGameType() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity)))) {
						if (entity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.GLASS_BOTTLE, (int) (1));
							((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) entity).container.func_234641_j_());
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(BlackcurrantJuiceBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					} else {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(BlackcurrantJuiceBottleItem.block, (int) (1));
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					}
				}
			}
		}
	}
}
