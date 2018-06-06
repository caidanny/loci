package com.plum.flower.core.browser;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.plum.flower.core.driver.manger.LocalDriverManager;

public class EdgeLocalDriver extends LocalDriverManager {

	@Override
	public void createWebDriver() {
		System.setProperty("webdriver.edge.driver", getDriverExecutable());
		EdgeOptions options = new EdgeOptions();
		options.merge(getCapabilities());
		this.driver = new EdgeDriver(options);
	}
}
