package com.plum.flower.ecoapppro.utils;

import java.lang.reflect.Method;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Guice;
import org.testng.annotations.Parameters;

import com.plum.flower.core.driver.DriverHelper;
import com.plum.flower.core.driver.DriverInfo;
import com.plum.flower.core.utils.DriverInfoHelper;
import com.plum.flower.ecoapppro.testng.ModuleFactory;

@Guice(modules = ModuleFactory.class)
public class TestBase {

	@Parameters({ "browser" })
	@BeforeClass(alwaysRun = true)
	public void beforeMethod(String browser, Method method) {
		DriverInfo driverInfo = DriverInfoHelper.getDriverInfo(Constants.BROWSER_SETTING_FILE, browser);
		DriverHelper.createWebDriver(driverInfo);
		DriverHelper.maximizeBrowser();
	}

	@AfterClass(alwaysRun = true)
	public void afterMethod() {
		DriverHelper.quit();
	}
}
