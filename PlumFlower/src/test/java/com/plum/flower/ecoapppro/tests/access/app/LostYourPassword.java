package com.plum.flower.ecoapppro.tests.access.app;

import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.inject.Inject;
import com.plum.flower.ecoapppro.pages.ForgotPassword;
import com.plum.flower.ecoapppro.pages.LoginPage;
import com.plum.flower.ecoapppro.utils.TestBase;

public class LostYourPassword extends TestBase {

	@BeforeMethod
	public void setUp() {
		loginPage.goTo();
	}

	@Test(description = "Lost your password link")
	public void C1827() {
		loginPage.openForgotPassword();
		assertTrue(forgotPassword.isAt());
	}

	@Test(description = "Forgot password with invalid email")
	public void C1829() {
		loginPage.openForgotPassword();
		forgotPassword.fillEmail("invalid");
		assertTrue(forgotPassword.isContinueButtonDisabled());
		assertTrue(forgotPassword.isInvalidEmailMessageDisplayed());
	}

	@Inject
	LoginPage loginPage;

	@Inject
	ForgotPassword forgotPassword;
}
