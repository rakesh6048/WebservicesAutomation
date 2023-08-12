package com.WebServisesAutomation;

public class Details {
	
	private String companyName;
	private String emailId;
	
	public Details(String companyName, String emaiId) {
		
		this.companyName = companyName;
		this.emailId = emaiId;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
