package com.example.employee_service.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.employee_service.Response.AddressResponse;
//http://localhost:8091/address/1
@FeignClient(url="http://localhost:8091/",name="address-service")
public interface AddressClient {

@GetMapping("/address/{id}")
AddressResponse getDetailsById(@PathVariable int id);
	
}
