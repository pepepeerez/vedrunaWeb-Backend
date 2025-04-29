package com.vedruna.vedrunaBack.services;

import java.util.List;
import java.util.Optional;

import com.vedruna.vedrunaBack.model.Publication;

public interface PublicationService {

    List<Publication> getAllPublications(); // Obtiene todas las publicaciones

    Publication createPublication(Publication publication); // Crear una publicacion

    Publication updateLike(String idPublicacion, String idUsuario);  // Dar like a una publicacion

    Optional<Publication> getById(String id); // Obtener una publicacion por su id

    void deletePublication(String id);
} 
