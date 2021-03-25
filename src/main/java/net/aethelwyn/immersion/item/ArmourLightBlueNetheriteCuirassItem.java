
package net.aethelwyn.immersion.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.Entity;

import net.aethelwyn.immersion.ImmersionModElements;

@ImmersionModElements.ModElement.Tag
public class ArmourLightBlueNetheriteCuirassItem extends ImmersionModElements.ModElement {
	@ObjectHolder("immersion:armour_light_blue_netherite_cuirass_helmet")
	public static final Item helmet = null;
	@ObjectHolder("immersion:armour_light_blue_netherite_cuirass_chestplate")
	public static final Item body = null;
	@ObjectHolder("immersion:armour_light_blue_netherite_cuirass_leggings")
	public static final Item legs = null;
	@ObjectHolder("immersion:armour_light_blue_netherite_cuirass_boots")
	public static final Item boots = null;
	public ArmourLightBlueNetheriteCuirassItem(ImmersionModElements instance) {
		super(instance, 119);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 37;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 5, 6, 2}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 15;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_netherite"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.NETHERITE_INGOT, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "armour_light_blue_netherite_cuirass";
			}

			@Override
			public float getToughness() {
				return 3f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.1f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "immersion:textures/models/armor/light_blue_netherite_cuirass__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("armour_light_blue_netherite_cuirass_chestplate"));
	}
}
