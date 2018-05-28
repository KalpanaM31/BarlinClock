package com.ubs.opsit.interviews;

import org.apache.commons.lang.StringUtils;

import com.ubs.opsit.interviews.constants.BerlinClockConstants;
import com.ubs.opsit.interviews.enums.Color;

public class BerlinClockLamp {

	public String getSecondsLamp(int second) {
		return second % 2 == 0 ? Color.YELLOW.toString() : Color.OFF.toString();
	}

	public String getTopHourLamps(int upperHourLamp) {
		return getOnOffLamps(BerlinClockConstants.HOUR_LAMP_COUNT, getTopNumberOfOnSigns(upperHourLamp));
	}

	public String getBottomHourLamps(int bottomHourLamp) {
		return getOnOffLamps(BerlinClockConstants.HOUR_LAMP_COUNT, bottomHourLamp % 5);
	}

	public String getTopMinutesLamps(int upperMinuteLamp) {
		return getOnOffLamps(BerlinClockConstants.MINUTES_LAMP_COUNT_TOP, getTopNumberOfOnSigns(upperMinuteLamp), Color.YELLOW.toString()).replaceAll("YYY",
				"YYR");
	}

	public String getBottomMinuteLamps(int numberOfLamps) {
		return getOnOffLamps(BerlinClockConstants.HOUR_LAMP_COUNT, numberOfLamps % BerlinClockConstants.MULTIPLE_OF_FIVE, Color.YELLOW.toString());
	}

	private int getTopNumberOfOnSigns(int numberOfLamps) {
		return (numberOfLamps - (numberOfLamps % BerlinClockConstants.MULTIPLE_OF_FIVE)) / BerlinClockConstants.MULTIPLE_OF_FIVE;
	}

	private String getOnOffLamps(int numberOfLamps, int onSigns) {
		return getOnOffLamps(numberOfLamps, onSigns, Color.RED.toString());
	}

	private String getOnOffLamps(int numberOfLamps, int numberOfOnLamps, String lampColor) {
		return StringUtils.repeat(lampColor, numberOfOnLamps)
				+ StringUtils.repeat(Color.OFF.toString(), numberOfLamps - numberOfOnLamps);
	}
}
