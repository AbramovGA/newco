package com.andreitop.newco.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.andreitop.newco.controller",
        "com.andreitop.newco.service",
        "com.andreitop.newco.repository",
        "com.andreitop.newco.config.db"})
public class AppConfig {
}
