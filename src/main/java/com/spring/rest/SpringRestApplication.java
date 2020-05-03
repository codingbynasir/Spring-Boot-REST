package com.spring.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringRestApplication {
    private static final Logger logger = LoggerFactory.getLogger(SpringRestApplication.class);
	public static void main(String[] args) {
	    logger.trace("Application is successfully running!");
		SpringApplication.run(SpringRestApplication.class, args);
	}
    @RequestMapping(value = "/")
    public String hello() {
        logger.info("Root is accessed");
        return "Hello World and Hello Spring-Boat";
    }
}
