package com.plum.flower.core.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface IElement {

	void click();

	void clickByJS();

	void doubleClick();

	void moveTo();

	void enter(CharSequence... keysToSend);

	String getText();

	String getAttribute(String name);

	WebElement waitForElementPresent();

	WebElement waitForElementPresent(long timeOutInSeconds);

	void waitForTextPresent(String text);

	void waitForTextPresent(String text, long timeOutInSeconds);

	By getLocator();

	void setDynamicValue(Object... args);

	boolean isDisplayed();

	boolean isDisplayed(long timeOutInSeconds);

	boolean isEnabled();

	WebElement getChildElement(By locator);

	void waitForElementInvisible();

}
