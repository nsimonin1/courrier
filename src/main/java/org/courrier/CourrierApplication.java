package org.courrier;

import org.courrier.auditing.CurrentTimeDateTimeService;
import org.courrier.auditing.DateTimeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;



@SpringBootApplication
public class CourrierApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourrierApplication.class, args);
	}



}
