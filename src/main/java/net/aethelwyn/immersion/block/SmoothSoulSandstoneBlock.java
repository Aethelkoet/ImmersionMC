
package net.aethelwyn.immersion.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.aethelwyn.immersion.ImmersionModElements;

import java.util.List;
import java.util.Collections;

@ImmersionModElements.ModElement.Tag
public class SmoothSoulSandstoneBlock extends ImmersionModElements.ModElement {
	@ObjectHolder("immersion:smooth_soul_sandstone")
	public static final Block block = null;
	public SmoothSoulSandstoneBlock(ImmersionModElements instance) {
		super(instance, 58);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.SOUL_SOIL).hardnessAndResistance(0.8f, 0.8f).setLightLevel(s -> 0)
					.harvestLevel(1).harvestTool(ToolType.PICKAXE).setRequiresTool());
			setRegistryName("smooth_soul_sandstone");
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
