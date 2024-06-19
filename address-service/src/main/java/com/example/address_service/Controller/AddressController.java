package com.example.address_service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.address_service.Model.AddressResponse;
import com.example.address_service.Service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/address/{employeeId}")
	public ResponseEntity<AddressResponse> getAddress(@PathVariable("employeeId") int id)
	{
		AddressResponse addressResponse= addressService.getAddressByEmployeeId(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
	}

}
