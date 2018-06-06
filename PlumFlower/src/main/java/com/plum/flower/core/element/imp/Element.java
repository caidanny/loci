package com.plum.flower.core.element.imp;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.plum.flower.core.driver.DriverHelper;
import com.plum.flower.core.element.IElement;

public class Element implements IElement {

	private String locator;
	private By byLocator;
	private WebElement webElement;
	private String dynamicLocator;

	private By getByLocator() {
		String body = this.locator.replaceAll("[\\w\\s]*=(.*)", "$1").trim();
		String type = this.locator.replaceAll("([\\w\\s]*)=.*", "$1").trim();
		switch (type) {
		case "css":
			return By.cssSelector(body);
		case "id":
			return By.id(body);
		case "link":
			return By.linkText(body);
		case "xpath":
			return By.xpath(body);
		case "text":
			return By.xpath(String.format("//*[contains(text(), '%s')]", body));
		case "name":
			return By.name(body);
		default:
			return By.xpath(locator);
		}
	}

	protected WebElement getElement() {
		if (this.webElement == null) {
			this.webElement = waitForElementPresent();
		} else {
			try {
				this.webElement.isEnabled();
			} catch (StaleElementReferenceException e) {
				System.out.println("Element is no longer. Re-finding");
				this.webElement = waitForElementPresent();
			}
		}
		return this.webElement;
	}

	private WebDriver getDriver() {
		return DriverHelper.getDriver();
	}

	public Element(String locator) {
		this.locator = locator;
		this.dynamicLocator = locator;
		this.byLocator = getByLocator();
	}

	public Element(By locator) {
		this.byLocator = locator;
	}

	public Element(WebElement element) {
		this.webElement = element;
	}

	@Override
	public void setDynamicValue(Object... args) {
		this.locator = String.format(this.dynamicLocator, args);
		this.byLocator = getByLocator();
	}

	@Override
	public By getLocator() {
		return this.byLocator;
	}

	@Override
	public void click() {
		getElement().click();
	}

	@Override
	public void clickByJS() {
		DriverHelper.executeJavaScript("arguments[0].click();", getElement());
	}

	@Override
	public void doubleClick() {
		Actions actions = new Actions(getDriver());
		actions.doubleClick(getElement());
	}

	@Override
	public String getText() {
		return getElement().getText();
	}

	@Override
	public String getAttribute(String name) {
		return getElement().getAttribute(name);
	}

	@Override
	public WebElement waitForElementPresent(long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
		return wait.until(ExpectedConditions.presenceOfElementLocated(this.getLocator()));
	}

	@Override
	public WebElement waitForElementPresent() {
		return waitForElementPresent(DriverHelper.getTimeOut());
	}

	@Override
	public void enter(CharSequence... keysToSend) {
		getElement().sendKeys(keysToSend);
	}

	@Override
	public boolean isDisplayed() {
		try {
			return getElement().isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		} catch (TimeoutException e) {
			return false;
		}
	}

	@Override
	public void moveTo() {
		Actions actions = new Actions(getDriver());
		actions.moveToElement(getElement()).build().perform();
	}

	@Override
	public boolean isDisplayed(long timeOutInSeconds) {
		waitForElementPresent(timeOutInSeconds);
		return isDisplayed();
	}

	@Override
	public boolean isEnabled() {
		return getElement().isEnabled();
	}

	@Override
	public void waitForTextPresent(String text) {
		waitForTextPresent(text, DriverHelper.getTimeOut());
	}

	@Override
	public void waitForTextPresent(String text, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(this.getLocator(), text));
	}

	@Override
	public WebElement getChildElement(By locator) {
		WebDriverWait wait = new WebDriverWait(getDriver(), DriverHelper.getTimeOut());
		return wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver arg0) {
				return getElement().findElement(locator);
			}
		});
	}

	@Override
	public void waitForElementInvisible() {
		WebDriverWait wait = new WebDriverWait(getDriver(), DriverHelper.getTimeOut());
		wait.until(ExpectedConditions.invisibilityOfElementLocated(this.getLocator()));
	}
}
