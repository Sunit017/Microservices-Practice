package com.example.employee_service.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.employee_service.Response.AddressResponse;

@FeignClient(name="ADDRESS-SERVICE")
public interface AddressClient {

@GetMapping("/address/{id}")
AddressResponse getDetailsById(@PathVariable int id);
	
}
