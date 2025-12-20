package dev.flwn.placeablemaxwell.platform.neoforge.item;


import dev.flwn.placeablemaxwell.MaxwellMod;
import dev.flwn.placeablemaxwell.platform.neoforge.block.ModBlocks;
import dev.flwn.placeablemaxwell.platform.neoforge.block.custom.MaxwellBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
//? if <1.21.10 {
/*import net.minecraft.resources.ResourceLocation;
*///?} else {
import net.minecraft.resources.Identifier;
//?}
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModItems {
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MaxwellMod.MOD_ID);

	public static final DeferredItem<BlockItem> MAXWELL_BLOCK = registerCatBlockItem("maxwell", ModBlocks.MAXWELL_BLOCK);
	public static final DeferredItem<BlockItem> MARS_BLOCK = registerCatBlockItem("mars", ModBlocks.MARS_BLOCK);
	public static final DeferredItem<BlockItem> VALENOK_BLOCK = registerCatBlockItem("valenok", ModBlocks.VALENOK_BLOCK);
	public static final DeferredItem<BlockItem> VASILISA_BLOCK = registerCatBlockItem("vasilisa", ModBlocks.VASILISA_BLOCK);
	public static final DeferredItem<BlockItem> POOMBA_BLOCK = registerCatBlockItem("poomba", ModBlocks.POOMBA_BLOCK);

	public static DeferredItem<BlockItem> registerCatBlockItem(String name, Supplier<MaxwellBlock> block) {

		//? if >=1.21.10 {
		return ITEMS.registerSimpleBlockItem(name, block, props -> baseCatProperties(name));
		//?}

		//? if <1.21.10 {
		/*return ITEMS.registerSimpleBlockItem(name, block, baseCatProperties(name));
		 *///?}
	}

	public static Item.Properties baseCatProperties(String name) {
		//? if <1.21.11 {
		/*var identifier = ResourceLocation.fromNamespaceAndPath(MaxwellMod.MOD_ID, name);
		 *///?} else {
		var identifier = Identifier.fromNamespaceAndPath(MaxwellMod.MOD_ID, name);
		//?}

		return new Item.Properties()
				.setId(ResourceKey.create(Registries.ITEM, identifier));
	}

	public static void register(IEventBus bus) {
		ITEMS.register(bus);
	}
}
