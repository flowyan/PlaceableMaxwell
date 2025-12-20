package dev.flwn.placeablemaxwell.platform.neoforge.tabs;

import dev.flwn.placeablemaxwell.MaxwellMod;
import dev.flwn.placeablemaxwell.platform.neoforge.block.ModBlocks;
import dev.flwn.placeablemaxwell.platform.neoforge.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MaxwellMod.MOD_ID);

	public static final Supplier<CreativeModeTab> MAXWELL_TAB = CREATIVE_MODE_TABS.register("maxwell_tab", () -> CreativeModeTab.builder()
			//Set the title of the tab. Don't forget to add a translation!
			.title(Component.translatable("category." + MaxwellMod.MOD_ID + ".placeablemaxwell_tab"))
			//Set the icon of the tab.
			.icon(() -> new ItemStack(ModItems.MAXWELL_BLOCK.get()))
			//Add your items to the tab.
			.displayItems((params, output) -> {
				// Add all blocks
				for (var block : ModBlocks.BLOCKS.getEntries()) {
					output.accept(block.get().asItem());
				}
				// Add all items
				for (var item : ModItems.ITEMS.getEntries()) {
					output.accept(item.get());
				}
			})
			.build()
	);

	public static void register(IEventBus bus) {
		CREATIVE_MODE_TABS.register(bus);
	}
}
