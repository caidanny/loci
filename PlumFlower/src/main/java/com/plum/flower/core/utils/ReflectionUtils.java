package com.plum.flower.core.utils;

import java.lang.reflect.Method;

import com.plum.flower.core.driver.DriverInfo;
import com.plum.flower.core.driver.DriverMode;

public class ReflectionUtils {

	public static Object openWebDriver(DriverInfo driverInfo) throws Exception {

		DriverMode mode = driverInfo.getMode();
		String className = String.format(Constants.BROWSER_CLASS_NAME, driverInfo.getType().toString(), mode);

		Method method;
		String fullClassName = Constants.BROWSER_PACKAGE_NAME + "." + className;
		Class<?> clzz = Class.forName(fullClassName);
		Object obj = clzz.newInstance();

		if (driverInfo.getMode().equals(DriverMode.Remote)) {
			// Set Remote Url
			Method setRemoteUrlMethod = clzz.getSuperclass().getDeclaredMethod(Constants.SET_REMOTE_URL_METHOD,
					new Class[] { String.class });
			setRemoteUrlMethod.invoke(obj, driverInfo.getRemoteUrl());

		} else {
			// Set Driver Executable
			Method setDriverExecutableMethod = clzz.getSuperclass()
					.getDeclaredMethod(Constants.SET_DRIVER_EXECUTABLE_METHOD, new Class[] { String.class });
			setDriverExecutableMethod.invoke(obj, driverInfo.getDriverExecutable());
		}

		// Set Capability
		Method setCapabilitiesMethod = clzz.getSuperclass().getSuperclass()
				.getDeclaredMethod(Constants.SET_CAPABILITIES, new Class[] { String.class });
		setCapabilitiesMethod.invoke(obj, driverInfo.getCapabilities());

		// Set Arguments
		Method setArguments = clzz.getSuperclass().getSuperclass().getDeclaredMethod(Constants.SET_ARGUMENTS,
				new Class[] { String.class });
		setArguments.invoke(obj, driverInfo.getArguments());

		// Create Web Driver
		method = clzz.getDeclaredMethod(Constants.CREATE_WEB_DRIVER_METHOD);
		method.invoke(obj);
		return obj;

	}
}
