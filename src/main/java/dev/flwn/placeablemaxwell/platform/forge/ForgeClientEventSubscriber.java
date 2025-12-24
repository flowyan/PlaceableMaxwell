package dev.flwn.placeablemaxwell.platform.forge;

//? forge {

/*import dev.flwn.placeablemaxwell.MaxwellMod;
import dev.flwn.placeablemaxwell.common.CheckHoliday;
import dev.flwn.placeablemaxwell.common.ConfigScreen;
import dev.flwn.placeablemaxwell.platform.neoforge.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@SuppressWarnings("removal")
@Mod.EventBusSubscriber(modid = MaxwellMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ForgeClientEventSubscriber {

	@SubscribeEvent
	public static void onClientSetup(final FMLClientSetupEvent event) {
		// Register the config screen
		ModLoadingContext.get().registerExtensionPoint(
				ConfigScreenHandler.ConfigScreenFactory.class,
				() -> new ConfigScreenHandler.ConfigScreenFactory((mc, prevScreen) -> new ConfigScreen(mc, prevScreen) {
				})
		);

		// This is where holiday item properties are handled
		event.enqueueWork(() -> {
			var xmasId = ResourceLocation.fromNamespaceAndPath(MaxwellMod.MOD_ID, "xmas");
			ItemProperties.register(ModItems.MAXWELL_BLOCK.get(), xmasId, (stack, level, entity, seed) -> CheckHoliday.isXmas() ? 1.0f : 0.0f);
			ItemProperties.register(ModItems.MARS_BLOCK.get(), xmasId, (stack, level, entity, seed) -> CheckHoliday.isXmas() ? 1.0f : 0.0f);
			ItemProperties.register(ModItems.VALENOK_BLOCK.get(), xmasId, (stack, level, entity, seed) -> CheckHoliday.isXmas() ? 1.0f : 0.0f);
			ItemProperties.register(ModItems.VASILISA_BLOCK.get(), xmasId, (stack, level, entity, seed) -> CheckHoliday.isXmas() ? 1.0f : 0.0f);
			ItemProperties.register(ModItems.POOMBA_BLOCK.get(), xmasId, (stack, level, entity, seed) -> CheckHoliday.isXmas() ? 1.0f : 0.0f);
		});

		MaxwellMod.onInitializeClient();
	}
}
*///?}
