package com.plum.flower.core.driver;

public class DriverInfo {

	private String remoteUrl;
	private DriverType type;
	private String driverExecutable;
	private DriverMode mode;
	private String capabilities;
	private String arguments;

	public String getRemoteUrl() {
		return remoteUrl;
	}

	public void setRemoteUrl(String remoteUrl) {
		this.remoteUrl = remoteUrl;
	}

	public DriverType getType() {
		return type;
	}

	public void setType(DriverType type) {
		this.type = type;
	}

	public String getDriverExecutable() {
		return driverExecutable;
	}

	public void setDriverExecutable(String driverExecutable) {
		this.driverExecutable = driverExecutable;
	}

	public DriverMode getMode() {
		return mode;
	}

	public void setMode(DriverMode mode) {
		this.mode = mode;
	}

	public String getCapabilities() {
		return capabilities;
	}

	public void setCapabilities(String capabilities) {
		this.capabilities = capabilities;
	}

	public String getArguments() {
		return arguments;
	}

	public void setArguments(String arguments) {
		this.arguments = arguments;
	}

}
