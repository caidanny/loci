package com.plum.flower.core.element.imp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.plum.flower.core.element.IButton;

public class Button extends Element implements IButton {

	public Button(WebElement element) {
		super(element);
	}

	public Button(By locator) {
		super(locator);
	}

	public Button(String locator) {
		super(locator);
	}

}
