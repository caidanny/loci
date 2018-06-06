package com.plum.flower.core.browser;

import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.plum.flower.core.driver.manger.RemoteDriverManager;

public class EdgeRemoteDriver extends RemoteDriverManager {

	@Override
	public void createWebDriver() {
		EdgeOptions options = new EdgeOptions();
		options.merge(getCapabilities());
		this.driver = new RemoteWebDriver(getRemoteUrl(), options);
	}
}
