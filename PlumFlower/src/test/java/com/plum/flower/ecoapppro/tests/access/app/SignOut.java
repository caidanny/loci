package com.plum.flower.ecoapppro.tests.access.app;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.inject.Inject;
import com.plum.flower.ecoapppro.pages.DiscussionsPage;
import com.plum.flower.ecoapppro.pages.LoginPage;
import com.plum.flower.ecoapppro.utils.Constants;
import com.plum.flower.ecoapppro.utils.TestBase;

public class SignOut extends TestBase {

	@BeforeClass
	public void setUp() {
		loginPage.goTo();
	}

	@Test(description = "User Logout")
	public void C1845() {
		loginPage.login(Constants.USERNAME, Constants.PASSWORD);
		discussionsPage.logout();

		assertTrue(loginPage.isThumbnailProfileDisplayed(Constants.FIRST_NAME));
		assertTrue(loginPage.isAt());

	}

	@Inject
	LoginPage loginPage;

	@Inject
	DiscussionsPage discussionsPage;
}
