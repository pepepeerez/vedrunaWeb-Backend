package com.vedruna.vedrunaBack.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@AllArgsConstructor
public class ComentarioController {

    private final ComentarioServiceImpl comentarioServiceImpl;

    /**
     * Obtiene todos los comentarios asociados a una publicación.
     *
     * @param idPublication ID de la publicación.
     * @return Lista de comentarios.
     */
    @GetMapping("/{idPublication}")
    public List<Comentario> getComentariosByIdPublicacion(@PathVariable String idPublication) {
        return comentarioServiceImpl.getComentariosByIdPublication(idPublication);
    }

    /**
     * Cuenta cuántos comentarios tiene una publicación.
     *
     * @param idPublication ID de la publicación.
     * @return Número total de comentarios.
     */
    @GetMapping("/count/{idPublication}")
    public long countComentariosByIdPublicacion(@PathVariable String idPublication) {
        return comentarioServiceImpl.countByIdPublication(idPublication);
    }

    /**
     * Crea un nuevo comentario.
     *
     * @param comentario Comentario a crear.
     * @return Comentario creado.
     */
    @PostMapping
    public Comentario crearComentario(@RequestBody Comentario comentario) {
        return comentarioServiceImpl.crearComentario(comentario);
    }

    /**
     * Elimina un comentario por su ID.
     *
     * @param idComentario ID del comentario a eliminar.
     */
    @DeleteMapping("/{idComentario}")
    public void deleteComentario(@PathVariable String idComentario) {
        comentarioServiceImpl.deleteComentario(idComentario);
    }
}
