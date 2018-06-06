package com.plum.flower.core.driver.manger;

public abstract class LocalDriverManager extends DriverManager {

	private String driverExecutable;

	public void setDriverExecutable(String driverExecutableFile) {
		this.driverExecutable = driverExecutableFile;
	}

	public String getDriverExecutable() {
		return this.driverExecutable;
	}
}
