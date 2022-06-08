package com.johnsnowlabs.light.nlp.domain;

public class PretrainedRequest {

    private String modelName;
    private String text;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
