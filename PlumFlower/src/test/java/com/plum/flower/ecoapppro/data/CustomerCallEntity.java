package com.plum.flower.ecoapppro.data;

import com.plum.flower.ecoapppro.data.base.DataBase;

public class CustomerCallEntity extends DataBase {

	private static final String jsonFile = "src/test/resources/data/customercall/add_customer_call.json";

	public CustomerCallEntity() {
		super(jsonFile);
	}

	private BasicInfo basicInfo;
	private CallDetails callDetails;

	public BasicInfo getBasicInfo() {
		return basicInfo;
	}

	public void setBasicInfo(BasicInfo basicInfo) {
		this.basicInfo = basicInfo;
	}

	public CallDetails getCallDetails() {
		return callDetails;
	}

	public void setCallDetails(CallDetails callDetails) {
		this.callDetails = callDetails;
	}

	public class BasicInfo {

		private String department;
		private String title;
		private String natureOfRequest;

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getNatureOfRequest() {
			return natureOfRequest;
		}

		public void setNatureOfRequest(String natureOfRequest) {
			this.natureOfRequest = natureOfRequest;
		}
	}

	public class CallDetails {

		private String customerName;
		private String customerPhone;
		private String customerAddress;
		private String status;

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public String getCustomerPhone() {
			return customerPhone;
		}

		public void setCustomerPhone(String customerPhone) {
			this.customerPhone = customerPhone;
		}

		public String getCustomerAddress() {
			return customerAddress;
		}

		public void setCustomerAddress(String customerAddress) {
			this.customerAddress = customerAddress;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
	}
}
