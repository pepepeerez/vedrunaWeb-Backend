package com.vedruna.vedrunaBack.services;

import java.util.List;
import java.util.Optional;

import com.vedruna.vedrunaBack.model.Publication;

public interface PublicationService {

    /**
     * Recupera todas las publicaciones disponibles.
     *
     * @return Lista de publicaciones.
     */
    List<Publication> getAllPublications();

    /**
     * Crea una nueva publicación.
     *
     * @param publication Publicación a crear.
     * @return La publicación creada.
     */
    Publication createPublication(Publication publication);

    /**
     * Permite añadir o quitar un "like" a una publicación por parte de un usuario.
     *
     * @param idPublicacion ID de la publicación.
     * @param idUsuario ID del usuario que da el like.
     * @return Publicación actualizada.
     */
    Publication updateLike(String idPublicacion, String idUsuario);

    /**
     * Obtiene una publicación por su ID.
     *
     * @param id ID de la publicación.
     * @return Publicación encontrada (si existe).
     */
    Optional<Publication> getById(String id);

    /**
     * Elimina una publicación por su ID.
     *
     * @param id ID de la publicación a eliminar.
     */
    void deletePublication(String id);
}
