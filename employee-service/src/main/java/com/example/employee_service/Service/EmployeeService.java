package com.example.employee_service.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.employee_service.Entity.Employee;
import com.example.employee_service.Response.AddressResponse;
import com.example.employee_service.Response.EmployeeResponse;
import com.example.employee_service.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public EmployeeResponse getEmployeeById(int id)
	{
		Employee employee= employeeRepo.findById(id).get();
 		
		EmployeeResponse employeeResponse= modelMapper.map(employee, EmployeeResponse.class);
		AddressResponse addressResponse = restTemplate.getForObject("http://localhost:8091/address/{id}",AddressResponse.class, id);
		
		employeeResponse.setAddressResponse(addressResponse);
	
		return employeeResponse;
	}

}
