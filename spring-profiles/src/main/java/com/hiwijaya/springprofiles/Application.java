package com.hiwijaya.springprofiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})	// ignore auto config, for demo only.
public class Application {

	public static void main(String[] args) {

		SpringApplication application = new SpringApplication(Application.class);

		ConfigurableEnvironment env = new StandardEnvironment();
		env.setActiveProfiles("spring.profiles.active", "dev");
		application.setEnvironment(env);

		//application.setAdditionalProfiles("prod");

		application.run(args);
	}

}
