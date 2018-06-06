package com.plum.flower.core.driver.manger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.plum.flower.core.driver.DriverInfo;
import com.plum.flower.core.utils.ReflectionUtils;


public class DriverManagerFactory {
	protected static final ThreadLocal<DriverManager> driverThread = new ThreadLocal<DriverManager>();

	protected static WebDriver getCurrentDriver() {
		return driverThread.get().getDriver();
	}

	protected static void setWebDriver(DriverManager driverManager) {
		driverThread.set(driverManager);
	}

	protected static long getDefaultTimeOut() {
		return driverThread.get().getTimeOut();
	}

	protected static JavascriptExecutor getJSExecutor() {
		return (JavascriptExecutor) getCurrentDriver();
	}

	protected static void initWebDriver(DriverInfo driverInfo) {
		Object obj;
		try {
			obj = ReflectionUtils.openWebDriver(driverInfo);
			setWebDriver((DriverManager) obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
