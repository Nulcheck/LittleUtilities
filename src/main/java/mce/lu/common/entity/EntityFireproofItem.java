package mce.lu.common.entity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityFireproofItem extends EntityItem {
	public EntityFireproofItem(World worldIn) {
		super(worldIn);
	}

	public EntityFireproofItem(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	public EntityFireproofItem(World worldIn, double x, double y, double z, ItemStack stack) {
		super(worldIn, x, y, z, stack);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (source.isFireDamage())
			return false;
		else
			return super.attackEntityFrom(source, amount);
	}
}
