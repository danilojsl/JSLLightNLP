package com.johnsnowlabs.light.nlp.service;

import com.johnsnowlabs.light.nlp.domain.internal.Pretrained;
import com.johnsnowlabs.nlp.Annotation;

import java.util.List;
import java.util.Map;

public interface LightPipelineService {

    Map<String, List<String>> annotate(String input, String pretrainedModelName);

    List<Map<String, List<String>>> annotate(List<String> input, String pretrainedModelName);

    Map<String, List<Annotation>> fullAnnotate(String input, String pretrainedModelName);

    List<Map<String, List<Annotation>>> fullAnnotate(List<String> input, String pretrainedModelName);

    Map<String, Pretrained> availableModels();

}
