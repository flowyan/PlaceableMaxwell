package dev.flwn.placeablemaxwell.common;

import com.mojang.serialization.Codec;
import net.minecraft.client.OptionInstance;
import net.minecraft.network.chat.Component;

//? neoforge {
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
//? }
//? forge {
/*import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
*///? }

import java.util.Arrays;

import static dev.flwn.placeablemaxwell.common.Config.forceHoliday;
import static dev.flwn.placeablemaxwell.common.Config.holidayFeaturesEnabled;

//? <=1.20.6 {
/*@OnlyIn(Dist.CLIENT)
public final class ClientConfigOptions {
	public static OptionInstance<?>[] getOptions() {
		return new OptionInstance<?>[]{
				OptionInstance.createBoolean(
						"placeablemaxwell.configuration.holidayFeaturesEnabled",
						OptionInstance.cachedConstantTooltip(Component.translatable("placeablemaxwell.configuration.holidayFeaturesEnabled.tooltip")),
						holidayFeaturesEnabled,
						Config::setHolidayFeaturesEnabled
				),
				new OptionInstance<>(
						"placeablemaxwell.configuration.forceHoliday",
						OptionInstance.cachedConstantTooltip(Component.translatable("placeablemaxwell.configuration.forceHoliday.tooltip")),
						OptionInstance.forOptionEnum(),
						new OptionInstance.Enum<>(
								Arrays.asList(MaxwellHoliday.values()),
								Codec.INT.xmap(
										id -> MaxwellHoliday.values()[id],
										MaxwellHoliday::getId
								)
						),
						forceHoliday,
						Config::setForceHoliday
				)
		};
	}
}
*///?}
