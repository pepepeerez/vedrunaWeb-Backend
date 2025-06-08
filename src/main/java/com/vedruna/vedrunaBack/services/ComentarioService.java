package com.vedruna.vedrunaBack.services;

import java.util.List;
import com.vedruna.vedrunaBack.model.Comentario;

public interface ComentarioService {

    /**
     * Crea y guarda un nuevo comentario en la base de datos.
     * 
     * @param comentario Objeto Comentario a guardar.
     * @return El comentario creado.
     */
    Comentario crearComentario(Comentario comentario);

    /**
     * Obtiene todos los comentarios asociados a una publicación específica.
     * 
     * @param idPublication ID de la publicación.
     * @return Lista de comentarios asociados a la publicación.
     */
    List<Comentario> getComentariosByIdPublication(String idPublication);

    /**
     * Elimina un comentario según su ID.
     * 
     * @param idComentario ID del comentario a eliminar.
     */
    void deleteComentario(String idComentario);

    /**
     * Cuenta el número de comentarios asociados a una publicación.
     * 
     * @param idPublication ID de la publicación.
     * @return Número total de comentarios de esa publicación.
     */
    long countByIdPublication(String idPublication);
}
