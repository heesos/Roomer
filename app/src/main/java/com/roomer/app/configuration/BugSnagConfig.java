package com.roomer.app.configuration;

import com.bugsnag.Bugsnag;
import com.bugsnag.BugsnagSpringConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(BugsnagSpringConfiguration.class)
public class BugSnagConfig {

    @Bean
    public Bugsnag bugsnag() {
        return new Bugsnag(System.getenv("BugsnagAPIKey"));
    }
}
