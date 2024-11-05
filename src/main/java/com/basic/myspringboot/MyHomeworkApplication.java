package com.basic.myspringboot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyHomeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyHomeworkApplication.class, args);
	}

	// Configuration의 역할을 한다.
	// Object Mapping을 지원하는 ModelMapper를 SpringBean 으로 설정한다.
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
