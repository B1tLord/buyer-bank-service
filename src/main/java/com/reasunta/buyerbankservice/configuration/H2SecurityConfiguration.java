package com.reasunta.buyerbankservice.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

//@Configuration
@ConditionalOnProperty(value = "spring.h2.console.enabled", havingValue = "true")
public class H2SecurityConfiguration {


}
