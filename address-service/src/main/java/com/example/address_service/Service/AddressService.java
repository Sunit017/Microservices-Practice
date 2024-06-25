package com.example.address_service.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.address_service.Entity.Address;
import com.example.address_service.Model.AddressResponse;
import com.example.address_service.Repo.AddressRepo;

@Service
public class AddressService {

	@Autowired
	private AddressRepo addressRepo;
	@Autowired
	private ModelMapper mapper;
	
	public AddressResponse getAddressByEmployeeId(int employeeId)
	{
		Address address= addressRepo.findAddressByEmployeeId(employeeId);
		AddressResponse response= mapper.map(address, AddressResponse.class);
		System.out.println("Employee"+ employeeId);
		return response;
	}
}
