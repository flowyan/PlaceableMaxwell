package dev.flwn.placeablemaxwell.platform.neoforge.block;

import dev.flwn.placeablemaxwell.MaxwellMod;
import dev.flwn.placeablemaxwell.platform.neoforge.block.custom.MaxwellBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
//? if <1.21.10
//import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

//? forge {
/*import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
*///?}

//? neoforge {
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
//?}

public class ModBlocks {
	//? >1.20.1
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MaxwellMod.MOD_ID);
	//? <=1.20.1
	//public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, MaxwellMod.MOD_ID);

	//? if >1.20.1 {
	public static final DeferredBlock<MaxwellBlock> MAXWELL_BLOCK = registerCatBlock("maxwell");
	public static final DeferredBlock<MaxwellBlock> MARS_BLOCK = registerCatBlock("mars");
	public static final DeferredBlock<MaxwellBlock> VALENOK_BLOCK = registerCatBlock("valenok");
	public static final DeferredBlock<MaxwellBlock> VASILISA_BLOCK = registerCatBlock("vasilisa");
	public static final DeferredBlock<MaxwellBlock> POOMBA_BLOCK = registerCatBlock("poomba");
	//?} else {
	/*public static final RegistryObject<MaxwellBlock> MAXWELL_BLOCK = registerCatBlock("maxwell");
	public static final RegistryObject<MaxwellBlock> MARS_BLOCK = registerCatBlock("mars");
	public static final RegistryObject<MaxwellBlock> VALENOK_BLOCK = registerCatBlock("valenok");
	public static final RegistryObject<MaxwellBlock> VASILISA_BLOCK = registerCatBlock("vasilisa");
	public static final RegistryObject<MaxwellBlock> POOMBA_BLOCK = registerCatBlock("poomba");
	*///?}

	//? >1.20.1
	public static DeferredBlock<MaxwellBlock> registerCatBlock(String name) {
	//? <=1.20.1
	//public static RegistryObject<MaxwellBlock> registerCatBlock(String name) {
		var strength = 0.8f;
		var soundType = SoundType.WOOL;

		//? if >=1.21.10 {
		return BLOCKS.registerBlock(name, MaxwellBlock::new, properties -> properties
				.strength(strength)
				.sound(soundType)
				.noOcclusion()
		);
		//?}

		//? if <1.21.10 && !=1.20.1 {
		/*return BLOCKS.registerBlock(name, MaxwellBlock::new, BlockBehaviour.Properties.of()
				//? if >1.21.1
				.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MaxwellMod.MOD_ID, name)))
				.strength(strength)
				.sound(soundType)
				.noOcclusion()
		);
		*///?}

		//? if =1.20.1 {
		/*return BLOCKS.register(name, () -> new MaxwellBlock(BlockBehaviour.Properties.of()
				.strength(strength)
				.sound(soundType)
				.noOcclusion()));
		*///?}
	}

	public static void register(IEventBus bus) {
		BLOCKS.register(bus);
	}

}
