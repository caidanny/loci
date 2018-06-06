package com.plum.flower.ecoapppro.tests.access.app;

import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.inject.Inject;
import com.plum.flower.ecoapppro.pages.DiscussionsPage;
import com.plum.flower.ecoapppro.pages.LoginPage;
import com.plum.flower.ecoapppro.utils.Constants;
import com.plum.flower.ecoapppro.utils.TestBase;

public class LoginAsNormalUser extends TestBase {

	@BeforeClass
	public void setUp() {
		loginPage.goTo();
	}

	@Test(description = "Login with valid credential")
	public void C1815() {
		loginPage.login(Constants.USERNAME, Constants.PASSWORD);
		assertTrue(discussionsPage.isAt());
		discussionsPage.logout();
	}

	@Test(description = "Log in with valid email/username but invalid password")
	public void C1816() {
		loginPage.login(Constants.USERNAME, "");
		assertTrue(loginPage.isErrorLoginMessageDisplayed());
	}

	@Test(description = "Log in with valid email/username but invalid password")
	public void C1817() {
		loginPage.refreshPage();
		loginPage.login("", Constants.PASSWORD);
		assertTrue(loginPage.isErrorLoginMessageDisplayed());
	}

	@Test(description = "Validation test blank login credential")
	public void C1818() {
		loginPage.refreshPage();
		loginPage.login("", "");
		assertTrue(loginPage.isErrorLoginMessageDisplayed());
	}

	@Inject
	LoginPage loginPage;

	@Inject
	DiscussionsPage discussionsPage;
}
