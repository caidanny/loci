package com.plum.flower.core.browser;

import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.plum.flower.core.driver.manger.LocalDriverManager;

public class ChromeLocalDriver extends LocalDriverManager {

	@Override
	public void createWebDriver() {
		System.setProperty("webdriver.chrome.driver", getDriverExecutable());
		ChromeOptions options = new ChromeOptions();
		options.merge(getCapabilities());
		List<String> args = getArguments();
		if (args != null) {
			options.addArguments(args);
		}
		this.driver = new ChromeDriver(options);
	}
}
