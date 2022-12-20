package com.portfolio.BackEnd;

import com.portfolio.BackEnd.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class BackEndApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackEndApplication.class, args);
	}

}
