package com.plum.flower.ecoapppro.pages;

import com.plum.flower.core.element.IButton;
import com.plum.flower.core.element.IElement;
import com.plum.flower.core.element.IImage;
import com.plum.flower.core.element.ILabel;
import com.plum.flower.core.element.ILink;
import com.plum.flower.core.element.imp.Button;
import com.plum.flower.core.element.imp.Element;
import com.plum.flower.core.element.imp.Image;
import com.plum.flower.core.element.imp.Label;
import com.plum.flower.core.element.imp.Link;
import com.plum.flower.ecoapppro.utils.Constants;
import com.plum.flower.ecoapppro.utils.ECommunication;

public class GeneralPage {

	private IImage loadingImage = new Image("//div[@class='center']/div[@class='ui inverted text loader']");

	private ILabel pageHeader = new Label("//div[@class='ui vertical search-side-menu menu']//header/div/span");
	private ILink userLargeLink = new Link("//i[@class='user large icon']");
	private ILink singOut = new Link("//div[text()='Sign Out']");
	private ILink communicationLink = new Link("//div[text()='Communication']");
	private IButton createButton = new Button("//button[text()='Create']");
	private IButton ellipsisIcon = new Button("//button[text()='Create']/following-sibling::div");
	private ILink communicationItem = new Link("//a[@class='item' and contains(text(),'%s')]");
	private IElement menuTransition = new Element(
			"//button[text()='Create']/following-sibling::div/div[@class='menu transition visible']");

	private ILink menuOptionTransition = new Link(
			"//button[text()='Create']/following-sibling::div/div[@class='menu transition visible']/div[text()='%s']");

	protected void clickOnCreateButton() {
		createButton.click();
	}

	public void waitForLoadingImageInvisible() {
		loadingImage.waitForElementInvisible();
	}

	public boolean isMenuTransitionDisplayed() {
		return menuTransition.isDisplayed();
	}

	public void openMenuTransition() {
		ellipsisIcon.click();
	}

	public void selectMenuTransition(ECommunication communication) {
		menuOptionTransition.setDynamicValue(communication.value());
		menuOptionTransition.click();
	}

	public String getCurrentPageHeader() {
		return pageHeader.getText();
	}

	public void logout() {
		userLargeLink.waitForElementPresent();
		userLargeLink.click();
		singOut.click();
	}

	public void goToPage(ECommunication communication) {
		communicationLink.waitForElementPresent(Constants.TIME_OUT);
		communicationLink.click();
		communicationItem.setDynamicValue(communication.value());
		communicationItem.click();
		pageHeader.waitForTextPresent(communication.value(), Constants.TIME_OUT);
	}
}
