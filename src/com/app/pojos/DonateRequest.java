package com.app.pojos;

public class DonateRequest {
	
	int donerId;
	int donationAmount;
	int orgId;
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	public int getDonerId() {
		return donerId;
	}
	public void setDonerId(int donerId) {
		this.donerId = donerId;
	}
	public int getDonationAmount() {
		return donationAmount;
	}
	public void setDonationAmount(int donationAmount) {
		this.donationAmount = donationAmount;
	}
	
	
	

}
