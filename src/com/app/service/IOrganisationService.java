package com.app.service;

import java.util.List;

import com.app.pojos.Organisation;
import com.app.pojos.User;

public interface IOrganisationService {
	List<User> listDoner();
	
	int addOrg(Organisation o);
}
