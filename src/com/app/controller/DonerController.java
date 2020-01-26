package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.DonateRequest;
import com.app.pojos.DonateResponse;
import com.app.service.IDonateService;

@RestController
@CrossOrigin
@RequestMapping("/donation")
public class DonerController 
{
	@Autowired
	IDonateService service;
	 @PostMapping("/donate")
	  public ResponseEntity<DonateResponse> donate(@RequestBody DonateRequest dr ){
		  DonateResponse donateResponse = new DonateResponse();
		  
		  int receiptId= service.donate(dr.getDonerId(), dr.getDonationAmount(), dr.getOrgId());
	  
		  donateResponse.setDonationRecepitId(receiptId);
		  
		  return new ResponseEntity (donateResponse, HttpStatus.OK);
	  }
	
}
