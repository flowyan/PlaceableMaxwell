package dev.flwn.placeablemaxwell.platform.neoforge.item;
//? neoforge && >1.21.3 {
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import dev.flwn.placeablemaxwell.common.CheckHoliday;
import dev.flwn.placeablemaxwell.common.MaxwellHoliday;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.select.SelectItemModelProperty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public record HolidayRecord() implements SelectItemModelProperty<MaxwellHoliday> {
	public static final Codec<MaxwellHoliday> HOLIDAY_CODEC = Codec.STRING.xmap(
			s -> switch (s) {
				case "XMAS" -> MaxwellHoliday.XMAS;
				default -> MaxwellHoliday.NONE;
			},
			holiday -> switch (holiday) {
				case XMAS -> "XMAS";
				case NONE -> "NONE";
			}
	);
	// The object to register that contains the relevant codecs
	public static final SelectItemModelProperty.Type<HolidayRecord, MaxwellHoliday> TYPE =
			SelectItemModelProperty.Type.create(MapCodec.unit(new HolidayRecord()), HOLIDAY_CODEC);

	@Override
	public MaxwellHoliday get(@NotNull ItemStack stack, @Nullable ClientLevel level, @Nullable LivingEntity entity, int seed, @NotNull ItemDisplayContext context) {
		return CheckHoliday.getCurrentHoliday();
	}

	//? if >1.21.4 {
	@NotNull
	@Override
	public Codec<MaxwellHoliday> valueCodec() {
		return HOLIDAY_CODEC;
	}
	//?}

	@NotNull
	@Override
	public SelectItemModelProperty.Type<HolidayRecord, MaxwellHoliday> type() {
		return TYPE;
	}
}
//? }
