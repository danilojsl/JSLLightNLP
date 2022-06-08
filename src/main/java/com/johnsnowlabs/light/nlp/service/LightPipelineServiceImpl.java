package com.johnsnowlabs.light.nlp.service;

import com.johnsnowlabs.light.nlp.domain.internal.Pretrained;
import com.johnsnowlabs.light.nlp.models.CacheModels;
import com.johnsnowlabs.nlp.Annotation;
import com.johnsnowlabs.nlp.pretrained.PretrainedPipeline;
import org.springframework.stereotype.Service;
import scala.Option;

import java.util.List;
import java.util.Map;

@Service
public class LightPipelineServiceImpl implements LightPipelineService {


    @Override
    public Map<String, List<String>> annotate(String input, String pretrainedModelName) {

        CacheModels singletonCacheModels = CacheModels.getInstance();
        Pretrained pretrainedModel = singletonCacheModels.getPretrainedModel(pretrainedModelName);

        PretrainedPipeline pretrainedPipeline = new PretrainedPipeline(pretrainedModel.getName(), pretrainedModel.getLanguage(),
                pretrainedModel.getLocation(), false, Option.empty());

        return pretrainedPipeline.annotateJava(input);
    }

    @Override
    public List<Map<String, List<String>>> annotate(List<String> input, String pretrainedModelName) {
        return null;
    }

    @Override
    public Map<String, List<Annotation>> fullAnnotate(String input, String pretrainedModelName) {
        return null;
    }

    @Override
    public List<Map<String, List<Annotation>>> fullAnnotate(List<String> input, String pretrainedModelName) {
        return null;
    }

    @Override
    public Map<String, Pretrained> availableModels() {
        CacheModels singletonCacheModels = CacheModels.getInstance();
        return singletonCacheModels.getAllPretrainedModels();
    }
}
