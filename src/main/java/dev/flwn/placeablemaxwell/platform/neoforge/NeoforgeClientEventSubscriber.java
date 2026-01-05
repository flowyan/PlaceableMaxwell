package dev.flwn.placeablemaxwell.platform.neoforge;

//? neoforge {

import dev.flwn.placeablemaxwell.MaxwellMod;
import dev.flwn.placeablemaxwell.common.CheckHoliday;
//? if >1.21.3
import dev.flwn.placeablemaxwell.platform.neoforge.item.HolidayRecord;
//? if <=1.21.3
//import dev.flwn.placeablemaxwell.platform.neoforge.item.ModItems;
//? if <=1.21.10 {
/*import net.minecraft.resources.ResourceLocation;
 *///?} else {
import net.minecraft.resources.Identifier;
//?}
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.IExtensionPoint;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
//? if >1.21.3 {
import net.neoforged.neoforge.client.event.RegisterConditionalItemModelPropertyEvent;
import net.neoforged.neoforge.client.event.RegisterSelectItemModelPropertyEvent;
//?}
//? if <=1.21.3 {
/*import net.minecraft.client.renderer.item.ItemProperties;
 *///?}
//? if >1.20.6
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
//? if <=1.20.6
//import dev.flwn.placeablemaxwell.common.ConfigScreen;

@EventBusSubscriber(
		modid = MaxwellMod.MOD_ID,
		value = Dist.CLIENT
		//? if <1.21.3 && !=1.21.1
		//,bus = EventBusSubscriber.Bus.MOD
)
public class NeoforgeClientEventSubscriber {
	@SubscribeEvent
	public static void onClientSetup(final FMLClientSetupEvent event) {
		MaxwellMod.onInitializeClient();
		// This is where holiday item properties are handled for versions <= 1.21.3

		//? if <=1.21.3 {
		/*event.enqueueWork(() -> {
			//? if >1.20.6
			var xmasId = ResourceLocation.fromNamespaceAndPath(MaxwellMod.MOD_ID, "xmas");
			//? if <=1.20.6
			//var xmasId = new ResourceLocation(MaxwellMod.MOD_ID, "xmas");
			ItemProperties.register(ModItems.MAXWELL_BLOCK.get(), xmasId, (stack, level, entity, seed) -> CheckHoliday.isXmas() ? 1.0f : 0.0f);
			ItemProperties.register(ModItems.MARS_BLOCK.get(), xmasId, (stack, level, entity, seed) -> CheckHoliday.isXmas() ? 1.0f : 0.0f);
			ItemProperties.register(ModItems.VALENOK_BLOCK.get(), xmasId, (stack, level, entity, seed) -> CheckHoliday.isXmas() ? 1.0f : 0.0f);
			ItemProperties.register(ModItems.VASILISA_BLOCK.get(), xmasId, (stack, level, entity, seed) -> CheckHoliday.isXmas() ? 1.0f : 0.0f);
			ItemProperties.register(ModItems.POOMBA_BLOCK.get(), xmasId, (stack, level, entity, seed) -> CheckHoliday.isXmas() ? 1.0f : 0.0f);
		});
		*///?}

		ModContainer modContainer = ModList.get()
				.getModContainerById(MaxwellMod.MOD_ID)
				.orElseThrow();

		// Config screen setup
		//? if >1.20.6
		modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
		//? if <=1.20.6
		//modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigScreen::new);
	}

	//? if >1.21.3 {
	@SubscribeEvent
	public static void registerSelectProperties(RegisterSelectItemModelPropertyEvent event) {
		//? if <=1.21.10 {
		/*var identifier = ResourceLocation.fromNamespaceAndPath(MaxwellMod.MOD_ID, "holiday");
		 *///?} else {
		var identifier = Identifier.fromNamespaceAndPath(MaxwellMod.MOD_ID, "holiday");
		//?}
		event.register(identifier, HolidayRecord.TYPE);
	}
	//?}
}
//?}
