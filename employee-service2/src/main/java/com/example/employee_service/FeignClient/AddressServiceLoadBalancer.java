package com.example.employee_service.FeignClient;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

import feign.Feign;

@LoadBalancerClient(name="ADDRESS-SERVICE",configuration = MyCustomerLoadBalancer.class)
public class AddressServiceLoadBalancer {
	
	@LoadBalanced
	@Bean
	public Feign.Builder builder()
	{
		return Feign.builder();
	}

}
