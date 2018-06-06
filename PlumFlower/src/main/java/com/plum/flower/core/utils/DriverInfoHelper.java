package com.plum.flower.core.utils;

import java.io.FileReader;

import org.ini4j.Ini;
import org.ini4j.Profile.Section;

import com.plum.flower.core.driver.DriverInfo;
import com.plum.flower.core.driver.DriverMode;
import com.plum.flower.core.driver.DriverType;

public class DriverInfoHelper {
	public static DriverInfo getDriverInfo(String file, String sectionName) {
		DriverInfo info = new DriverInfo();
		Ini ini;
		try {
			ini = new Ini(new FileReader(file));
			Section section = ini.get(sectionName);
			if (section != null) {
				String mode = section.get("mode");
				String driverType = section.get("driver");
				String driverExecutable = section.get("executable");
				String remoteUrl = section.get("remoteUrl");
				String capabilities = section.get("capabilities");
				String args = section.get("arguments");
				info.setDriverExecutable(driverExecutable);
				info.setType(DriverType.valueOf(driverType));
				info.setRemoteUrl(remoteUrl);
				info.setMode(DriverMode.valueOf(mode));
				info.setCapabilities(capabilities);
				info.setArguments(args);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}
}
