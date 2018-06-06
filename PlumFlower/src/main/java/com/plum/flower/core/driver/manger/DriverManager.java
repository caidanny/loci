package com.plum.flower.core.driver.manger;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.plum.flower.core.utils.JsonHelper;

public abstract class DriverManager {

	protected WebDriver driver;

	private long timeOut = 5;

	private String capabilities;

	private String arguments;

	public WebDriver getDriver() {
		return driver;
	}

	protected abstract void createWebDriver();

	protected DesiredCapabilities getCapabilities() {
		return JsonHelper.convertJsonToCapabilities(capabilities);
	}

	public void setCapabilities(String caps) {
		this.capabilities = caps;
	}

	public long getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(long timeOut) {
		this.timeOut = timeOut;
	}

	public List<String> getArguments() {
		return JsonHelper.convertJsonToArguments(this.arguments);
	}

	public void setArguments(String arguments) {
		this.arguments = arguments;
	}
}
