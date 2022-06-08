package com.johnsnowlabs.light.nlp.mappers;

import com.johnsnowlabs.light.nlp.domain.ModelResponse;
import com.johnsnowlabs.light.nlp.domain.internal.Pretrained;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ModelMapper {

    @Mapping(target="modelName", source = "pretrained.shortName")
    ModelResponse pretrainedToModelResponse(final Pretrained pretrained);

}
