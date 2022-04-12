package com.mycompany.superherosightings;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@SpringBootApplication
public class SuperHerosApplication implements WebMvcConfigurer {

	
	 private static org.slf4j.Logger logger =  LoggerFactory.getLogger(SuperHerosApplication.class.getName());

	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {

	        // Register resource handler for images
	        registry.addResourceHandler("/photos/**").addResourceLocations("/WEB-INF/photos/")
	                .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	    }
	
	public static void main(String[] args) {
		SpringApplication.run(SuperHerosApplication.class, args);
	}

}

