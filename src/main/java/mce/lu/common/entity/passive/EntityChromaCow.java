package mce.lu.common.entity.passive;

import java.util.Map;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;

import mce.lu.common.LittleUtilities;
import mce.lu.common.item.ModItems;
import mce.lu.common.util.References;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityChromaCow extends EntityCow {
	private static final DataParameter<Byte> DYE_COLOR = EntityDataManager.<Byte>createKey(EntityChromaCow.class,
			DataSerializers.BYTE);
	private static final Map<EnumDyeColor, float[]> DYE_TO_RGB = Maps.newEnumMap(EnumDyeColor.class);
	public static ResourceLocation CHROMA_COW, CHROMA_COW_BLACK, CHROMA_COW_RED, CHROMA_COW_GREEN, CHROMA_COW_BROWN,
			CHROMA_COW_BLUE, CHROMA_COW_PURPLE, CHROMA_COW_CYAN, CHROMA_COW_LIGHT_GRAY, CHROMA_COW_GRAY,
			CHROMA_COW_PINK, CHROMA_COW_LIME, CHROMA_COW_YELLOW, CHROMA_COW_LIGHT_BLUE, CHROMA_COW_MAGENTA,
			CHROMA_COW_ORANGE, CHROMA_COW_WHITE;

	public static Item[] PIGMENT_BUCKETS = { ModItems.BUCKET_PIGMENT_BLACK, ModItems.BUCKET_PIGMENT_RED,
			ModItems.BUCKET_PIGMENT_GREEN, ModItems.BUCKET_PIGMENT_BROWN, ModItems.BUCKET_PIGMENT_BLUE,
			ModItems.BUCKET_PIGMENT_PURPLE, ModItems.BUCKET_PIGMENT_CYAN, ModItems.BUCKET_PIGMENT_LIGHT_GRAY,
			ModItems.BUCKET_PIGMENT_GRAY, ModItems.BUCKET_PIGMENT_PINK, ModItems.BUCKET_PIGMENT_LIME,
			ModItems.BUCKET_PIGMENT_YELLOW, ModItems.BUCKET_PIGMENT_LIGHT_BLUE, ModItems.BUCKET_PIGMENT_MAGENTA,
			ModItems.BUCKET_PIGMENT_ORANGE, ModItems.BUCKET_PIGMENT_WHITE };

	public static Item[] PIGMENTS = { ModItems.PIGMENT_BLACK, ModItems.PIGMENT_RED, ModItems.PIGMENT_GREEN,
			ModItems.PIGMENT_BROWN, ModItems.PIGMENT_BLUE, ModItems.PIGMENT_PURPLE, ModItems.PIGMENT_CYAN,
			ModItems.PIGMENT_LIGHT_GRAY, ModItems.PIGMENT_GRAY, ModItems.PIGMENT_PINK, ModItems.PIGMENT_LIME,
			ModItems.PIGMENT_YELLOW, ModItems.PIGMENT_LIGHT_BLUE, ModItems.PIGMENT_MAGENTA, ModItems.PIGMENT_ORANGE,
			ModItems.PIGMENT_WHITE };

	/**
	 * Internal inventory to check result of mixing dyes corresponding to the hide
	 * color when breeding
	 */
	private final InventoryCrafting inventory = new InventoryCrafting(new Container() {
		// Player cannot interact with internal crafting container
		public boolean canInteractWith(EntityPlayer player) {
			return false;
		}
	}, 2, 1);

	private static float[] createCowColor(EnumDyeColor color) {
		float[] afloat = color.getColorComponentValues();
		float f = 0.75F;
		return new float[] { afloat[0] * f, afloat[1] * f, afloat[2] * f };
	}

	@SideOnly(Side.CLIENT)
	public static float[] getDyeRgb(EnumDyeColor dyeColor) {
		return DYE_TO_RGB.get(dyeColor);
	}

	public static void registerFixesCow(DataFixer fixer) {
		EntityLiving.registerFixesMob(fixer, EntityChromaCow.class);
	}

	public EntityChromaCow(World worldIn) {
		super(worldIn);
		this.inventory.setInventorySlotContents(0, new ItemStack(Items.DYE));
		this.inventory.setInventorySlotContents(1, new ItemStack(Items.DYE));
	}

	public static void initialize(int id) {
		// Custom Loot Table
		CHROMA_COW = LootTableList
				.register(new ResourceLocation(References.MOD_ID, "loot_table/entities/chroma_cow.json"));
		CHROMA_COW_BLACK = LootTableList
				.register(new ResourceLocation(References.MOD_ID, "loot_table/entities/chroma_cow/black.json"));
		CHROMA_COW_RED = LootTableList
				.register(new ResourceLocation(References.MOD_ID, "loot_table/entities/chroma_cow/red.json"));
		CHROMA_COW_GREEN = LootTableList
				.register(new ResourceLocation(References.MOD_ID, "loot_table/entities/chroma_cow/green.json"));
		CHROMA_COW_BROWN = LootTableList
				.register(new ResourceLocation(References.MOD_ID, "loot_table/entities/chroma_cow/brown.json"));
		CHROMA_COW_BLUE = LootTableList
				.register(new ResourceLocation(References.MOD_ID, "loot_table/entities/chroma_cow/blue.json"));
		CHROMA_COW_PURPLE = LootTableList
				.register(new ResourceLocation(References.MOD_ID, "loot_table/entities/chroma_cow/purple.json"));
		CHROMA_COW_CYAN = LootTableList
				.register(new ResourceLocation(References.MOD_ID, "loot_table/entities/chroma_cow/cyan.json"));
		CHROMA_COW_LIGHT_GRAY = LootTableList
				.register(new ResourceLocation(References.MOD_ID, "loot_table/entities/chroma_cow/light_gray.json"));
		CHROMA_COW_GRAY = LootTableList
				.register(new ResourceLocation(References.MOD_ID, "loot_table/entities/chroma_cow/gray.json"));
		CHROMA_COW_PINK = LootTableList
				.register(new ResourceLocation(References.MOD_ID, "loot_table/entities/chroma_cow/pink.json"));
		CHROMA_COW_LIME = LootTableList
				.register(new ResourceLocation(References.MOD_ID, "loot_table/entities/chroma_cow/lime.json"));
		CHROMA_COW_YELLOW = LootTableList
				.register(new ResourceLocation(References.MOD_ID, "loot_table/entities/chroma_cow/yellow.json"));
		CHROMA_COW_LIGHT_BLUE = LootTableList
				.register(new ResourceLocation(References.MOD_ID, "loot_table/entities/chroma_cow/light_blue.json"));
		CHROMA_COW_MAGENTA = LootTableList
				.register(new ResourceLocation(References.MOD_ID, "loot_table/entities/chroma_cow/magenta.json"));
		CHROMA_COW_ORANGE = LootTableList
				.register(new ResourceLocation(References.MOD_ID, "loot_table/entities/chroma_cow/orange.json"));
		CHROMA_COW_WHITE = LootTableList
				.register(new ResourceLocation(References.MOD_ID, "loot_table/entities/chroma_cow/white.json"));

		// Egg
		EntityRegistry.registerModEntity(new ResourceLocation(References.MOD_ID, "chroma_cow"), EntityChromaCow.class,
				"chroma_cow", id, LittleUtilities.instance, 64, 1, true, 0xffffff, 0xffffff);
	}

	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(DYE_COLOR, Byte.valueOf((byte) 0));
	}

	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);

		if (!this.world.isRemote && stack.getItem() == Items.BUCKET && !this.isChild() && !player.isCreative()) {
			stack.shrink(1);

			for (int i = 0; i < 16; ++i) {
				if (i == getHideColorInt()) {
					if (stack.isEmpty())
						player.setHeldItem(hand, new ItemStack(PIGMENT_BUCKETS[i]));

					else if (!player.inventory.addItemStackToInventory(new ItemStack(PIGMENT_BUCKETS[i])))
						player.dropItem(new ItemStack(PIGMENT_BUCKETS[i]), false);
				}
			}
			return true;
		} else if (!this.world.isRemote && stack.getItem() == ModItems.SPONGE) {
			this.setDead();

			EntityCow cow = new EntityCow(this.world);
			cow.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
			cow.setHealth(this.getHealth());
			cow.renderYawOffset = this.renderYawOffset;

			if (this.hasCustomName())
				cow.setCustomNameTag(this.getCustomNameTag());
			this.world.spawnEntity(cow);

			for (int i = 0; i < 16; ++i)
				if (i == getHideColorInt())
					this.world.spawnEntity(new EntityItem(this.world, this.posX, this.posY + (double) this.height,
							this.posZ, new ItemStack(PIGMENTS[i])));

			this.playSound(SoundEvents.ENTITY_MOOSHROOM_SHEAR, 1f, 1f);
			return true;
		} else {
			return super.processInteract(player, hand);
		}
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		switch (this.getHideColor()) {
		case BLACK:
			return CHROMA_COW_BLACK;
		case RED:
			return CHROMA_COW_RED;
		case GREEN:
			return CHROMA_COW_GREEN;
		case BROWN:
			return CHROMA_COW_BROWN;
		case BLUE:
			return CHROMA_COW_BLUE;
		case PURPLE:
			return CHROMA_COW_PURPLE;
		case CYAN:
			return CHROMA_COW_CYAN;
		case SILVER:
			return CHROMA_COW_LIGHT_GRAY;
		case GRAY:
			return CHROMA_COW_GRAY;
		case PINK:
			return CHROMA_COW_PINK;
		case LIME:
			return CHROMA_COW_LIME;
		case YELLOW:
			return CHROMA_COW_YELLOW;
		case LIGHT_BLUE:
			return CHROMA_COW_LIGHT_BLUE;
		case MAGENTA:
			return CHROMA_COW_MAGENTA;
		case ORANGE:
			return CHROMA_COW_ORANGE;
		case WHITE:
			return CHROMA_COW_WHITE;
		default:
			return CHROMA_COW;
		}
	}

	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setByte("Color", (byte) this.getHideColor().getMetadata());
	}

	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setHideColor(EnumDyeColor.byMetadata(compound.getByte("Color")));
	}

	public EntityChromaCow createChild(EntityAgeable ageable) {
		EntityChromaCow cow = (EntityChromaCow) ageable;
		EntityChromaCow cow1 = new EntityChromaCow(this.world);
		cow1.setHideColor(this.getDyeColorMixFromParents(this, cow));
		return cow1;
	}

	/**
	 * Gets the hide color of this cow. Return EnumDyeColor
	 */
	public EnumDyeColor getHideColor() {
		return EnumDyeColor.byMetadata(((Byte) this.dataManager.get(DYE_COLOR)).byteValue() & 15);
	}

	/**
	 * Gets the hide color of this cow. Return integer from the dye damage instead
	 * of the metadata. (So you don't have to do "15 - i")
	 */
	public int getHideColorInt() {
		return EnumDyeColor.byMetadata(((Byte) this.dataManager.get(DYE_COLOR)).byteValue() & 15).getDyeDamage();
	}

	/**
	 * Sets the hide color of this cow.
	 */
	public void setHideColor(EnumDyeColor color) {
		byte b0 = ((Byte) this.dataManager.get(DYE_COLOR)).byteValue();
		this.dataManager.set(DYE_COLOR, Byte.valueOf((byte) (b0 & 240 | color.getMetadata() & 15)));
	}

	private EnumDyeColor getDyeColorMixFromParents(EntityAnimal father, EntityAnimal mother) {
		int i = ((EntityChromaCow) father).getHideColorInt();
		int j = ((EntityChromaCow) mother).getHideColorInt();
		this.inventory.getStackInSlot(0).setItemDamage(i);
		this.inventory.getStackInSlot(1).setItemDamage(j);
		ItemStack itemstack = CraftingManager.findMatchingResult(this.inventory, ((EntityChromaCow) father).world);
		int k;

		if (itemstack.getItem() == Items.DYE) {
			k = itemstack.getMetadata();
		} else {
			k = this.world.rand.nextBoolean() ? i : j;
		}

		return EnumDyeColor.byDyeDamage(k);
	}

	static {
		for (EnumDyeColor color : EnumDyeColor.values()) {
			DYE_TO_RGB.put(color, createCowColor(color));
		}

		DYE_TO_RGB.put(EnumDyeColor.WHITE, new float[] { 0.9019608F, 0.9019608F, 0.9019608F });
	}
}
