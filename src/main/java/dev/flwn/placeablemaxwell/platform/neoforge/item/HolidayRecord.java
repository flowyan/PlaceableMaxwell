package dev.flwn.placeablemaxwell.platform.neoforge.item;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import dev.flwn.placeablemaxwell.platform.neoforge.CheckHoliday;
import dev.flwn.placeablemaxwell.platform.neoforge.Config;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.select.SelectItemModelProperty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public record HolidayRecord() implements SelectItemModelProperty<Config.MaxwellHoliday> {
	public static final Codec<Config.MaxwellHoliday> HOLIDAY_CODEC = Codec.STRING.xmap(
			s -> switch (s) {
				case "XMAS" -> Config.MaxwellHoliday.XMAS;
				default -> Config.MaxwellHoliday.NONE;
			},
			holiday -> switch (holiday) {
				case XMAS -> "XMAS";
				case NONE -> "NONE";
			}
	);
	// The object to register that contains the relevant codecs
	public static final SelectItemModelProperty.Type<HolidayRecord, Config.MaxwellHoliday> TYPE =
			SelectItemModelProperty.Type.create(MapCodec.unit(new HolidayRecord()), HOLIDAY_CODEC);

	@Override
	public Config.MaxwellHoliday get(@NotNull ItemStack stack, @Nullable ClientLevel level, @Nullable LivingEntity entity, int seed, @NotNull ItemDisplayContext context) {
		return CheckHoliday.getCurrentHoliday();
	}

	@NotNull
	@Override
	public Codec<Config.MaxwellHoliday> valueCodec() {
		return HOLIDAY_CODEC;
	}

	@NotNull
	@Override
	public SelectItemModelProperty.Type<HolidayRecord, Config.MaxwellHoliday> type() {
		return TYPE;
	}
}
