package com.johnsnowlabs.light.nlp.models;

import com.johnsnowlabs.light.nlp.domain.internal.Pretrained;
import com.johnsnowlabs.light.nlp.scopes.PretrainedModels;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class CacheModels {

    private static CacheModels cacheModels = null;
    public PretrainedModels pretrainedModels;

    private CacheModels() {
        Models models = new Models();
        Map<String, Pretrained> pretrainedModels = models.getPretrainedModels();

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("scopes.xml");
        this.pretrainedModels = (PretrainedModels) applicationContext.getBean("pretrainedModels");
        this.pretrainedModels.setPretrainedModel(pretrainedModels);
    }

    public static CacheModels getInstance() {
        if (cacheModels == null)
            cacheModels = new CacheModels();

        return cacheModels;
    }
    public Pretrained getPretrainedModel(String modelName) {
        return pretrainedModels.getPretrainedModel().get(modelName);
    }

    public Map<String, Pretrained> getAllPretrainedModels() {
        return this.pretrainedModels.getPretrainedModel();
    }

}
