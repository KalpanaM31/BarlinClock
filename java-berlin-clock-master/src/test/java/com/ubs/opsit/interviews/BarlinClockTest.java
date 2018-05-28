package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.apache.commons.lang.text.StrBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ubs.opsit.interviews.Impl.BarlinClockTimeConvertor;
import com.ubs.opsit.interviews.utils.ValidateTimeUtils;

public class BarlinClockTest {

	TimeConverter timeConverter = new BarlinClockTimeConvertor();
	ValidateTimeUtils validator = new ValidateTimeUtils();

	private String[] inputValidData;
	private String[] inputInValidData;

	@Before
	public void initData() {
		inputValidData = new String[] { "01:00:15", "02:00:30", "13:00:45", "1:00:50", "2:00:01", "13:01:10",
				"23:59:39", "15:00:05", "00:00:00", "0:00:00" };
		inputInValidData = new String[] { "25:00:00", "12:60:15", "0:0", "13:1:62", "101:45" };
	}
	
	// Berlin Clock it should "result in correct seconds, hours and minutes"

	@Test
	public void testBerlinClockShouldResultInCorrectSecondsHoursAndMinutes() {

		assertEquals(getExpectedString("Y", "RROO", "RROO", "YYRYYROOOOO", "OOOO"),
				timeConverter.convertTime("12:30:00"));
		assertEquals(getExpectedString("O", "RROO", "RRRO", "YYROOOOOOOO", "YYOO"),
				timeConverter.convertTime("13:17:01"));
		assertEquals(getExpectedString("O", "RRRR", "RRRO", "YYRYYRYYRYY", "YYYY"),
				timeConverter.convertTime("23:59:59"));
		assertEquals(getExpectedString("Y", "RRRR", "RRRR", "OOOOOOOOOOO", "OOOO"),
				timeConverter.convertTime("24:00:00"));

	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldCatchIllegalArgument() throws ParseException {
		timeConverter.convertTime(new String("25:59:40"));
		timeConverter.convertTime(new String("23:65:40"));
		timeConverter.convertTime(new String("01:59:66"));
		// thrown.expect(IllegalArgumentException.class);
	}
	
	
	@Test
	public void testValidTime24Hours() {
		for (int i = 0; i < inputValidData.length; i++) {
			Assert.assertEquals(true, validator.validate(inputValidData[i]));
		}
	}

	@Test
	public void InValidTime24HoursTest() {
		for (int i = 0; i < inputInValidData.length; i++) {
			Assert.assertEquals(false, validator.validate(inputInValidData[i]));
		}
	}	
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidTimeWithNull() {
		timeConverter.convertTime(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidTimeWithEmptyString() {
		timeConverter.convertTime("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldCatchInvalidInput() throws ParseException {
		timeConverter.convertTime(new String("dummyTime"));
		// thrown.expect(IllegalArgumentException.class);
	}
	
	private String getExpectedString(String second, String hour1, String hour2, String min1, String min2) {
		return new StrBuilder()
				.appendWithSeparators(new String[] { second, hour1, hour2, min1, min2 }, System.lineSeparator())
				.toString();
	}
}
