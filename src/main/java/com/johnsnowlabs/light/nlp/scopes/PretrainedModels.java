package com.johnsnowlabs.light.nlp.scopes;

import com.johnsnowlabs.light.nlp.domain.internal.Pretrained;

import java.util.Map;

public class PretrainedModels {

    private Map<String, Pretrained> pretrainedModel;

    public Map<String, Pretrained> getPretrainedModel() {
        return pretrainedModel;
    }

    public void setPretrainedModel(Map<String, Pretrained> pretrainedModel) {
        this.pretrainedModel = pretrainedModel;
    }
}
