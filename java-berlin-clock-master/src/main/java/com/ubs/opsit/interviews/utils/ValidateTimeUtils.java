package com.ubs.opsit.interviews.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

/**
 * Validator to validate 24 Hour time format.
 * 
 * @author OWNER
 *
 */
public class ValidateTimeUtils {
	private static final String TIME24HOURS_PATTERN = "([01]?[0-9]|2[0-4]):[0-5][0-9]:[0-5][0-9]";
	private Pattern pattern;
	private Matcher matcher;

	public ValidateTimeUtils() {
		pattern = Pattern.compile(TIME24HOURS_PATTERN);
	}

	/**
	 * Validate time in 24 hours format with regular expression
	 * 
	 * @param time
	 *            String for validation
	 * @return true valid time format, false invalid time format
	 */
	public boolean validate(final String time) {
		if (StringUtils.isEmpty(time)) {
			return false;
		}
		matcher = pattern.matcher(time);
		return matcher.matches();
	}
	
	
	public void validateRangeFromZeroUntil(int maxExcl, int arg, String argName){
		Validate.isTrue(arg >= 0, "Argument `" + argName + "` should be greater or equal to zero");
		Validate.isTrue(arg < maxExcl, "Argument `" + argName + "` should be lower than " + maxExcl);
	}

	public void validateRangeFromZeroUpTo(int maxIncl, int arg, String argName){
		Validate.isTrue(arg >= 0, "Argument `" + argName + "` should be greater or equal to zero");
		Validate.isTrue(arg <= maxIncl, "Argument `" + argName + "` should be lower or equal to " + maxIncl);
	}

}
