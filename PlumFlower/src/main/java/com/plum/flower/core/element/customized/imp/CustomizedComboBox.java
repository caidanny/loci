package com.plum.flower.core.element.customized.imp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.plum.flower.core.element.IComboBox;
import com.plum.flower.core.element.ILabel;
import com.plum.flower.core.element.imp.Element;
import com.plum.flower.core.element.imp.Label;

public class CustomizedComboBox extends Element implements IComboBox {

	public CustomizedComboBox(By locator) {
		super(locator);
	}

	public CustomizedComboBox(String locator) {
		super(locator);
	}

	public CustomizedComboBox(WebElement element) {
		super(element);
	}

	@Override
	public void selectByVisibleText(String text) {
		if (text != null && !text.equals("")) {
			ILabel item = new Label("//span[text()='%s']");
			item.setDynamicValue(text);
			getElement().click();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			getChildElement(item.getLocator()).click();
		}
	}

	@Override
	public void selectByIndex(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectByValue(String value) {
		// TODO Auto-generated method stub

	}

}
