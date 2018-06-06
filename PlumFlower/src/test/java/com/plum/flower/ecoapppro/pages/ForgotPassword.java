package com.plum.flower.ecoapppro.pages;

import com.plum.flower.core.element.IButton;
import com.plum.flower.core.element.ILabel;
import com.plum.flower.core.element.ITextBox;
import com.plum.flower.core.element.imp.Button;
import com.plum.flower.core.element.imp.Label;
import com.plum.flower.core.element.imp.TextBox;

public class ForgotPassword {

	public boolean isAt() {
		return forgotPasswordLabel.isDisplayed();
	}

	public void contiuneToResetPassword(String email) {
		fillEmail(email);
		continueButton.click();
	}

	public void fillEmail(String email) {
		emailTextBox.enter(email);
	}

	public boolean isInvalidEmailMessageDisplayed() {
		return invalidEmailMessage.isDisplayed();
	}

	public boolean isContinueButtonDisabled() {
		return !continueButton.isEnabled();
	}

	private ILabel forgotPasswordLabel = new Label("//h1[text()='Forgot Password']");
	private ITextBox emailTextBox = new TextBox("//input[@placeholder='Email']");
	private IButton continueButton = new Button("//button[text()='Continue to Reset Password']");
	private ILabel invalidEmailMessage = new Label(
			"//label[text()='Please add an email address, this field is required.']");
}
