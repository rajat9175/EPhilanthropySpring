package com.app.pojos;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "donation")
public class Donation 
{
	
	
	private Integer donationId;
	private Organisation orgId;
    private User orgUser;
	private int donationAmount;
	
	public Donation() 
	{
		super();
	}

	public Donation(Integer donationId, Organisation orgId, User orgUser, int donationAmount) {
		super();
		this.donationId = donationId;
		this.orgId = orgId;
		this.orgUser = orgUser;
		this.donationAmount = donationAmount;
	}
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getDonationId()
	{
		return donationId;
	}

	public void setDonationId(Integer donationId) 
	{
		this.donationId = donationId;
	}
    
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "donerId")
	public User getOrgUser() {
		return orgUser;
	}

	public void setOrgUser(User orgUser) {
		this.orgUser = orgUser;
	}

	@OneToOne(cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "orgId")
	public Organisation getOrg() {
		return orgId;
	}

	public void setOrg(Organisation org) {
		this.orgId = org;
	}

	
	
	public int getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(int donationAmount) {
		this.donationAmount = donationAmount;
	}

	@Override
	public String toString() {
		return "Donation [donationId=" + donationId + ", orgUser=" + orgUser
				+ ", donationAmount=" + donationAmount + "]";
	}
	
	
}
