//User------------> 1.Register(Post)
//					2.Edit profile(Put)
//		 			3.Change Password(Put)
//					4.login(post)
//Admin-----------> 1.List Foundation(Get)
//		  			2.Manage Foundation(Get,Delete)
//Organisation----> 1.List Doner(Get)
//				 	2.Account Information(Get)

//Doner-----------> 1.Donate(POST)





package com.app.dao;

import java.util.List;

import com.app.pojos.Organisation;
import com.app.pojos.User;

public interface IUserDao 
{
	User register(User u);
	void editProfile(User u);
	User validateUser(User u);
	List<Organisation> listFoundations();
	Organisation getOrganisationbyId(int id);
	User getUserbyId(int id);

	void deleteOrganisation(Organisation u);
	
	
}
