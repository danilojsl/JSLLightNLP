package com.johnsnowlabs.light.nlp;

import com.johnsnowlabs.light.nlp.models.CacheModels;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJSLLightNLPApp implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(SpringBootJSLLightNLPApp.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJSLLightNLPApp.class, args);
    }

    @Override
    public void run(String... args) {
        CacheModels.getInstance();
        logger.info("Pretrained models downloaded and loaded in memory");
    }

}
