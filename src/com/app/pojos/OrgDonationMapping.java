package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orgdonationmap" )
public class OrgDonationMapping {
	
	private Integer pk;
	private Integer donerId;
	private Integer orgID;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getPk() {
		return pk;
	}
	
	public void setPk(Integer pk) {
		this.pk = pk;
	}

	public Integer getDonerId() {
		return donerId;
	}
	public void setDonerId(Integer donerId) {
		this.donerId = donerId;
	}
	
	public Integer getOrgID() {
		return orgID;
	}
	public void setOrgID(Integer orgID) {
		this.orgID = orgID;
	}

}
