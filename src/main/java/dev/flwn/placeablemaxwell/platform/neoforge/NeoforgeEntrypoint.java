package dev.flwn.placeablemaxwell.platform.neoforge;


//? neoforge {

import dev.flwn.placeablemaxwell.MaxwellMod;
import dev.flwn.placeablemaxwell.platform.neoforge.block.ModBlocks;
import dev.flwn.placeablemaxwell.platform.neoforge.item.ModItems;
import dev.flwn.placeablemaxwell.platform.neoforge.tabs.ModTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(MaxwellMod.MOD_ID)
public class NeoforgeEntrypoint {

	public NeoforgeEntrypoint(IEventBus modEventBus, ModContainer modContainer) {
		modEventBus.addListener(this::commonSetup);

		ModTabs.register(modEventBus);
		ModItems.register(modEventBus);
		ModBlocks.register(modEventBus);

		// Register ourselves for server and other game events we are interested in.
		// Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
		// Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
//		NeoForge.EVENT_BUS.register(this);

		modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
		modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);

		MaxwellMod.onInitialize();
	}

	private void commonSetup(final FMLCommonSetupEvent event) {
	}
}
//?}
