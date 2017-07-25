package com.lucascorp.pizzaria.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages="com.lucascorp.pizzaria")
public class ConfigurationWeb extends WebMvcConfigurerAdapter{

}
