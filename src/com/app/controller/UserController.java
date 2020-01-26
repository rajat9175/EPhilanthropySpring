package com.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Organisation;
import com.app.pojos.User;
import com.app.service.IOrganisationService;
import com.app.service.IUserService;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	IUserService service;
	
	@Autowired
	IOrganisationService orgService;
	
	@PostMapping
	public ResponseEntity<?> registerUser(@RequestBody User u)
	{
		try {
			return new ResponseEntity<User>(service.registerUser(u),HttpStatus.CREATED);

		} catch (Exception e) {

			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/org")
	public ResponseEntity<?> registerOrg(@RequestBody Organisation o)
	{
		try {
			return new ResponseEntity<Integer>(orgService.addOrg(o),HttpStatus.CREATED);

		} catch (Exception e) {

			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@PutMapping("/{userId}")
	public void updateDetails(@RequestBody User u,@PathVariable int userId)
	{
		service.editProfile(u, userId);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> validateUser(@RequestBody User u)
	{	System.out.println("inside validate u"+u);
		
		try {
			User u1 = service.validateUser(u);

			System.out.println(u1.toString());
			return new ResponseEntity<User>(u1, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
 
	}
		
	}
	@GetMapping("/listfoundations")
	public ResponseEntity<?> listFoundations()
	{
		List<Organisation> listFoundations = service.listFoundations();
		if(listFoundations.size()==0)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Organisation>>(listFoundations,HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getOrganisationbyId(@PathVariable int userId)
	{
		Organisation o = service.getOrganisationbyId(userId);
		if(o == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Organisation>(o,HttpStatus.OK);
	}
	@GetMapping("/getuserbyid/{userId}")
	public ResponseEntity<?> getUserbyId(@PathVariable int userId)
	{
		Organisation o = service.getOrganisationbyId(userId);
		if(o == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Organisation>(o,HttpStatus.OK);
	}
	@DeleteMapping("/{orgId}")
	public void deleteOrganisation(@PathVariable int orgId)
	{
		System.out.println("delete");
		//service.deleteUser(orgId);
	}
	

	
}
