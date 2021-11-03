package com.kapresoft.springboot.serializeimmutableobjects;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ApplicationInfoConsole implements CommandLineRunner {

    @Value("${spring.application.name:}")
    String applicationName;

    @Override
    public void run(String... args) {
        log.info("{} started.", applicationName);
    }

}
