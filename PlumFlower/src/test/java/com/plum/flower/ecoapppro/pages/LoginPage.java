package com.plum.flower.ecoapppro.pages;

import com.plum.flower.core.driver.DriverHelper;
import com.plum.flower.core.element.IButton;
import com.plum.flower.core.element.IElement;
import com.plum.flower.core.element.IImage;
import com.plum.flower.core.element.ILabel;
import com.plum.flower.core.element.ILink;
import com.plum.flower.core.element.ITextBox;
import com.plum.flower.core.element.imp.Button;
import com.plum.flower.core.element.imp.Element;
import com.plum.flower.core.element.imp.Image;
import com.plum.flower.core.element.imp.Label;
import com.plum.flower.core.element.imp.Link;
import com.plum.flower.core.element.imp.TextBox;
import com.plum.flower.ecoapppro.utils.Constants;

public class LoginPage {

	public void goTo() {
		DriverHelper.navigate(Constants.URL);
	}

	public void loginOnPopup(String password) {
		passwordTextBoxOnPopup.waitForElementPresent();
		passwordTextBoxOnPopup.enter(password);
		loginButtonOnPopup.click();
	}

	public void login(String userName, String password) {
		userNameTextBox.waitForElementPresent(Constants.TIME_OUT);
		userNameTextBox.enter(userName);
		passwordTextBox.enter(password);
		loginButton.click();
	}

	public void refreshPage() {
		DriverHelper.refresh();
	}

	public boolean isErrorLoginMessageDisplayed() {
		return errorLoginMessage.isDisplayed();
	}

	public boolean isErrorLoginMessageOnPopupDisplayed() {
		return errorLoginMessageOnPopup.isDisplayed();
	}

	public boolean isAt() {
		return loginButton.isDisplayed();
	}

	public boolean isThumbnailProfileDisplayed(String firstName) {
		thumbnailProfile.setDynamicValue(firstName);
		return thumbnailProfile.isDisplayed();
	}

	public boolean isThumbnailProfileOnPopupDisplayed(String firstName) {
		thumbnailProfileOnPopup.setDynamicValue(firstName);
		return thumbnailProfileOnPopup.isDisplayed();
	}

	public void openLoginPopupFromThumbnail(String firstName) {
		thumbnailProfile.setDynamicValue(firstName);
		thumbnailProfile.click();
	}

	public boolean isLoginPopupDisplayed() {
		return loginPopup.isDisplayed();
	}

	public boolean isFirstNameDisplayed(String firstName) {
		firstNameLabel.setDynamicValue(firstName);
		return firstNameLabel.isDisplayed();
	}

	public boolean isFirstNameOnPopupDisplayed(String firstName) {
		firstNameLabelOnPopup.setDynamicValue(firstName);
		return firstNameLabelOnPopup.isDisplayed();
	}

	public void openLoginPopupFromFirstName(String firstName) {
		firstNameLabel.setDynamicValue(firstName);
		firstNameLabel.click();
	}

	public void closeLoginPopup() {
		closeButtonOnLoginPopup.click();
	}

	public void holdMouseOnRemoveButton(String firstName) {
		removeAccountButton.setDynamicValue(firstName);
		removeAccountButton.moveTo();
	}

	public void removeAccount(String firstName) {
		removeAccountButton.setDynamicValue(firstName);
		removeAccountButton.click();
	}

	public boolean isRemoveAccountMessageDisplayed() {
		return removeAccountMessage.isDisplayed();
	}

	public void clickOnOutSidePopUp() {
		pageModals.clickByJS();
	}

	public void openForgotPassword() {
		lostYourPasswordLink.click();
	}

	private ITextBox userNameTextBox = new TextBox("//input[@placeholder='Email or Username']");
	private ITextBox passwordTextBox = new TextBox("//input[@placeholder='Password']");
	private IButton loginButton = new Button("//button[text()='Sign In']");
	private ILabel errorLoginMessage = new Label("//p[text()='Incorrect username or password']");
	private IImage thumbnailProfile = new Image(
			"//p[text()='Recent Logins']/following-sibling::div/p[text()='%s']/preceding-sibling::img");
	private ILabel firstNameLabel = new Label(
			"//p[text()='Recent Logins']/following-sibling::div/img/following-sibling::p[text()='%s']");
	private IElement loginPopup = new Element("//div[@class='ui mini modal transition visible active']");
	private IButton closeButtonOnLoginPopup = new Button(
			"//div[@class='ui mini modal transition visible active']/button");
	private IButton removeAccountButton = new Button(
			"//p[text()='Recent Logins']/following-sibling::div/p[text()='%s']/preceding-sibling::button");
	private IElement removeAccountMessage = new Element(
			"//div[@class='content' and text()='Remove account from this page']");
	private ILabel firstNameLabelOnPopup = new Label(
			"//div[@class='ui mini modal transition visible active']//p[text()='%s']");
	private IImage thumbnailProfileOnPopup = new Image(
			"//div[@class='ui mini modal transition visible active']//p[text()='%s']/preceding-sibling::img");
	private IElement pageModals = new Element("//div[@class='ui page modals dimmer transition visible active']");

	private ITextBox passwordTextBoxOnPopup = new TextBox(
			"//div[@class='ui mini modal transition visible active']//input[@placeholder='Password']");
	private IButton loginButtonOnPopup = new Button(
			"//div[@class='ui mini modal transition visible active']//button[text()='Sign In']");

	private ILabel errorLoginMessageOnPopup = new Label(
			"//div[@class='ui mini modal transition visible active']//p[text()='Incorrect username or password']");

	private ILink lostYourPasswordLink = new Link("//a[text()='Lost your password']");
}
