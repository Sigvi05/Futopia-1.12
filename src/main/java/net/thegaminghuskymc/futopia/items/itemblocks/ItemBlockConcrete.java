package net.thegaminghuskymc.futopia.items.itemblocks;

import cofh.core.block.ItemBlockCore;
import cofh.core.util.helpers.ItemHelper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.blocks.decorativeBlocks.concrete.BlockConcrete;

public class ItemBlockConcrete extends ItemBlockCore {

	public ItemBlockConcrete(Block block) {

		super(block);
		setHasSubtypes(true);
		setMaxDamage(0);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {

		return "tile.concrete." + BlockConcrete.Type.byMetadata(ItemHelper.getItemDamage(stack)).getName() + ".name";
	}

}