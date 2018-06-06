package com.plum.flower.core.browser;

import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.plum.flower.core.driver.manger.RemoteDriverManager;

public class IERemoteDriver extends RemoteDriverManager {

	@Override
	public void createWebDriver() {
		InternetExplorerOptions ops = new InternetExplorerOptions();
		ops.merge(getCapabilities());
		this.driver = new RemoteWebDriver(getRemoteUrl(), ops);
	}
}
