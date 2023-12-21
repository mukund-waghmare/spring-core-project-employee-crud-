package com.ty.driver;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = "com.ty")


public class Config {
	
	@Bean(value = "scanner")
	public Scanner getScanner()
	{
		return new Scanner(System.in);
	}
	

}
