package com.plum.flower.ecoapppro.utils;

public enum ECommunication {
	DISC("Discussion"), DAIB("Daily Bulletin"), CUSC("Customer Call"), EMEA("Emergency Alert");

	private String value;

	ECommunication(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}

}
