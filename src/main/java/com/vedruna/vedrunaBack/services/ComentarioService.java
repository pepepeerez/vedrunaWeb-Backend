package com.vedruna.vedrunaBack.services;

import java.util.List;

import com.vedruna.vedrunaBack.model.Comentario;

public interface ComentarioService {

    Comentario crearComentario (Comentario comentario);
    List<Comentario> getComentariosByIdPublication (String idPublication);
    void deleteComentario(String idComentario);
} 


