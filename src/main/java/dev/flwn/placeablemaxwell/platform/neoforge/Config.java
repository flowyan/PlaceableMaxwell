package dev.flwn.placeablemaxwell.platform.neoforge;

import net.minecraft.util.StringRepresentable;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber
public class Config {
	private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

	private static final ModConfigSpec.BooleanValue HOLIDAY_FEATURES_ENABLED = BUILDER
			.comment("Enable holiday features")
			.define("holidayFeaturesEnabled", true);

	public enum MaxwellHoliday implements StringRepresentable {
		NONE,
		//		HALLOWEEN,
		XMAS;

		@NotNull
		@Override
		public String getSerializedName() {
			return this.name().toLowerCase();
		}
	}

	private static final ModConfigSpec.EnumValue<MaxwellHoliday> FORCE_HOLIDAY = BUILDER
			.comment("Force a specific holiday (NONE to disable)")
			.defineEnum("forceHoliday", MaxwellHoliday.NONE);

	static final ModConfigSpec SPEC = Config.BUILDER.build();

	public static boolean holidayFeaturesEnabled;
	public static MaxwellHoliday forceHoliday;

	@SubscribeEvent
	static void onLoad(final ModConfigEvent event) {
		holidayFeaturesEnabled = HOLIDAY_FEATURES_ENABLED.get();
		forceHoliday = FORCE_HOLIDAY.get();
	}
}
