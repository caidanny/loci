package com.plum.flower.ecoapppro.pages;

import com.plum.flower.core.element.IButton;
import com.plum.flower.core.element.IElement;
import com.plum.flower.core.element.imp.Button;
import com.plum.flower.core.element.imp.Element;

public class DiscussionsPage extends GeneralPage {

	public boolean isAt() {
		return getCurrentPageHeader().equals("Discussions");
	}

	public boolean isAddDiscissonFormDisplayed() {
		return addDiscussionForm.isDisplayed();
	}

	public void closeDiscussionForm() {
		closeDiscussionFormIcon.click();
	}

	private IElement addDiscussionForm = new Element("//div[text()='Add Discussion']");
	private IButton closeDiscussionFormIcon = new Button("//div[text()='Add Discussion']/following-sibling::button");

}
