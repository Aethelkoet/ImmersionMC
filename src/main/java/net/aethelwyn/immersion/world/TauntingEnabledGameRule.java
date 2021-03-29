package net.aethelwyn.immersion.world;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.GameRules;

import net.aethelwyn.immersion.ImmersionModElements;

import java.lang.reflect.Method;

@ImmersionModElements.ModElement.Tag
public class TauntingEnabledGameRule extends ImmersionModElements.ModElement {
	public static final GameRules.RuleKey<GameRules.BooleanValue> gamerule = GameRules.register("tauntingEnabled", GameRules.Category.PLAYER,
			create(true));
	public TauntingEnabledGameRule(ImmersionModElements instance) {
		super(instance, 594);
	}

	public static GameRules.RuleType<GameRules.BooleanValue> create(boolean defaultValue) {
		try {
			Method createGameruleMethod = ObfuscationReflectionHelper.findMethod(GameRules.BooleanValue.class, "func_223568_b", boolean.class);
			createGameruleMethod.setAccessible(true);
			return (GameRules.RuleType<GameRules.BooleanValue>) createGameruleMethod.invoke(null, defaultValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
