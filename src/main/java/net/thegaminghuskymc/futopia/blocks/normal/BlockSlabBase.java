package net.thegaminghuskymc.futopia.blocks.normal;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;

public class BlockSlabBase extends BlockSlab {

	public boolean isOpaqueCube = true;
	public boolean isFullCube = true;

	public BlockRenderLayer layer = BlockRenderLayer.SOLID;

	public BlockSlabBase(Block block, String name) {
		super(block.getDefaultState().getMaterial());
		setUnlocalizedName(name);
		setRegistryName(Refs.MODID, name);
		setCreativeTab(FTCreativeTabs.main);
		this.useNeighborBrightness = true;
	}

	public BlockSlabBase setIsOpaqueCube(boolean b) {
		isOpaqueCube = b;
		return this;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return isOpaqueCube;
	}

	public BlockSlabBase setIsFullCube(boolean b) {
		isFullCube = b;
		return this;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return isFullCube;
	}

	public BlockSlabBase setHarvestProperties(String toolType, int level) {
		super.setHarvestLevel(toolType, level);
		return this;
	}

	@SideOnly(Side.CLIENT)
	protected static boolean isHalfSlab(IBlockState state) {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0,
				new ModelResourceLocation(getRegistryName().toString()));
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		IBlockState iblockstate = this.getDefaultState();
		if (!this.isDouble())
			iblockstate = iblockstate.withProperty(HALF, (meta) == 0 ? EnumBlockHalf.BOTTOM : EnumBlockHalf.TOP);

		return iblockstate;
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(HALF) == EnumBlockHalf.BOTTOM ? 0 : 1;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, HALF);
	}

	@Override
	public boolean isDouble() {
		return false;
	}

	@Override
	public String getUnlocalizedName(int meta) {
		return null;
	}

	@Override
	public IProperty<?> getVariantProperty() {
		return HALF;
	}

	@Override
	public Comparable<?> getTypeForItem(ItemStack stack) {
		return 0;
	}
}