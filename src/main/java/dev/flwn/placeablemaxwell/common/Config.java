package dev.flwn.placeablemaxwell.common;


//? if <=1.20.6 {

/*import com.mojang.serialization.Codec;
import net.minecraft.network.chat.Component;
import net.minecraft.util.OptionEnum;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;
*///? }

//? forge {
/*import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.EnumValue;
*///? }

import java.util.Arrays;

//? neoforge {

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.BooleanValue;
import net.neoforged.neoforge.common.ModConfigSpec.EnumValue;

//? if >1.21.2 || 1.21.1
@EventBusSubscriber
//? if <=1.21.2 && !=1.21.1
//@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
//? }
//? forge
//@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
	//? neoforge
	private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	//? forge
	//private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

	private static final BooleanValue HOLIDAY_FEATURES_ENABLED = BUILDER
			.comment("Enable holiday features.")
			.define("holidayFeaturesEnabled", true);

	private static final EnumValue<MaxwellHoliday> FORCE_HOLIDAY = BUILDER
			.comment("Force a specific holiday. Set to NONE to disable.")
			.defineEnum("forceHoliday", MaxwellHoliday.NONE);

	//? neoforge
	public static final ModConfigSpec SPEC = Config.BUILDER.build();
	//? forge
	//public static final ForgeConfigSpec SPEC = Config.BUILDER.build();

	public static boolean holidayFeaturesEnabled;
	public static MaxwellHoliday forceHoliday;

	public static void setHolidayFeaturesEnabled(boolean value) {
		HOLIDAY_FEATURES_ENABLED.set(value);
		holidayFeaturesEnabled = value;
	}

	public static void setForceHoliday(MaxwellHoliday value) {
		FORCE_HOLIDAY.set(value);
		forceHoliday = value;
	}

	@SubscribeEvent
	static void onLoad(final ModConfigEvent event) {
		holidayFeaturesEnabled = HOLIDAY_FEATURES_ENABLED.get();
		forceHoliday = FORCE_HOLIDAY.get();
	}
}
