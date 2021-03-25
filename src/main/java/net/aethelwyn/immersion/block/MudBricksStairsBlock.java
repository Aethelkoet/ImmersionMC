
package net.aethelwyn.immersion.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.aethelwyn.immersion.ImmersionModElements;

import java.util.List;
import java.util.Collections;

@ImmersionModElements.ModElement.Tag
public class MudBricksStairsBlock extends ImmersionModElements.ModElement {
	@ObjectHolder("immersion:mud_bricks_stairs")
	public static final Block block = null;
	public MudBricksStairsBlock(ImmersionModElements instance) {
		super(instance, 71);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends StairsBlock {
		public CustomBlock() {
			super(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.2f, 2.5f)).getDefaultState(),
					Block.Properties.create(Material.EARTH).sound(SoundType.WET_GRASS).hardnessAndResistance(1.2f, 2.5f).setLightLevel(s -> 0)
							.harvestLevel(1).harvestTool(ToolType.SHOVEL).setRequiresTool());
			setRegistryName("mud_bricks_stairs");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
