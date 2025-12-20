package dev.flwn.placeablemaxwell.platform.neoforge;

import java.time.LocalDate;

public class CheckHoliday {

	// Returns true if it is currently the Christmas holiday period (december to january 8)
	public static boolean isXmas() {
		if (Config.forceHoliday == Config.MaxwellHoliday.XMAS) return true;
		if (!Config.holidayFeaturesEnabled) return false;

		LocalDate date = LocalDate.now();
		int month = date.getMonthValue();
		int day = date.getDayOfMonth();

		return (month == 12) || (month == 1 && day <= 8);
	}

	// Returns true if it is currently Halloween period (october)
	public static boolean isHalloween() {
		// Halloween feature not implemented yet
		return false;
	}

	public static Config.MaxwellHoliday getCurrentHoliday() {
		if (isXmas()) {
			return Config.MaxwellHoliday.XMAS;
		}
		// else if (isHalloween()) {
		// 	return Config.MaxwellHoliday.HALLOWEEN;
		// }
		else {
			return Config.MaxwellHoliday.NONE;
		}
	}
}
