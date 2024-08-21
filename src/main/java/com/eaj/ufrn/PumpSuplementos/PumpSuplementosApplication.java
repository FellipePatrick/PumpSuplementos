package com.eaj.ufrn.PumpSuplementos;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PumpSuplementosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PumpSuplementosApplication.class, args);
	}

	@Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    };

}
