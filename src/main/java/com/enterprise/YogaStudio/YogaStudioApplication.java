package com.enterprise.YogaStudio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class YogaStudioApplication {

	public static void main(String[] args) {
		SpringApplication.run(YogaStudioApplication.class, args);
	}

}
