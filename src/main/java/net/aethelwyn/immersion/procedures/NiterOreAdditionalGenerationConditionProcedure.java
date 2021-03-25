package net.aethelwyn.immersion.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.aethelwyn.immersion.block.NiterOreBlock;
import net.aethelwyn.immersion.ImmersionModElements;
import net.aethelwyn.immersion.ImmersionMod;

import java.util.Map;

@ImmersionModElements.ModElement.Tag
public class NiterOreAdditionalGenerationConditionProcedure extends ImmersionModElements.ModElement {
	public NiterOreAdditionalGenerationConditionProcedure(ImmersionModElements instance) {
		super(instance, 336);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ImmersionMod.LOGGER.warn("Failed to load dependency x for procedure NiterOreAdditionalGenerationCondition!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ImmersionMod.LOGGER.warn("Failed to load dependency z for procedure NiterOreAdditionalGenerationCondition!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ImmersionMod.LOGGER.warn("Failed to load dependency world for procedure NiterOreAdditionalGenerationCondition!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) 33, (int) z))).getBlock() == Blocks.STONE.getDefaultState().getBlock())) {
			if ((Math.random() < 0.034)) {
				world.setBlockState(new BlockPos((int) x, (int) 33, (int) z), NiterOreBlock.block.getDefaultState(), 3);
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) 32, (int) z))).getBlock() == Blocks.STONE.getDefaultState().getBlock())) {
			if ((Math.random() < 0.08)) {
				world.setBlockState(new BlockPos((int) x, (int) 32, (int) z), NiterOreBlock.block.getDefaultState(), 3);
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) 31, (int) z))).getBlock() == Blocks.STONE.getDefaultState().getBlock())) {
			if ((Math.random() < 0.034)) {
				world.setBlockState(new BlockPos((int) x, (int) 31, (int) z), NiterOreBlock.block.getDefaultState(), 3);
			}
		}
	}
}
