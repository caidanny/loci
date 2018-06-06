package com.plum.flower.core.element;

public interface IComboBox extends IElement {

	void selectByVisibleText(String text);

	void selectByIndex(int index);
	
	void selectByValue(String value);
}
