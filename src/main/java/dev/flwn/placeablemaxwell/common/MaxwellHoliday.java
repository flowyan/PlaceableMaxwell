package dev.flwn.placeablemaxwell.common;

//? if <=1.20.6
//import net.minecraft.util.OptionEnum;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum MaxwellHoliday implements StringRepresentable
		//? if <=1.20.6
		//,OptionEnum
{
	NONE,
	//HALLOWEEN,
	XMAS;

	@NotNull
	@Override
	public String getSerializedName() {
		return this.name().toLowerCase();
	}

	//? <=1.20.6 {
	/*@Override
	public int getId() {
		return this.ordinal();
	}

	@NotNull
	@Override
	public String getKey() {
		return this.getSerializedName().toUpperCase();
	}
	*///? }
}
