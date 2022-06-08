package com.johnsnowlabs.light.nlp.domain;

import java.util.List;

public class LightResponse {

    private String stage;
    private List<String> output;

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public List<String> getOutput() {
        return output;
    }

    public void setOutput(List<String> output) {
        this.output = output;
    }
}
