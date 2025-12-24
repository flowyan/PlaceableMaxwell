package dev.flwn.placeablemaxwell.platform.forge;

//? forge {

/*import dev.flwn.placeablemaxwell.MaxwellMod;
import dev.flwn.placeablemaxwell.common.Config;
import dev.flwn.placeablemaxwell.platform.neoforge.block.ModBlocks;
import dev.flwn.placeablemaxwell.platform.neoforge.item.ModItems;
import dev.flwn.placeablemaxwell.platform.neoforge.tabs.ModTabs;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@SuppressWarnings("removal")
@Mod(MaxwellMod.MOD_ID)
public class ForgeEntrypoint {

	public ForgeEntrypoint() {
		var modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModTabs.register(modEventBus);
		ModItems.register(modEventBus);
		ModBlocks.register(modEventBus);

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);

		MaxwellMod.onInitialize();
	}
}
*///?}
