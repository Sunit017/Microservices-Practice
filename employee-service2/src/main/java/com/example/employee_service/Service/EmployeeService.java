package com.example.employee_service.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee_service.Entity.Employee;
import com.example.employee_service.FeignClient.AddressClient;
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
	private AddressClient addressClient;

	public EmployeeResponse getEmployeeById(int id)
	{
		Employee employee= employeeRepo.findById(id).get();
 		
		EmployeeResponse employeeResponse= modelMapper.map(employee, EmployeeResponse.class);
		AddressResponse addressResponse = addressClient.getDetailsById(id);
		
		employeeResponse.setAddressResponse(addressResponse);
		return employeeResponse;
		
	}

}
