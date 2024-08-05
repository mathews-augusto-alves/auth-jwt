package br.com.project.infrastructure.adapter.mapper;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MapConverter {

    private final ModelMapper modelMapper;

    public MapConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <M, D> Set<D> convertSetToSet(Collection<M> models, Class<D> targetClass) {
        return models.stream()
                     .map(model -> modelMapper.map(model, targetClass))
                     .collect(Collectors.toSet());
    }
}
