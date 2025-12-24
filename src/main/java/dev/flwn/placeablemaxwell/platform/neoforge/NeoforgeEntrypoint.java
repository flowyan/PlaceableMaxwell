package dev.flwn.placeablemaxwell.platform.neoforge;


//? neoforge {

import dev.flwn.placeablemaxwell.MaxwellMod;
import dev.flwn.placeablemaxwell.common.Config;

import dev.flwn.placeablemaxwell.platform.neoforge.block.ModBlocks;
import dev.flwn.placeablemaxwell.platform.neoforge.item.ModItems;
import dev.flwn.placeablemaxwell.platform.neoforge.tabs.ModTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
//? if >1.20.6
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
//? if <=1.20.6
//import dev.flwn.placeablemaxwell.common.ConfigScreen;

@Mod(MaxwellMod.MOD_ID)
public class NeoforgeEntrypoint {

	public NeoforgeEntrypoint(IEventBus modEventBus, ModContainer modContainer) {
		ModTabs.register(modEventBus);
		ModItems.register(modEventBus);
		ModBlocks.register(modEventBus);

		modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

		//? if >1.20.6
		modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
		//? if <=1.20.6
		//modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigScreen::new);

		MaxwellMod.onInitialize();
	}
}
//?}
