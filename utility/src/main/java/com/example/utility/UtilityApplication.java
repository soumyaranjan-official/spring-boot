package com.example.utility;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.utility.util.PrintUtil;

@SpringBootApplication
public class UtilityApplication {

	public static void main(String[] args) {
//		PrintUtil.println("Hello from utility!");
		SpringApplication.run(UtilityApplication.class, args);
	}

}
