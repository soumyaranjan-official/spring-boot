package com.org.wrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.utility.util.PrintUtil;


@SpringBootApplication
public class TestWrapperApplication {

	public static void main(String[] args) {
		PrintUtil.println("Hello from utility!");
		SpringApplication.run(TestWrapperApplication.class, args);
	}

}
