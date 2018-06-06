package com.plum.flower.core.element.imp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.plum.flower.core.element.ILink;

public class Link extends Element implements ILink {

	public Link(By locator) {
		super(locator);
	}

	public Link(String locator) {
		super(locator);
	}

	public Link(WebElement element) {
		super(element);
	}

}
