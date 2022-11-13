package com.example.estudospringboot.controller;

import com.example.estudospringboot.core.dto.DinossauroDTO;
import com.example.estudospringboot.core.model.Dinossauro;
import com.example.estudospringboot.service.DinossauroService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/dinossauro")
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class DinossauroController {

    private final DinossauroService dinossauroService;

    @GetMapping(value = "/listar")
    public ResponseEntity<Object> listar(){
        return ResponseEntity.ok().body(dinossauroService.findAll().toArray());
    }

    @GetMapping(value = "/pesquisar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Dinossauro>> pesquisar(@PathVariable(value = "id") String id){
        return ResponseEntity.ok().body(dinossauroService.findById(id));
    }

    @PostMapping(value = "/criar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dinossauro> criar(@Valid @RequestBody DinossauroDTO dinossauroDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(dinossauroService.insert(dinossauroDTO));
    }

    @PutMapping(value = "/atualizar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Dinossauro>> atualizar(@RequestParam(value = "id") String id, @Valid @RequestBody DinossauroDTO dinossauroDTO){
        return ResponseEntity.ok()
                .body(dinossauroService.update(id, dinossauroDTO));
    }

    @DeleteMapping(value = "/excluir", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> excluir(@RequestParam(value = "id") String id){
        dinossauroService.deleteById(id);
        return ResponseEntity.ok().body("Dinossauro excluído.");
    }

}
