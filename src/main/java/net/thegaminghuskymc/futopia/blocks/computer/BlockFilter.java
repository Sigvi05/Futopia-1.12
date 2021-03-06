package net.thegaminghuskymc.futopia.blocks.computer;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.client.gui.GuiHandler;
import net.thegaminghuskymc.futopia.utils.BlockNames;

public class BlockFilter extends BlockComputerBase {

	public BlockFilter() {
		super(BlockNames.FILTER_NAME);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		if (worldIn.isRemote & !playerIn.isSneaking()) {
			playerIn.openGui(Futopia.INSTANCE, GuiHandler.FILTER, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}

		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}

}
