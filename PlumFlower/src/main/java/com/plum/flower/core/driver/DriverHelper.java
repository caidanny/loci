package com.plum.flower.core.driver;

import org.openqa.selenium.WebDriver;

import com.plum.flower.core.driver.manger.DriverManagerFactory;

public class DriverHelper extends DriverManagerFactory {

	public static void createWebDriver(DriverInfo driverInfo) {
		initWebDriver(driverInfo);
	}

	public static WebDriver getDriver() {
		return getCurrentDriver();
	}

	public static long getTimeOut() {
		return getDefaultTimeOut();
	}

	public static void navigate(String url) {
		getDriver().get(url);
	}

	public static void quit() {
		getDriver().quit();
	}

	public static void refresh() {
		getDriver().navigate().refresh();
	}

	public static void maximizeBrowser() {
		getDriver().manage().window().maximize();
	}

	public static Object executeJavaScript(String script, Object... args) {
		return getJSExecutor().executeScript(script, args);
	}
}
