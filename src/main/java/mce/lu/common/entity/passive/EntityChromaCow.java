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
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.EnumDyeColor;
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

	/**
	 * Internal inventory to check result of mixing dyes corresponding to the
	 * hide color when breeding
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

	public EntityChromaCow(World worldIn) {
		super(worldIn);
		this.inventory.setInventorySlotContents(0, new ItemStack(Items.DYE));
		this.inventory.setInventorySlotContents(1, new ItemStack(Items.DYE));
	}

	public static void initialize(int id) {
		// Custom Loot Table
		CHROMA_COW = LootTableList.register(new ResourceLocation(References.MOD_ID, "entities/chroma_cow"));
		CHROMA_COW_BLACK = LootTableList
				.register(new ResourceLocation(References.MOD_ID, "entities/chroma_cow/black"));
		CHROMA_COW_RED = LootTableList.register(new ResourceLocation(References.MOD_ID, "entities/chroma_cow/red"));
		CHROMA_COW_GREEN = LootTableList
				.register(new ResourceLocation(References.MOD_ID, "entities/chroma_cow/green"));
		CHROMA_COW_BROWN = LootTableList
				.register(new ResourceLocation(References.MOD_ID, "entities/chroma_cow/brown"));
		CHROMA_COW_BLUE = LootTableList.register(new ResourceLocation(References.MOD_ID, "entities/chroma_cow/blue"));
		CHROMA_COW_PURPLE = LootTableList
				.register(new ResourceLocation(References.MOD_ID, "entities/chroma_cow/purple"));
		CHROMA_COW_CYAN = LootTableList.register(new ResourceLocation(References.MOD_ID, "entities/chroma_cow/cyan"));
		CHROMA_COW_LIGHT_GRAY = LootTableList
				.register(new ResourceLocation(References.MOD_ID, "entities/chroma_cow/light_gray"));
		CHROMA_COW_GRAY = LootTableList.register(new ResourceLocation(References.MOD_ID, "entities/chroma_cow/gray"));
		CHROMA_COW_PINK = LootTableList.register(new ResourceLocation(References.MOD_ID, "entities/chroma_cow/pink"));
		CHROMA_COW_LIME = LootTableList.register(new ResourceLocation(References.MOD_ID, "entities/chroma_cow/lime"));
		CHROMA_COW_YELLOW = LootTableList
				.register(new ResourceLocation(References.MOD_ID, "entities/chroma_cow/yellow"));
		CHROMA_COW_LIGHT_BLUE = LootTableList
				.register(new ResourceLocation(References.MOD_ID, "entities/chroma_cow/light_blue"));
		CHROMA_COW_MAGENTA = LootTableList
				.register(new ResourceLocation(References.MOD_ID, "entities/chroma_cow/magenta"));
		CHROMA_COW_ORANGE = LootTableList
				.register(new ResourceLocation(References.MOD_ID, "entities/chroma_cow/orange"));
		CHROMA_COW_WHITE = LootTableList
				.register(new ResourceLocation(References.MOD_ID, "entities/chroma_cow/white"));

		// Egg
		EntityRegistry.registerModEntity(new ResourceLocation(References.MOD_ID, "chroma_cow"), EntityChromaCow.class,
				(References.MOD_ID + "chroma_cow"), id, LittleUtilities.instance, 3, 1, true, 0xffffff, 0xffffff);
	}

	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(DYE_COLOR, Byte.valueOf((byte) 0));
	}

	public static void registerFixesCow(DataFixer fixer) {
		EntityLiving.registerFixesMob(fixer, EntityChromaCow.class);
	}

	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);

		if (stack.getItem() == Items.BUCKET && this.getGrowingAge() >= 0 && !player.isCreative()) {
			stack.shrink(1);

			if (stack.isEmpty()) {
				switch (this.getHideColor()) {
				case BLACK:
					player.setHeldItem(hand, new ItemStack(ModItems.BUCKET_PIGMENT_BLACK));
				case RED:
					player.setHeldItem(hand, new ItemStack(ModItems.BUCKET_PIGMENT_RED));
				case GREEN:
					player.setHeldItem(hand, new ItemStack(ModItems.BUCKET_PIGMENT_GREEN));
				case BROWN:
					player.setHeldItem(hand, new ItemStack(ModItems.BUCKET_PIGMENT_BROWN));
				case BLUE:
					player.setHeldItem(hand, new ItemStack(ModItems.BUCKET_PIGMENT_BLUE));
				case PURPLE:
					player.setHeldItem(hand, new ItemStack(ModItems.BUCKET_PIGMENT_PURPLE));
				case CYAN:
					player.setHeldItem(hand, new ItemStack(ModItems.BUCKET_PIGMENT_CYAN));
				case SILVER:
					player.setHeldItem(hand, new ItemStack(ModItems.BUCKET_PIGMENT_LIGHT_GRAY));
				case GRAY:
					player.setHeldItem(hand, new ItemStack(ModItems.BUCKET_PIGMENT_GRAY));
				case PINK:
					player.setHeldItem(hand, new ItemStack(ModItems.BUCKET_PIGMENT_PINK));
				case LIME:
					player.setHeldItem(hand, new ItemStack(ModItems.BUCKET_PIGMENT_LIME));
				case YELLOW:
					player.setHeldItem(hand, new ItemStack(ModItems.BUCKET_PIGMENT_YELLOW));
				case LIGHT_BLUE:
					player.setHeldItem(hand, new ItemStack(ModItems.BUCKET_PIGMENT_LIGHT_BLUE));
				case MAGENTA:
					player.setHeldItem(hand, new ItemStack(ModItems.BUCKET_PIGMENT_MAGENTA));
				case ORANGE:
					player.setHeldItem(hand, new ItemStack(ModItems.BUCKET_PIGMENT_ORANGE));
				case WHITE:
					player.setHeldItem(hand, new ItemStack(ModItems.BUCKET_PIGMENT_WHITE));
				}
			}
			return true;
		} else if (stack.getItem() == ModItems.SPONGE) {
			this.setDead();

			if (!this.world.isRemote) {
				EntityCow cow = new EntityCow(this.world);
				cow.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
				cow.setHealth(this.getHealth());
				cow.renderYawOffset = this.renderYawOffset;

				if (this.hasCustomName()) {
					cow.setCustomNameTag(this.getCustomNameTag());
				}

				this.world.spawnEntity(cow);
				switch (this.getHideColor()) {
				case BLACK:
					this.world.spawnEntity(new EntityItem(this.world, this.posX, this.posY + (double) this.height,
							this.posZ, new ItemStack(ModItems.PIGMENT_BLACK)));
				case RED:
					this.world.spawnEntity(new EntityItem(this.world, this.posX, this.posY + (double) this.height,
							this.posZ, new ItemStack(ModItems.PIGMENT_RED)));
				case GREEN:
					this.world.spawnEntity(new EntityItem(this.world, this.posX, this.posY + (double) this.height,
							this.posZ, new ItemStack(ModItems.PIGMENT_GREEN)));
				case BROWN:
					this.world.spawnEntity(new EntityItem(this.world, this.posX, this.posY + (double) this.height,
							this.posZ, new ItemStack(ModItems.PIGMENT_BROWN)));
				case BLUE:
					this.world.spawnEntity(new EntityItem(this.world, this.posX, this.posY + (double) this.height,
							this.posZ, new ItemStack(ModItems.PIGMENT_BLUE)));
				case PURPLE:
					this.world.spawnEntity(new EntityItem(this.world, this.posX, this.posY + (double) this.height,
							this.posZ, new ItemStack(ModItems.PIGMENT_PURPLE)));
				case CYAN:
					this.world.spawnEntity(new EntityItem(this.world, this.posX, this.posY + (double) this.height,
							this.posZ, new ItemStack(ModItems.PIGMENT_CYAN)));
				case SILVER:
					this.world.spawnEntity(new EntityItem(this.world, this.posX, this.posY + (double) this.height,
							this.posZ, new ItemStack(ModItems.PIGMENT_LIGHT_GRAY)));
				case GRAY:
					this.world.spawnEntity(new EntityItem(this.world, this.posX, this.posY + (double) this.height,
							this.posZ, new ItemStack(ModItems.PIGMENT_GRAY)));
				case PINK:
					this.world.spawnEntity(new EntityItem(this.world, this.posX, this.posY + (double) this.height,
							this.posZ, new ItemStack(ModItems.PIGMENT_PINK)));
				case LIME:
					this.world.spawnEntity(new EntityItem(this.world, this.posX, this.posY + (double) this.height,
							this.posZ, new ItemStack(ModItems.PIGMENT_LIME)));
				case YELLOW:
					this.world.spawnEntity(new EntityItem(this.world, this.posX, this.posY + (double) this.height,
							this.posZ, new ItemStack(ModItems.PIGMENT_YELLOW)));
				case LIGHT_BLUE:
					this.world.spawnEntity(new EntityItem(this.world, this.posX, this.posY + (double) this.height,
							this.posZ, new ItemStack(ModItems.PIGMENT_LIGHT_BLUE)));
				case MAGENTA:
					this.world.spawnEntity(new EntityItem(this.world, this.posX, this.posY + (double) this.height,
							this.posZ, new ItemStack(ModItems.PIGMENT_MAGENTA)));
				case ORANGE:
					this.world.spawnEntity(new EntityItem(this.world, this.posX, this.posY + (double) this.height,
							this.posZ, new ItemStack(ModItems.PIGMENT_ORANGE)));
				case WHITE:
					this.world.spawnEntity(new EntityItem(this.world, this.posX, this.posY + (double) this.height,
							this.posZ, new ItemStack(ModItems.PIGMENT_WHITE)));
				}

				this.playSound(SoundEvents.ENTITY_MOOSHROOM_SHEAR, 1f, 1f);
			}

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
	 * Gets the hide color of this cow.
	 */
	public EnumDyeColor getHideColor() {
		return EnumDyeColor.byMetadata(((Byte) this.dataManager.get(DYE_COLOR)).byteValue() & 15);
	}

	/**
	 * Sets the hide color of this cow.
	 */
	public void setHideColor(EnumDyeColor color) {
		byte b0 = ((Byte) this.dataManager.get(DYE_COLOR)).byteValue();
		this.dataManager.set(DYE_COLOR, Byte.valueOf((byte) (b0 & 240 | color.getMetadata() & 15)));
	}

	private EnumDyeColor getDyeColorMixFromParents(EntityAnimal father, EntityAnimal mother) {
		int i = ((EntitySheep) father).getFleeceColor().getDyeDamage();
		int j = ((EntitySheep) mother).getFleeceColor().getDyeDamage();
		this.inventory.getStackInSlot(0).setItemDamage(i);
		this.inventory.getStackInSlot(1).setItemDamage(j);
		ItemStack itemstack = CraftingManager.findMatchingResult(this.inventory, ((EntitySheep) father).world);
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
