package com.plum.flower.core.browser;

import java.util.List;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.plum.flower.core.driver.manger.RemoteDriverManager;

public class FirefoxRemoteDriver extends RemoteDriverManager {

	@Override
	public void createWebDriver() {
		FirefoxOptions options = new FirefoxOptions();
		options.merge(getCapabilities());
		List<String> args = getArguments();
		if (args != null) {
			options.addArguments(args);
		}
		this.driver = new RemoteWebDriver(getRemoteUrl(), options);
	}
}
