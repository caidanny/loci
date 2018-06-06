package com.plum.flower.core.element.imp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.plum.flower.core.element.IComboBox;

public class ComboBox extends Element implements IComboBox {

	public ComboBox(By locator) {
		super(locator);
	}

	public ComboBox(String locator) {
		super(locator);
	}

	public ComboBox(WebElement element) {
		super(element);
	}

	@Override
	public void selectByVisibleText(String text) {
		Select select = new Select(getElement());
		select.selectByVisibleText(text);

	}

	@Override
	public void selectByIndex(int index) {
		Select select = new Select(getElement());
		select.selectByIndex(index);

	}

	@Override
	public void selectByValue(String value) {
		Select select = new Select(getElement());
		select.selectByValue(value);
	}

}
