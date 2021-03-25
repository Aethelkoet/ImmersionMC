
package net.aethelwyn.immersion.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.aethelwyn.immersion.procedures.MudSinkProcedure;
import net.aethelwyn.immersion.item.MudBallItem;
import net.aethelwyn.immersion.ImmersionModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;

@ImmersionModElements.ModElement.Tag
public class MudBlock extends ImmersionModElements.ModElement {
	@ObjectHolder("immersion:mud")
	public static final Block block = null;
	public MudBlock(ImmersionModElements instance) {
		super(instance, 68);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}
	public static class CustomBlock extends FallingBlock {
		public CustomBlock() {
			super(Block.Properties.create(Material.EARTH).sound(SoundType.WET_GRASS).hardnessAndResistance(0.85f, 0.5f).setLightLevel(s -> 0)
					.harvestLevel(1).harvestTool(ToolType.SHOVEL).setRequiresTool().doesNotBlockMovement().notSolid()
					.setOpaque((bs, br, bp) -> false));
			setRegistryName("mud");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(MudBallItem.block, (int) (4)));
		}

		@Override
		public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
			super.onEntityCollision(state, world, pos, entity);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				MudSinkProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
