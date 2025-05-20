package com.vedruna.vedrunaBack.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.vedrunaBack.model.Comentario;
import com.vedruna.vedrunaBack.services.ComentarioServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/vedruna/comentarios")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class ComentarioController {
    
    private final ComentarioServiceImpl comentarioServiceImpl;

    @GetMapping("/{idPublication}")
    public List<Comentario> getComentariosByIdPublicacion(@PathVariable String idPublication) {
        return comentarioServiceImpl.getComentariosByIdPublication(idPublication);
    }

    @PostMapping
    public Comentario crearComentario(@RequestBody Comentario comentario) {
        return comentarioServiceImpl.crearComentario(comentario);
    }
}
