package com.plum.flower.core.element.imp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.plum.flower.core.element.ILabel;

public class Label extends Element implements ILabel {

	public Label(By locator) {
		super(locator);
	}

	public Label(String locator) {
		super(locator);
	}

	public Label(WebElement element) {
		super(element);
	}

}
