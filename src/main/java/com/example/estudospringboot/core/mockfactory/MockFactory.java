package com.example.estudospringboot.core.mockfactory;

import com.example.estudospringboot.core.dto.DinossauroDTO;
import com.example.estudospringboot.core.model.Dinossauro;

import java.util.List;

public class MockFactory {

    // Massas de dados
    public static DinossauroDTO retornaDinossauroDTO(){
        return DinossauroDTO.builder()
                .nome("Mojoceratops")
                .classificacaoAlimentar("Herbivore")
                .periodo("Cretaceous")
                .local("North America")
                .build();
    }

    // Retornos esperados
    public static List<Dinossauro> retornaListaDinossauros(){
        return List.of(
                Dinossauro.builder()
                        .nome("Yandusaurus")
                        .classificacaoAlimentar("Herbivore")
                        .periodo("Jurassic")
                        .local("Asia")
                        .build(),
                Dinossauro.builder()
                        .nome("Gallimimus")
                        .classificacaoAlimentar("Omnivore")
                        .periodo("Cretaceous")
                        .local("Asia")
                        .build()
        );
    }

    public static Dinossauro retornaDinossauro(){
        return Dinossauro.builder()
                .nome("Mojoceratops")
                .classificacaoAlimentar("Herbivore")
                .periodo("Cretaceous")
                .local("North America")
                .build();
    }
}
