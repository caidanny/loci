package com.plum.flower.core.browser;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import com.plum.flower.core.driver.manger.LocalDriverManager;

public class IELocalDriver extends LocalDriverManager {

	@Override
	public void createWebDriver() {
		System.setProperty("webdriver.ie.driver", getDriverExecutable());
		InternetExplorerOptions options = new InternetExplorerOptions();
		options.merge(getCapabilities());
		this.driver = new InternetExplorerDriver(options);
	}

}
