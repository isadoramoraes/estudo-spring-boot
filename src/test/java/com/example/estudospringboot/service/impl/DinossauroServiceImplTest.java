package com.example.estudospringboot.service.impl;

import com.example.estudospringboot.core.model.Dinossauro;
import com.example.estudospringboot.core.repository.DinossauroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static com.example.estudospringboot.core.mockfactory.MockFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class DinossauroServiceImplTest {

    @Mock
    private DinossauroRepository dinossauroRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private DinossauroServiceImpl dinossauroService;

    @BeforeEach
    public void init(){
        when(modelMapper.map(retornaDinossauroDTO(), Dinossauro.class)).thenReturn(retornaDinossauro());

        when(dinossauroRepository.findAll()).thenReturn(List.of());
        when(dinossauroRepository.findById("1")).thenReturn(Optional.ofNullable(retornaDinossauro()));
        when(dinossauroRepository.save(retornaDinossauro())).thenReturn(retornaDinossauro());
        when(dinossauroRepository.existsById("1")).thenReturn(true);
    }

    @Test
    public void findAll() {
        assertEquals(dinossauroService.findAll(), List.of());
    }

    @Test
    public void findById() {
        assertEquals(dinossauroService.findById("1"), Optional.ofNullable(retornaDinossauro()));
    }

    @Test
    public void insert() {
        assertEquals(dinossauroService.insert(retornaDinossauroDTO()), retornaDinossauro());
    }

    @Test
    public void save() {
        assertEquals(dinossauroService.update("1", retornaDinossauroDTO()), Optional.empty());
    }

    @Test
    public void saveNonExistent() {
        assertEquals(dinossauroService.update("2", retornaDinossauroDTO()), Optional.empty());
    }

    @Test
    public void deleteById() {
        assertTrue(dinossauroService.deleteById("1"));
    }

}
