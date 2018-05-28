package com.ubs.opsit.interviews;

import org.junit.Assert;
import org.junit.Test;

import com.ubs.opsit.interviews.constants.BerlinClockConstants;
import com.ubs.opsit.interviews.enums.Color;

public class BerlinClockLampTest {

	BerlinClockLamp berlinClockLamp = new BerlinClockLamp();

	// Yellow lamp should blink on/off every two seconds
	@Test
	public void testYellowLampShouldBlinkOnOffEveryTwoSeconds() {
		Assert.assertEquals(Color.YELLOW.toString(), berlinClockLamp.getSecondsLamp(0));
		Assert.assertEquals(Color.OFF.toString(), berlinClockLamp.getSecondsLamp(1));

	}

	// Top hours lamp row should have 4 lamps
	@Test
	public void testTopHoursShouldHave4Lamps() {
		Assert.assertEquals(BerlinClockConstants.HOUR_LAMP_COUNT, berlinClockLamp.getTopHourLamps(5).length());
	}

	// Bottom hours lamp row should have 4 lamps
	@Test
	public void testBottomHoursShouldHave4Lamps() {
		Assert.assertEquals(BerlinClockConstants.HOUR_LAMP_COUNT, berlinClockLamp.getBottomHourLamps(3).length());
	}

	// Top hours lamp should light a red lamp for every 5 hours
	@Test
	public void testTopHoursShouldLightRedLampForEvery5Hours()
	{
	    Assert.assertEquals("OOOO", berlinClockLamp.getTopHourLamps(0));
        Assert.assertEquals("RROO", berlinClockLamp.getTopHourLamps(13));
        Assert.assertEquals("RRRR", berlinClockLamp.getTopHourLamps(23));
        Assert.assertEquals("RRRR", berlinClockLamp.getTopHourLamps(24));
	}

	 // Bottom hours should light a red lamp for every hour left from top hours
    @Test
    public void testBottomHoursShouldLightRedLampForEveryHourLeftFromTopHours() {
        Assert.assertEquals("OOOO", berlinClockLamp.getBottomHourLamps(0));
        Assert.assertEquals("RRRO", berlinClockLamp.getBottomHourLamps(13));
        Assert.assertEquals("RRRO", berlinClockLamp.getBottomHourLamps(23));
        Assert.assertEquals("RRRR", berlinClockLamp.getBottomHourLamps(24));
    }
    
 // Top minutes should have 11 lamps
    @Test
    public void testTopMinutesShouldHave11Lamps() {
        Assert.assertEquals(11, berlinClockLamp.getTopMinutesLamps(59).length());
    }
    
    // Top minutes lamp should have 3rd, 6th and 9th lamps in red to indicate first quarter, half and last quarter
    @Test
    public void testTopMinutesShouldHave3rd6thAnd9thLampsInRedToIndicateFirstQuarterHalfAndLastQuarter() {
        String minutesLamp = berlinClockLamp.getTopMinutesLamps(54);
        Assert.assertEquals("R", minutesLamp.substring(2, 3));
        Assert.assertEquals("R", minutesLamp.substring(5, 6));
        Assert.assertEquals("R", minutesLamp.substring(8, 9));
    }
    
    // Top minutes lamps should light a yellow lamp for every 5 minutes unless it's first quarter, half or last quarter
    @Test
    public void testTopMinutesShouldLightYellowLampForEvery5MinutesUnlessItIsFirstQuarterHalfOrLastQuarter() {
        Assert.assertEquals("OOOOOOOOOOO", berlinClockLamp.getTopMinutesLamps(0));
        Assert.assertEquals("YYROOOOOOOO", berlinClockLamp.getTopMinutesLamps(19));
        Assert.assertEquals("YYRYYRYYRYY", berlinClockLamp.getTopMinutesLamps(56));
    }
    
    // Bottom minutes should light a yellow lamp for every minute left from top minutes
    @Test
    public void testBottomMinutesShouldLightYellowLampForEveryMinuteLeftFromTopMinutes() {
        Assert.assertEquals("OOOO", berlinClockLamp.getBottomMinuteLamps(0));
        Assert.assertEquals("YYOO", berlinClockLamp.getBottomMinuteLamps(17));
        Assert.assertEquals("YYYY", berlinClockLamp.getBottomMinuteLamps(59));
    }
 
}
