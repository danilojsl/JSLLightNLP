package com.johnsnowlabs.light.nlp.controller;

import com.johnsnowlabs.light.nlp.domain.LightResponse;
import com.johnsnowlabs.light.nlp.domain.ModelResponse;
import com.johnsnowlabs.light.nlp.domain.PretrainedRequest;
import com.johnsnowlabs.light.nlp.domain.internal.Pretrained;
import com.johnsnowlabs.light.nlp.mappers.ModelMapper;
import com.johnsnowlabs.light.nlp.mappers.ModelMapperImpl;
import com.johnsnowlabs.light.nlp.service.LightPipelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class LightNLPController {

    @Autowired
    LightPipelineService lightPipelineService;

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        String message = "Health";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/light/models")
    public ResponseEntity<ArrayList<ModelResponse>> availableModels() {
        Map<String, Pretrained> rawResponse = lightPipelineService.availableModels();
        ModelMapper modelMapper = new ModelMapperImpl();

        ArrayList<ModelResponse> modelResponses = new ArrayList<>();
        rawResponse.forEach((modelName, pretrained) -> {
            ModelResponse modelResponse = modelMapper.pretrainedToModelResponse(pretrained);
            modelResponses.add(modelResponse);
        });

        return new ResponseEntity<>(modelResponses, HttpStatus.OK);
    }

    @PostMapping("/light/annotate")
    public ResponseEntity<ArrayList<LightResponse>> annotate(@RequestBody PretrainedRequest pretrainedRequest) {

        Map<String, List<String>> rawResponse = lightPipelineService.annotate(pretrainedRequest.getText(),
                pretrainedRequest.getModelName());

        ArrayList<LightResponse> lightResponses = new ArrayList<>();

        rawResponse.forEach((stage, output) ->
                {
                    LightResponse lightResponse = new LightResponse();
                    lightResponse.setStage(stage);
                    lightResponse.setOutput(output);
                    lightResponses.add(lightResponse);
                }
        );

        return new ResponseEntity<>(lightResponses, HttpStatus.OK);
    }

}
