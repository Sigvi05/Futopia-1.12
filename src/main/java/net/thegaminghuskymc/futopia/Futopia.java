package net.thegaminghuskymc.futopia;

import static net.thegaminghuskymc.futopia.Refs.CSIDE;
import static net.thegaminghuskymc.futopia.Refs.SSIDE;

import java.util.logging.Logger;

import keri.ninetaillib.lib.config.IModConfig;
import keri.ninetaillib.lib.config.ModConfig;
import keri.ninetaillib.lib.logger.IModLogger;
import keri.ninetaillib.lib.logger.ModLogger;
import keri.ninetaillib.lib.mod.ModHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thegaminghuskymc.futopia.client.gui.GuiHandler;
import net.thegaminghuskymc.futopia.init.FTBlocks;
import net.thegaminghuskymc.futopia.init.FTItems;
import net.thegaminghuskymc.futopia.init.FutopiaOreDictionary;
import net.thegaminghuskymc.futopia.init.OtherBlocks;
import net.thegaminghuskymc.futopia.init.Recipies;
import net.thegaminghuskymc.futopia.integration.FutopiaIntegrations;
import net.thegaminghuskymc.futopia.proxy.IFutopiaProxy;
import net.thegaminghuskymc.futopia.world.gen.OreGen;

@Mod(modid = Refs.MODID, name = Refs.NAME, version = Refs.VERSION, dependencies = Refs.DEPS, acceptedMinecraftVersions = Refs.ACC_MC, guiFactory = "net.thegaminghuskymc.futopia.client.gui.FutopiaGuiFactory")
public class Futopia {

	@Mod.Instance(value = Refs.MODID)
	public static Futopia INSTANCE;
	public static ModHandler HANDLER;
	public static final GuiHandler GUI_HANDLER = new GuiHandler();
	public static Logger LOGGER = Logger.getLogger(Refs.NAME);

	@SidedProxy(clientSide = CSIDE, serverSide = SSIDE)
	public static IFutopiaProxy proxy;
	@ModLogger
	public static IModLogger logger;
	@ModConfig
	public static IModConfig config;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		HANDLER = new ModHandler(INSTANCE);
		HANDLER.handlePreInit(event);

		OtherBlocks.preInit();

		proxy.preInit(event);

		FTBlocks.init();
		FTItems.init();
		FTBlocks.register();
		FTItems.register();

		FutopiaIntegrations.preInit();

		proxy.registerRenders();
		proxy.registerTileEntities();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		HANDLER.handleInit(event);
		OtherBlocks.initialize();
		FutopiaOreDictionary.init();
		Recipies.init();
		GameRegistry.registerWorldGenerator(new OreGen(), 0);
		NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, GUI_HANDLER);
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		HANDLER.handlePostInit(event);
		OtherBlocks.postInit();
		proxy.postInit(event);
	}
}