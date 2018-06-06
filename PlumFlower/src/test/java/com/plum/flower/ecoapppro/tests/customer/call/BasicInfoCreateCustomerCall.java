package com.plum.flower.ecoapppro.tests.customer.call;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.inject.Inject;
import com.plum.flower.ecoapppro.data.CustomerCallEntity;
import com.plum.flower.ecoapppro.pages.CustomerCallPage;
import com.plum.flower.ecoapppro.pages.DiscussionsPage;
import com.plum.flower.ecoapppro.pages.LoginPage;
import com.plum.flower.ecoapppro.utils.APIHelper;
import com.plum.flower.ecoapppro.utils.Constants;
import com.plum.flower.ecoapppro.utils.ECommunication;
import com.plum.flower.ecoapppro.utils.FakerHelper;
import com.plum.flower.ecoapppro.utils.TestBase;

public class BasicInfoCreateCustomerCall extends TestBase {

	@BeforeClass
	public void setUp() {
		loginPage.goTo();
		loginPage.login(Constants.USERNAME, Constants.PASSWORD);
		discussionsPage.goToPage(ECommunication.CUSC);
		data = data.getData();
		data.getBasicInfo().setTitle(FakerHelper.getRandomUUID());
		data.getCallDetails().setCustomerName(FakerHelper.getFullName());
		data.getCallDetails().setCustomerPhone(FakerHelper.getPhoneNumber());
	}

	@Test(description = "Basic Information | Unselected Department")
	public void C1963() {
		customerCallPage.addCustomerCall(data);
		assertTrue(customerCallPage.isCustomerCallCreated(data.getBasicInfo().getTitle()));
		customerCallPage.openCustomerCallInLefNav(data.getBasicInfo().getTitle());
		assertEquals(customerCallPage.getCustomerCallDepartmentInDetails(), data.getBasicInfo().getDepartment());
		customerCallPage.openActivityLogTab();
		assertTrue(customerCallPage.isLogIsAddedToActivityLog(data.getBasicInfo().getTitle()));
		apiHelper.deleteCustomerCall(data.getBasicInfo().getTitle());
	}

	@Inject
	LoginPage loginPage;

	@Inject
	DiscussionsPage discussionsPage;

	@Inject
	CustomerCallPage customerCallPage;

	@Inject
	CustomerCallEntity data;

	@Inject
	APIHelper apiHelper;
}
