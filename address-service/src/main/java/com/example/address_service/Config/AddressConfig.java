package com.example.address_service.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressConfig {
	
	@Bean
	public ModelMapper mapper()
	{
		return new ModelMapper();
	}

}
