package com.plum.flower.core.element.imp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.plum.flower.core.element.ITextBox;

public class TextBox extends Element implements ITextBox {

	public TextBox(By locator) {
		super(locator);
	}

	public TextBox(WebElement element) {
		super(element);
	}

	public TextBox(String locator) {
		super(locator);
	}

	public String getValue() {
		return getAttribute("value");
	}
}
