package com.plum.flower.core.driver;

import java.util.Arrays;

public enum DriverMode {
	Local, Remote;

	public static String asString() {
		return Arrays.toString(DriverMode.values()).replaceAll("^.|.$", "");
	}
}
