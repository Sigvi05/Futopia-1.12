package net.thegaminghuskymc.futopia.blocks.computer;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.thegaminghuskymc.futopia.utils.BlockNames;

public class BlockMonitor extends BlockComputerBase {
	
	public static EnumFacing facing;

    public BlockMonitor() {
        super(BlockNames.BLOCKMONITOR_NAME);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
    	switch(state.getValue(FACING)){
			case EAST:
				return new AxisAlignedBB(0.87, 0.88, 0.44, 0.12, 2f/16, 0.56f);
			case NORTH:
				return new AxisAlignedBB(0.87, 0.88, 0.44, 0.12, 2f/16, 0.56);
			case SOUTH:
				return new AxisAlignedBB(0.87, 0.88, 0.44, 0.12, 2f/16, 0.56);
			case WEST:
				return new AxisAlignedBB(0.87, 0.88, 0.44, 0.12, 2f/16, 0.56);
			default:
				return new AxisAlignedBB(0, 0, 0, 1, 1, 1);
    	}
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
    	switch(blockState.getValue(FACING)){
			case EAST:
				return new AxisAlignedBB(0.87f, 0.88f, 0.44f, 0.12f, 2f/16f, 0.56f);
			case NORTH:
				return new AxisAlignedBB(0.87f, 0.88f, 0.44f, 0.12f, 2f/16f, 0.56f);
			case SOUTH:
				return new AxisAlignedBB(0.87f, 0.88f, 0.44f, 0.12f, 2f/16f, 0.56f);
			case WEST:
				return new AxisAlignedBB(0.87f, 0.88f, 0.44f, 0.12f, 2f/16f, 0.56f);
			default:
				return new AxisAlignedBB(0, 0, 0, 1, 1, 1);
    	}
    }

}
