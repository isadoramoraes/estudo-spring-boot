package com.example.estudospringboot.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class DinossauroDTO {

    @NotNull(message = "O campo nome é obrigatório")
    private String nome;

    @NotNull(message = "O campo classificação alimentar é obrigatório")
    private String classificacaoAlimentar;

    @NotNull(message = "O campo período é obrigatório")
    private String periodo;

    @NotNull(message = "O campo local é obrigatório")
    private String local;

    private String curiosidades;

}
