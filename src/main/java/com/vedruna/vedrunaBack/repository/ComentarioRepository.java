package com.vedruna.vedrunaBack.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vedruna.vedrunaBack.model.Comentario;

@Repository
public interface ComentarioRepository extends MongoRepository<Comentario, String> {

    // Método para obtener comentarios por idPublication
    List<Comentario> findByIdPublication(String idPublication);

    // Método para contar comentarios por idPublication
    long countByIdPublication(String idPublication);
}
