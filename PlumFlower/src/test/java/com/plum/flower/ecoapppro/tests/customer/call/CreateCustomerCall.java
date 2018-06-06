package com.plum.flower.ecoapppro.tests.customer.call;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.google.inject.Inject;
import com.plum.flower.ecoapppro.pages.CustomerCallPage;
import com.plum.flower.ecoapppro.pages.DiscussionsPage;
import com.plum.flower.ecoapppro.pages.LoginPage;
import com.plum.flower.ecoapppro.utils.Constants;
import com.plum.flower.ecoapppro.utils.ECommunication;
import com.plum.flower.ecoapppro.utils.TestBase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class CreateCustomerCall extends TestBase {

	@BeforeClass
	public void setUp() {
		loginPage.goTo();
		loginPage.login(Constants.USERNAME, Constants.PASSWORD);
		discussionsPage.goToPage(ECommunication.CUSC);
	}

	@Test(description = "Open customer call form by clicking on plus ( + ) icon")
	public void C1955() {
		customerCallPage.openAddCustomerCallFromIcon();
		assertTrue(customerCallPage.isAddCustomerCallFormDisplayed());
		customerCallPage.closeAddCustomerCallForm();
	}

	@Test(description = "Open customer call form by clicking on 'Create'")
	public void C1956() {
		customerCallPage.openAddCustomerCallFromCreateButton();
		assertTrue(customerCallPage.isAddCustomerCallFormDisplayed());
		customerCallPage.closeAddCustomerCallForm();
	}

	@Test(description = "Open customer call form by clicking on 'Customer Call' from drop-down")
	public void C1957() {
		customerCallPage.openMenuTransition();
		assertTrue(customerCallPage.isMenuTransitionDisplayed());
		customerCallPage.selectMenuTransition(ECommunication.CUSC);
		assertTrue(customerCallPage.isAddCustomerCallFormDisplayed());
		customerCallPage.closeAddCustomerCallForm();
	}

	@Test(description = "Closed the customer call form")
	public void C2231() {
		customerCallPage.openAddCustomerCallFromIcon();
		customerCallPage.closeAddCustomerCallForm();
		assertFalse(customerCallPage.isAddCustomerCallFormDisplayed());
	}

	@Test(description = "Customer Call form page")
	public void C1958() {
		customerCallPage.openAddCustomerCallFromIcon();
		customerCallPage.verifyAddNewCustomerUI();
		customerCallPage.closeAddCustomerCallForm();
	}

	@Test(description = "Change communication type")
	public void C1960() {
		discussionsPage.goToPage(ECommunication.CUSC);
		customerCallPage.openAddCustomerCallFromIcon();
		assertEquals(customerCallPage.getType(), ECommunication.CUSC.value());
		customerCallPage.selectType(ECommunication.DISC.value());
		assertTrue(discussionsPage.isAddDiscissonFormDisplayed());
		discussionsPage.closeDiscussionForm();
	}

	@Test(description = "Customer Call form - All blank data")
	public void C1961() {
		discussionsPage.goToPage(ECommunication.CUSC);
		customerCallPage.openAddCustomerCallFromIcon();
		assertFalse(customerCallPage.isAddButtonEnabled());
		customerCallPage.closeAddCustomerCallForm();
	}

	@Inject
	LoginPage loginPage;

	@Inject
	DiscussionsPage discussionsPage;

	@Inject
	CustomerCallPage customerCallPage;
}
