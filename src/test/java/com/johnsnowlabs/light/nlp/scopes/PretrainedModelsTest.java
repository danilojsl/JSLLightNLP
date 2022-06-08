package com.johnsnowlabs.light.nlp.scopes;

import com.johnsnowlabs.light.nlp.domain.internal.Pretrained;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

class PretrainedModelsTest {

    @Test
    public void shouldReturnCacheModelsWhenModelsAreLoaded() {

        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("scopes.xml");
        PretrainedModels cacheModelsA = (PretrainedModels) applicationContext.getBean("pretrainedModels");
        PretrainedModels cacheModelsB = (PretrainedModels) applicationContext.getBean("pretrainedModels");

        Pretrained pretrained = new Pretrained();
        pretrained.setLanguage("en");
        pretrained.setLocation("path/models");
        pretrained.setName("my_model");

        Map<String, Pretrained> models = new HashMap<>();
        models.put("some_model", pretrained);
        cacheModelsA.setPretrainedModel(models);

        Pretrained someModel = cacheModelsB.getPretrainedModel().get("some_model");

        Assertions.assertEquals(pretrained, someModel);
        applicationContext.close();
    }

}