package com.plum.flower.ecoapppro.utils;

import java.util.UUID;

import com.github.javafaker.Faker;

public class FakerHelper {

	private static Faker faker = new Faker();

	public static String getFullName() {
		return faker.name().fullName();
	}

	public static String getSentence() {
		return faker.lorem().sentence(2);
	}

	public static String getRandomUUID() {
		return UUID.randomUUID().toString();
	}

	public static String getPhoneNumber() {
		return faker.phoneNumber().cellPhone();
	}
}
