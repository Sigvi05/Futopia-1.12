package net.thegaminghuskymc.futopia.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.thegaminghuskymc.futopia.client.container.ContainerProjectTable;

public class GuiHandler implements IGuiHandler {
	
	public static final int GUIID_BASE = 0;
	public static final int PROJECT_TABLE = 1;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == PROJECT_TABLE) {
            return new ContainerProjectTable(player.inventory);
        }
        return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == PROJECT_TABLE){
        	return new GuiProjectTable(player.inventory);
        }
        return null;
	}
	
	

}
