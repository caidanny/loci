package com.plum.flower.ecoapppro.tests.access.app;

import static org.testng.AssertJUnit.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.inject.Inject;
import com.plum.flower.ecoapppro.pages.DiscussionsPage;
import com.plum.flower.ecoapppro.pages.LoginPage;
import com.plum.flower.ecoapppro.utils.Constants;
import com.plum.flower.ecoapppro.utils.TestBase;

public class RecentLogin extends TestBase {

	@BeforeClass
	public void setUp() {
		loginPage.goTo();
	}

	@BeforeMethod
	public void testCaseSetUp() {
		loginPage.login(Constants.USERNAME, Constants.PASSWORD);
		discussionsPage.logout();
	}

	@Test(description = "Thumbnail profile image")
	public void C1819() {
		assertTrue(loginPage.isThumbnailProfileDisplayed(Constants.FIRST_NAME));
		loginPage.openLoginPopupFromThumbnail(Constants.FIRST_NAME);
		assertTrue(loginPage.isLoginPopupDisplayed());
		loginPage.closeLoginPopup();
	}

	@Test(description = "First and Last name")
	public void C1820() {
		assertTrue(loginPage.isFirstNameDisplayed(Constants.FIRST_NAME));
		loginPage.openLoginPopupFromFirstName(Constants.FIRST_NAME);
		assertTrue(loginPage.isLoginPopupDisplayed());
		loginPage.closeLoginPopup();
	}

	@Test(description = "Remove recent login option")
	public void C1821() {
		loginPage.holdMouseOnRemoveButton(Constants.FIRST_NAME);
		assertTrue(loginPage.isRemoveAccountMessageDisplayed());
		loginPage.removeAccount(Constants.FIRST_NAME);
		assertFalse(loginPage.isThumbnailProfileDisplayed(Constants.FIRST_NAME));
	}

	@Test(description = "Thumbnail image & user name on login pop-up")
	public void C1822() {
		loginPage.openLoginPopupFromThumbnail(Constants.FIRST_NAME);
		assertTrue(loginPage.isFirstNameOnPopupDisplayed(Constants.FIRST_NAME));
		assertTrue(loginPage.isThumbnailProfileOnPopupDisplayed(Constants.FIRST_NAME));
		loginPage.closeLoginPopup();
	}

	@Test(description = "Close recent login pop-up")
	public void C1823() {
		loginPage.openLoginPopupFromThumbnail(Constants.FIRST_NAME);
		assertTrue(loginPage.isLoginPopupDisplayed());

		loginPage.clickOnOutSidePopUp();
		assertFalse(loginPage.isLoginPopupDisplayed());
	}

	@Test(description = "Login with blank password")
	public void C1824() {
		loginPage.openLoginPopupFromThumbnail(Constants.FIRST_NAME);

		loginPage.loginOnPopup("");
		assertTrue(loginPage.isErrorLoginMessageOnPopupDisplayed());
		loginPage.closeLoginPopup();
	}

	@Test(description = "Login with valid password")
	public void C1826() {
		loginPage.openLoginPopupFromThumbnail(Constants.FIRST_NAME);
		loginPage.loginOnPopup(Constants.PASSWORD);

		assertTrue(discussionsPage.isAt());
	}

	@Inject
	LoginPage loginPage;

	@Inject
	DiscussionsPage discussionsPage;
}
