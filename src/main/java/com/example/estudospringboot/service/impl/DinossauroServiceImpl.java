package com.example.estudospringboot.service.impl;

import com.example.estudospringboot.core.dto.DinossauroDTO;
import com.example.estudospringboot.core.model.Dinossauro;
import com.example.estudospringboot.core.repository.DinossauroRepository;
import com.example.estudospringboot.service.DinossauroService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class DinossauroServiceImpl implements DinossauroService {

    private final ModelMapper modelMapper;
    private final DinossauroRepository dinossauroRepository;

    @Override
    public List<Dinossauro> findAll() {
        return dinossauroRepository.findAll();
    }

    @Override
    public Optional<Dinossauro> findById(String id) {
        return dinossauroRepository.findById(id);
    }

    @Override
    public Dinossauro insert(DinossauroDTO dinossauroDTO) {
        Dinossauro dinossauro = modelMapper.map(dinossauroDTO, Dinossauro.class);

        return dinossauroRepository.save(dinossauro);
    }

    @Override
    public Optional<Dinossauro> update(String id, DinossauroDTO dinossauroDTO) {
        Dinossauro dinossauro = null;

        if (dinossauroRepository.existsById(id)) {
            dinossauro = modelMapper.map(dinossauroDTO, Dinossauro.class);
            dinossauro.setId(id);

            dinossauro = dinossauroRepository.save(dinossauro);
        }

        return Optional.ofNullable(dinossauro);
    }

    @Override
    public void deleteById(String id) {
        dinossauroRepository.deleteById(id);
    }
}
