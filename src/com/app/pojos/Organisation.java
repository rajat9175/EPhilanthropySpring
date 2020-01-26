package com.app.pojos;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "organisation")
public class Organisation 
{
	private Integer orgId;
	private User user;	// primary key
	private String description;
	private Category category;    //foreign key
	private int amountRequired;
	private int accountNumber;
	private int totalBalance;


	public Organisation()
	{
		super();
	}
	
	


	public Organisation(User user ,String description, Category category, int amountRequired, int accountNumber,
			int totalBalance, Set<Donation> listDoner) {
		super();
		this.user = user;
		this.description = description;
		this.category = category;
		this.amountRequired = amountRequired;
		this.accountNumber = accountNumber;
		this.totalBalance = totalBalance;
	}


	
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true ,fetch = FetchType.EAGER)
	@JoinColumn(name="orgUserId")
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getOrgId() {
		return orgId;
	}


	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "c_organisationId")
	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public int getAmountRequired() {
		return amountRequired;
	}


	public void setAmountRequired(int amountRequired) {
		this.amountRequired = amountRequired;
	}


	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public int getTotalBalance() {
		return totalBalance;
	}


	public void setTotalBalance(int totalBalance) {
		this.totalBalance = totalBalance;
	}


	@Override
	public String toString() {
		return "Organisation [orgId=" + orgId + ", description=" + description + ", category=" + category
				+ ", amountRequired=" + amountRequired + ", accountNumber=" + accountNumber + ", totalBalance="
				+ totalBalance +"]";
	}
	
	


	
}
