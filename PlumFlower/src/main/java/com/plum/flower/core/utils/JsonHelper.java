package com.plum.flower.core.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class JsonHelper {

	public static Map<String, String> convertJsonToMap(String json) {
		Map<String, String> maps = null;
		try {
			Type mapType = new TypeToken<Map<String, String>>() {
			}.getType();
			Gson gson = new Gson();
			maps = gson.fromJson(json, mapType);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return maps;
	}

	public static <T> List<T> getListData(String jsonPath, Type type) {
		List<T> lst = new ArrayList<T>();
		try {
			JsonReader reader = getJsonReader(jsonPath);
			Gson gson = new Gson();
			lst = gson.fromJson(reader, type);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lst;
	}

	public static <T> List<T> getListData(String jsonPath, Class<?> clazz) {
		List<T> lst = new ArrayList<T>();
		try {
			JsonReader reader = getJsonReader(jsonPath);
			Gson gson = new Gson();
			lst = gson.fromJson(reader, clazz);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lst;
	}

	public static <T> T getData(String jsonPath, Type type) {
		T object = null;
		try {
			Gson gson = new Gson();
			JsonReader reader = getJsonReader(jsonPath);
			object = gson.fromJson(reader, type);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return object;

	}

	public static <T> T getData(String jsonPath, Class<?> clazz) {
		T object = null;
		try {
			Gson gson = new Gson();
			JsonReader reader = getJsonReader(jsonPath);
			object = gson.fromJson(reader, clazz);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return object;
	}

	public static DesiredCapabilities convertJsonToCapabilities(String json) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		Map<String, String> caps = JsonHelper.convertJsonToMap(json);
		if (caps != null) {
			Set<String> keys = caps.keySet();
			for (String key : keys) {
				capabilities.setCapability(key, caps.get(key));
			}
		}
		return capabilities;
	}

	public static List<String> convertJsonToArguments(String json) {
		List<String> args = new ArrayList<String>();
		Type type = new TypeToken<ArrayList<String>>() {}.getType();
		Gson gson = new Gson();
		args = gson.fromJson(json, type);
		return args;
	}

	private static JsonReader getJsonReader(String jsonPath) {
		try {
			JsonReader reader;
			reader = new JsonReader(new FileReader(jsonPath));
			return reader;
		} catch (FileNotFoundException e) {
			return null;
		}
	}
}
