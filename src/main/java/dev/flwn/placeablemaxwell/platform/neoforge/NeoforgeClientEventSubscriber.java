package dev.flwn.placeablemaxwell.platform.neoforge;

//? neoforge {

import dev.flwn.placeablemaxwell.MaxwellMod;
import dev.flwn.placeablemaxwell.platform.neoforge.item.HolidayRecord;
//? if <1.21.10 {
/*import net.minecraft.resources.ResourceLocation;
*///?} else {
import net.minecraft.resources.Identifier;
//?}
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterConditionalItemModelPropertyEvent;
import net.neoforged.neoforge.client.event.RegisterSelectItemModelPropertyEvent;

@EventBusSubscriber(modid = MaxwellMod.MOD_ID, value = Dist.CLIENT)
public class NeoforgeClientEventSubscriber {
	@SubscribeEvent
	public static void onClientSetup(final FMLClientSetupEvent event) {
		MaxwellMod.onInitializeClient();
	}

	@SubscribeEvent
	public static void registerSelectProperties(RegisterSelectItemModelPropertyEvent event) {
		//? if <1.21.10 {
		/*var identifier = ResourceLocation.fromNamespaceAndPath(MaxwellMod.MOD_ID, "holiday");
		*///?} else {
		var identifier = Identifier.fromNamespaceAndPath(MaxwellMod.MOD_ID, "holiday");
		//?}
		event.register(identifier, HolidayRecord.TYPE);
	}
}
//?}
