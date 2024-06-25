package com.example.employee_service.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

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
	
//	@Autowired
//	private WebClient webClient;
//	
	public EmployeeResponse getEmployeeById(int id)
	{
		Employee employee= employeeRepo.findById(id).get();
 		
		EmployeeResponse employeeResponse= modelMapper.map(employee, EmployeeResponse.class);
		AddressResponse addressResponse = callingThroughRestTemplate(id);
				
//				webClient
//				.get()
//				.uri("/address/"+id)
//				.retrieve()
//				.bodyToMono(AddressResponse.class)
//				.block();
		
		employeeResponse.setAddressResponse(addressResponse);
	
		return employeeResponse;
		
	
	}
	public AddressResponse callingThroughRestTemplate(int id)
	{
	return restTemplate.getForObject("http://ADDRESS-SERVICE/address/{id}",AddressResponse.class, id);
	}

}
