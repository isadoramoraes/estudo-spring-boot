package com.example.estudospringboot.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "dinossauro")
public class Dinossauro {

    @Id
    private String id;

    @CreatedDate
    private LocalDateTime criadoEm;
    @LastModifiedDate
    private LocalDateTime modificadoEm;

    private String nome;
    private String classificacaoAlimentar;
    private String periodo;
    private String local;
    private String curiosidades;
}
