package com.plum.flower.ecoapppro.utils;

public class Constants {

	public static long TIME_OUT = 20;
	public static long SHORT_TIME_OUT = 10;

	public static final String BROWSER_SETTING_FILE = "src/test/resources/browsers.setting.properties";

	public static String USERNAME = PropertiesHelper.getPropValue("profile.ecoapppro.user.name");
	public static String PASSWORD = PropertiesHelper.getPropValue("profile.ecoapppro.user.password");
	public static String FIRST_NAME = PropertiesHelper.getPropValue("profile.ecoapppro.user.first.name");
	public static String URL = PropertiesHelper.getPropValue("profile.ecoapppro.url");
	public static String API_URL = PropertiesHelper.getPropValue("profile.ecoapppro.api.url");
	public static String API_LOGIN_URL = PropertiesHelper.getPropValue("profile.ecoapppro.api.login.url");

}
