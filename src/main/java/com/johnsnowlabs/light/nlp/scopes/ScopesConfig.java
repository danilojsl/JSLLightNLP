package com.johnsnowlabs.light.nlp.scopes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ScopesConfig {

    @Bean
    @Scope("singleton")
    public PretrainedModels pretrainedModels() {
        return new PretrainedModels();
    }

}