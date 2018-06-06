package com.plum.flower.core.browser;

import java.util.List;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.plum.flower.core.driver.manger.LocalDriverManager;

public class FirefoxLocalDriver extends LocalDriverManager {

	@Override
	public void createWebDriver() {
		System.setProperty("webdriver.gecko.driver", getDriverExecutable());
		FirefoxOptions options = new FirefoxOptions();
		options.merge(getCapabilities());
		List<String> args = getArguments();
		if (args != null) {
			options.addArguments(args);
		}
		this.driver = new FirefoxDriver(options);
	}

}
