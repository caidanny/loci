package com.plum.flower.ecoapppro.pages;

import static org.testng.AssertJUnit.assertTrue;

import com.plum.flower.core.element.IButton;
import com.plum.flower.core.element.ICheckBox;
import com.plum.flower.core.element.IComboBox;
import com.plum.flower.core.element.IElement;
import com.plum.flower.core.element.ILabel;
import com.plum.flower.core.element.ILink;
import com.plum.flower.core.element.ITextBox;
import com.plum.flower.core.element.customized.imp.CustomizedComboBox;
import com.plum.flower.core.element.imp.Button;
import com.plum.flower.core.element.imp.CheckBox;
import com.plum.flower.core.element.imp.Element;
import com.plum.flower.core.element.imp.Label;
import com.plum.flower.core.element.imp.Link;
import com.plum.flower.core.element.imp.TextBox;
import com.plum.flower.ecoapppro.data.CustomerCallEntity;
import com.plum.flower.ecoapppro.utils.Constants;

public class CustomerCallPage extends GeneralPage {

	public void openAddCustomerCallFromIcon() {
		addCustomerCallIcon.click();
	}

	public void addCustomerCall(CustomerCallEntity entity) {
		openAddCustomerCallFromIcon();
		departmentBasicInfoComboBox.selectByVisibleText(entity.getBasicInfo().getDepartment());
		titleTextBox.enter(entity.getBasicInfo().getTitle());
		natureOfRequestComboBox.selectByVisibleText(entity.getBasicInfo().getNatureOfRequest());

		customerNameTextBox.enter(entity.getCallDetails().getCustomerName());
		customerPhoneTextBox.enter(entity.getCallDetails().getCustomerPhone());
		customerAddressTextBox.enter(entity.getCallDetails().getCustomerAddress());
		customerAddressTextBox.click();
		customerLoadingIconInput.waitForElementInvisible();
		statusCheckBox.setDynamicValue(entity.getCallDetails().getStatus());
		statusCheckBox.check();
		addButton.click();

	}

	public String getType() {
		return typeComboBox.getText();
	}

	public void openAddCustomerCallFromCreateButton() {
		clickOnCreateButton();
	}

	public boolean isAddCustomerCallFormDisplayed() {
		return addCustomerCallForm.isDisplayed();
	}

	public void closeAddCustomerCallForm() {
		closeCustomerCallFormIcon.click();
	}

	public void selectType(String value) {
		typeComboBox.selectByVisibleText(value);
	}

	public boolean isAddButtonEnabled() {
		return addButton.isEnabled();
	}

	public void verifyAddNewCustomerUI() {
		// The Customer Call form consists 4 sections as Basic Information, Assign to,
		// Call Details, MetaData
		assertTrue("Basic Information section is displayed", basicInformation.isDisplayed());
		assertTrue("Assign to section is displayed", assignTo.isDisplayed());
		assertTrue("Call Details section is displayed", callDetails.isDisplayed());
		assertTrue("MetaData section is displayed", metaData.isDisplayed());

		// Form title 'Add Customer Call'
		assertTrue("Form title is Add Customer Call", addCustomerCallForm.isDisplayed());

		// Type (drop-down)
		assertTrue("Type is displayed", typeComboBox.isDisplayed());

		// Basic Information section consists of Department, Title *, Nature of Request
		// * fields
		assertTrue("Department combobox is displayed", departmentBasicInfoComboBox.isDisplayed());
		assertTrue("Title textbox is displayed", titleTextBox.isDisplayed());
		assertTrue("Nature of Request combobox is displayed", natureOfRequestComboBox.isDisplayed());

		// Assign to section consists of Department, Job Category, Job Title, Notify
		// Members fields
		assertTrue("Department is displayed", departmentLink.isDisplayed());
		assertTrue("Job category is displayed", jobCategoryLink.isDisplayed());
		assertTrue("Job title is displayed", jobTitleLink.isDisplayed());
		assertTrue("Notify members is displayed", notifyMembersLink.isDisplayed());

		// Call Details section consists of Customer Name *, Customer Phone *, Customer
		// Address *, Problem is in different address, Description, Status *, Schedule
		// Publishing fields
		assertTrue("Customer name is displayed", customerNameTextBox.isDisplayed());
		assertTrue("Customer phone is displayed", customerPhoneTextBox.isDisplayed());
		assertTrue("Customer address is displayed", customerAddressTextBox.isDisplayed());
		assertTrue("Problem is in different address is displayed", problemInDifferentAddressLink.isDisplayed());
		assertTrue("Description is displayed", descriptionTextBox.isDisplayed());
		assertTrue("Active is displayed", activeCheckBox.isDisplayed());
		assertTrue("In-Active is displayed", inActiveCheckBox.isDisplayed());
		assertTrue("None is displayed", noneCheckBox.isDisplayed());
		assertTrue("Schedule publishing is displayed", schedulePublishingTextBox.isDisplayed());

		// MetaData section consists of Attach File(s), Add Watchers, Add related
		// keywords fields
		assertTrue("Attache files is displayed", attacheFiles.isDisplayed());
		assertTrue("Add watchers is displayed", addWatchers.isDisplayed());
		assertTrue("Add related keywords is displayed", addRelatedKeywords.isDisplayed());
		// Add & Cancel button
		assertTrue("Add is displayed", addButton.isDisplayed());
		assertTrue("Cancel is displayed", cancelButton.isDisplayed());

	}

	public void openCustomerCallInLefNav(String title) {
		customerCallItemInLefNav.setDynamicValue(title);
		customerCallItemInLefNav.waitForElementPresent();
		customerCallItemInLefNav.click();
	}

	public boolean isCustomerCallCreated(String title) {
		customerCallItemInLefNav.setDynamicValue(title);
		return customerCallItemInLefNav.isDisplayed();
	}

	public String getCustomerCallDepartmentInDetails() {
		customerCallDepartmentInDetails.waitForElementPresent(Constants.TIME_OUT);
		return customerCallDepartmentInDetails.getText();
	}

	public void openActivityLogTab() {
		waitForLoadingImageInvisible();
		activityLogTab.waitForElementPresent(Constants.TIME_OUT);
		activityLogTab.click();
	}

	public boolean isLogIsAddedToActivityLog(String log) {
		custimerCallActivityLog.setDynamicValue(log);
		return custimerCallActivityLog.isDisplayed(Constants.TIME_OUT);
	}

	private IButton addCustomerCallIcon = new Button("//button[@class='ui blue big circular icon button']");

	private IElement addCustomerCallForm = new Element("//div[text()='Add Customer Call']");
	private IButton closeCustomerCallFormIcon = new Button(
			"//div[text()='Add Customer Call']/following-sibling::button");
	private IComboBox typeComboBox = new CustomizedComboBox("//div[@name='Type']");

	private ILabel basicInformation = new Label("//div[text()='Basic Information']");
	private IComboBox departmentBasicInfoComboBox = new CustomizedComboBox(
			"//div[text()='Basic Information']/following-sibling::div/span[text()='Department ']//following-sibling::div/div");
	private IComboBox natureOfRequestComboBox = new CustomizedComboBox(
			"//div[text()='Basic Information']/following-sibling::div/span[text()='Nature of Request']/font[text()='*']/../following-sibling::div/input");
	private ITextBox titleTextBox = new TextBox(
			"//div[text()='Basic Information']/following-sibling::div/span[text()='Title']/font[text()='*']/../following-sibling::div/div/input");

	private ILabel assignTo = new Label("//div[text()='Assign to']");
	private ILink departmentLink = new Link(
			"//div[text()='Assign to']/following-sibling::div//a[contains(text(),'Department')]");
	private ILink jobCategoryLink = new Link(
			"//div[text()='Assign to']/following-sibling::div//a[contains(text(),'Job Category')]");
	private ILink jobTitleLink = new Link(
			"//div[text()='Assign to']/following-sibling::div//a[contains(text(),'Job Title')]");
	private ILink notifyMembersLink = new Link(
			"//div[text()='Assign to']/following-sibling::div//a[contains(text(),'Notify Members')]");

	private ILabel callDetails = new Label("//div[text()='Call Details']");
	private ITextBox customerNameTextBox = new TextBox(
			"//div[text()='Call Details']/following-sibling::div/span[text()='Customer Name']/font[text()='*']/../following-sibling::div//input");
	private ITextBox customerPhoneTextBox = new TextBox(
			"//div[text()='Call Details']/following-sibling::div/span[text()='Customer Phone']/font[text()='*']/../following-sibling::div//input");
	private ITextBox customerAddressTextBox = new TextBox(
			"//div[text()='Call Details']/following-sibling::div/span[text()='Customer Address']/font[text()='*']/../following-sibling::div//input");
	private IElement customerLoadingIconInput = new Element(
			"//div[text()='Call Details']/following-sibling::div/span[text()='Customer Address']/font[text()='*']/../following-sibling::div//i");

	private ILink problemInDifferentAddressLink = new Link(
			"//div[text()='Call Details']/following-sibling::div//a[contains(text(),'Problem is in different address')]");
	private ITextBox descriptionTextBox = new TextBox(
			"//div[text()='Call Details']/following-sibling::div//span[contains(text(),'Description')]/following-sibling::div//div[@role='combobox']");

	private ICheckBox statusCheckBox = new CheckBox(
			"//div[text()='Call Details']/following-sibling::div/span[text()='Status']/font[text()='*']/../following-sibling::div//label[text()='%s']");

	private ICheckBox activeCheckBox = new CheckBox(
			"//div[text()='Call Details']/following-sibling::div/span[text()='Status']/font[text()='*']/../following-sibling::div//label[text()='Active']");
	private ICheckBox inActiveCheckBox = new CheckBox(
			"//div[text()='Call Details']/following-sibling::div/span[text()='Status']/font[text()='*']/../following-sibling::div//label[text()='In-Active']");
	private ICheckBox noneCheckBox = new CheckBox(
			"//div[text()='Call Details']/following-sibling::div/span[text()='Status']/font[text()='*']/../following-sibling::div//label[text()='None']");
	private ITextBox schedulePublishingTextBox = new TextBox(
			"//div[text()='Call Details']/following-sibling::div//span[contains(text(),'Schedule Publishing')]/following-sibling::div//input");

	private ILabel metaData = new Label("//div[text()='Metadata']");
	private ILink attacheFiles = new Link(
			"//div[text()='Metadata']/following-sibling::div//a[contains(text(),'Attach File(s)')]");
	private ILink addWatchers = new Link(
			"//div[text()='Metadata']/following-sibling::div//a[contains(text(),'Add Watchers')]");
	private ILink addRelatedKeywords = new Link(
			"//div[text()='Metadata']/following-sibling::div//a[contains(text(),'Add related keywords')]");

	private ILink customerCallItemInLefNav = new Link("//div[@class='side-menu-search-result']//div[text()='%s']");
	private ILabel customerCallDepartmentInDetails = new Label("//div[contains(text(),'Department:')]/div");
	private ILink activityLogTab = new Link("//a[text()='Activity Log']");
	private ILabel custimerCallActivityLog = new Label("//div[@class='content']//span[contains(text(),'%s')]");

	private IButton addButton = new Button("//button[text()='Add']");
	private IButton cancelButton = new Button("//span[text()='Cancel']");

}
