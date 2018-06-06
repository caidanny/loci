package com.plum.flower.core.element.imp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.plum.flower.core.element.ICheckBox;

public class CheckBox extends Element implements ICheckBox {

	public CheckBox(By locator) {
		super(locator);
	}

	public CheckBox(String locator) {
		super(locator);
	}

	public CheckBox(WebElement element) {
		super(element);
	}

	public void check() {
		if (!getElement().isSelected()) {
			click();
		}
	}

	public void uncheck() {
		if (getElement().isSelected()) {
			click();
		}
	}

	public boolean isChecked() {
		return getElement().isSelected();
	}
}
