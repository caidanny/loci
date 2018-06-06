package com.plum.flower.ecoapppro.data.base;

import com.plum.flower.core.utils.JsonHelper;

public class DataBase {

	private String jsonFile = "";

	public String getJsonFile() {
		return jsonFile;
	}

	public void setJsonFile(String jsonFile) {
		this.jsonFile = jsonFile;
	}

	public DataBase(String jsonFile) {
		this.jsonFile = jsonFile;
	}

	public <T> T getData() {
		return JsonHelper.getData(jsonFile, this.getClass());
	}

}
