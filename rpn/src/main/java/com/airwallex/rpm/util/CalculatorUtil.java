package com.airwallex.rpm.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorUtil {
	private static List<String> opsList = Arrays.asList("+", "-", "*", "/", "clear", "undo", "sqrt");
	
	public static boolean isDecimal(String c){
		Pattern pattern= Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,15})?"); // numbers 15 decimal place
		Matcher match=pattern.matcher(c);
		return match.matches();
	}
	
	public static boolean isOperator(String c) {
		return opsList.contains(c);
	}
}
