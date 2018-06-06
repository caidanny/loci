package com.plum.flower.ecoapppro.utils;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class APIHelper {

	private String accessToken;
	private String authorization;

	public APIHelper() {
		this.accessToken = getAccessToken();
		this.authorization = "Bearer " + this.accessToken;
		System.out.println(this.authorization);
	}

	private String getAccessToken() {
		Response resp = given().baseUri(Constants.API_LOGIN_URL).auth().basic(Constants.USERNAME, Constants.PASSWORD)
				.header("App-Key", "YmFzZTY03ad1e0").post("/v1/user/auth/login");

		return resp.body().jsonPath().get("app_server.access_token");
	}

	public int getCustomerCallId(String title) {
		int id = -1;
		try {
			Response resp = given().baseUri(Constants.API_URL).header("Authorization", authorization)
					.header("Content-Type", "application/json;charset=UTF-8")
					.get("/v1/customer-call/calls?filters[name]=" + title);
			id = resp.body().jsonPath().get("items[0].thread_id");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return id;

	}

	public void deleteCustomerCall(String title) {
		try {
			int id = getCustomerCallId(title);
			if (id != -1) {
				given().baseUri(Constants.API_URL).header("Authorization", authorization)
						.header("Content-Type", "application/json;charset=UTF-8")
						.delete("/v1/customer-call/calls/" + id);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
