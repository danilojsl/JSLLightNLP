package com.johnsnowlabs.light.nlp.models;

import com.johnsnowlabs.light.nlp.domain.internal.Pretrained;
import com.johnsnowlabs.nlp.pretrained.ResourceDownloader;
import scala.Option;

import java.util.HashMap;
import java.util.Map;

public class Models {

    private final Map<String, Pretrained> pretrainedModels = new HashMap<>();
    private final String language = "en";

    public Models() {
        loadPublicModels();
        loadClinicalModels();
    }

    private void loadPublicModels() {

        Pretrained pretrained = new Pretrained();
        String publicModels = "public/models";

        pretrained.setLanguage(language);
        pretrained.setLocation(publicModels);
        String modelName =  "albert_xlarge_token_classifier_conll03_pipeline";
        String shortName = "albert_ner";
        pretrained.setName(modelName);
        pretrained.setShortName(shortName);
        pretrained.setDescription("NER generic model with ALBERT embeddings");

        pretrainedModels.put(shortName, pretrained);
        ResourceDownloader.downloadPipeline(pretrained.getName(), Option.apply(pretrained.getLanguage()),
                pretrained.getLocation());
    }

    private void loadClinicalModels() {

        Pretrained pretrained = new Pretrained();
        String clinicalModels = "clinical/models";

        pretrained.setLanguage(language);
        pretrained.setLocation(clinicalModels);
        String modelName =  "clinical_deidentification";
        String shortName = "clinical_deid";
        pretrained.setName(modelName);
        pretrained.setShortName(shortName);
        pretrained.setDescription("DeIdentification clinical model");

        pretrainedModels.put(shortName, pretrained);
        ResourceDownloader.downloadPipeline(pretrained.getName(), Option.apply(pretrained.getLanguage()),
                pretrained.getLocation());
    }

    public Map<String, Pretrained> getPretrainedModels() {
        return pretrainedModels;
    }

}
