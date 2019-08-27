package mce.lu.common.item;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemColored;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemColoredBase extends ItemColored {
	public String toolTip;
	boolean hasToolTip;

	public ItemColoredBase(Block block, boolean hasSubtypes) {
		super(block, hasSubtypes);
	}

	public Item setToolTip(String toolTip) {
		if (toolTip != null) {
			this.hasToolTip = true;
			this.toolTip = toolTip;
		}
		return this;
	}

	@Override
	public int getMetadata(int meta) {
		return meta;
	}

	/**
	 * Here so yall can know how to add tooltips to items.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
		if (this.hasToolTip)
			list.add(toolTip.toString());
	}
}
