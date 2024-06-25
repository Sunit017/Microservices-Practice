package com.example.employee_service.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EmployeeConfiguration {

	@Value("${addressService.base.url}")
	private String addressBaseUrl;
	@Bean
	public ModelMapper modelMapper()
	{ 
		return new ModelMapper();
	}
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
	
//	@Bean
//	public WebClient client()
//	{
//		return WebClient
//				.builder()
//				.baseUrl(addressBaseUrl)
//				.build();
//	}
}
