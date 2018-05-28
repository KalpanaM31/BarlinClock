package com.ubs.opsit.interviews.Impl;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.text.StrBuilder;

import com.ubs.opsit.interviews.BerlinClockLamp;
import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.utils.ValidateTimeUtils;

public class BarlinClockTimeConvertor implements TimeConverter {

	BerlinClockLamp berlinClockLamp = new BerlinClockLamp();
	ValidateTimeUtils validator = new ValidateTimeUtils();

	@Override
	public String convertTime(String aTime) {
		return getConvertedBerlinTime(aTime);
	}

	/**
	 * @param aTime
	 *            time string in HH:mm:ss format
	 */
	private String getConvertedBerlinTime(String aTime) {
		Validate.notNull(aTime, "Time.parse() `aTime` argument should not be null");
		validateTime(aTime);
		String[] time = aTime.split(":");
		int hours = Integer.parseInt(time[0]);
		int minutes = Integer.parseInt(time[1]);
		int seconds = Integer.parseInt(time[2]);
		validateTimeFormat(hours, minutes, seconds);
		return format(hours, minutes, seconds);
	}

	private void validateTime(String timeString) {
		Boolean isValidtime = validator.validate(timeString);
		if (!isValidtime) {
			throw new IllegalArgumentException();
		}

	}

	private void validateTimeFormat(int hour, int minutes, int seconds) {
		validator.validateRangeFromZeroUpTo(24, hour, "hour");
		validator.validateRangeFromZeroUntil(60, minutes, "minutes"); 
		validator.validateRangeFromZeroUntil(60, seconds, "seconds"); 

	}

	public String format(int hour, int minute, int second) throws NumberFormatException {
		return new StrBuilder().appendWithSeparators(new String[] { berlinClockLamp.getSecondsLamp(second),
				berlinClockLamp.getTopHourLamps(hour), berlinClockLamp.getBottomHourLamps(hour),
				berlinClockLamp.getTopMinutesLamps(minute), berlinClockLamp.getBottomMinuteLamps(minute) },
				System.lineSeparator()).toString();
	}
}
