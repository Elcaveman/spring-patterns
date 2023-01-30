package com.hiwijaya.springprofiles.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Data
@Configuration
@ConfigurationProperties("spring.datasource")
public class DatasourceConfiguration {

    @Value("${app.message}")
    private String message;

    private String driverClassName;
    private String url;
    private String username;
    private String password;


    @Bean
    @Profile("dev")     // applicable on class too
    public void devEnvironmentSetup(){
        System.out.println("[DEV] - Environment");
        System.out.println(driverClassName);
        System.out.println(url);
        System.out.println(message);
    }

    @Bean
    @Profile("prod")
    public void productionEnvironmentSetup(){
        System.out.println("[PRODUCTION] - Environment");
        System.out.println(driverClassName);
        System.out.println(url);
        System.out.println(message);
    }

}
