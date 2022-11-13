package com.example.estudospringboot.controller;

import com.example.estudospringboot.service.impl.DinossauroServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static com.example.estudospringboot.core.mockfactory.MockFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class DinossauroControllerTest {

    @Mock
    private DinossauroServiceImpl dinossauroService;

    @InjectMocks
    private DinossauroController dinossauroController;

    @BeforeEach
    public void init() {
        when(dinossauroService.findAll()).thenReturn(retornaListaDinossauros());
        when(dinossauroService.findById("1")).thenReturn(Optional.ofNullable(retornaDinossauro()));
        when(dinossauroService.insert(retornaDinossauroDTO())).thenReturn(retornaDinossauro());
        when(dinossauroService.update("1", retornaDinossauroDTO()))
                .thenReturn(Optional.ofNullable(retornaDinossauro()));
        when(dinossauroService.deleteById("1")).thenReturn(true);
    }

    @Test
    public void listar() {
        assertEquals(dinossauroController.listar().getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void pesquisar() {
        assertEquals(dinossauroController.pesquisar("1").getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void criar() {
        assertEquals(dinossauroController.criar(retornaDinossauroDTO()).getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    public void atualizar() {
        assertEquals(dinossauroController.atualizar("1", retornaDinossauroDTO()).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void excluir(){
        assertEquals(dinossauroController.excluir("1").getStatusCode(), HttpStatus.OK);
    }

}
