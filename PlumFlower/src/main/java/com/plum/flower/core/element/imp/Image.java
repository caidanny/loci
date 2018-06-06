package com.plum.flower.core.element.imp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.plum.flower.core.element.IImage;

public class Image extends Element implements IImage {

	public Image(By locator) {
		super(locator);
	}

	public Image(String locator) {
		super(locator);
	}

	public Image(WebElement element) {
		super(element);
	}

	@Override
	public String getSource() {
		return getAttribute("src");
	}

}
