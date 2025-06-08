package com.vedruna.vedrunaBack.controller;

import com.vedruna.vedrunaBack.cloudinary.CloudinaryService;
import com.vedruna.vedrunaBack.model.Publication;
import com.vedruna.vedrunaBack.services.PublicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vedruna/publications")
@AllArgsConstructor
public class PublicationController {

    private final PublicationService publicationService;
    private final CloudinaryService cloudinaryService;

    /**
     * Obtiene todas las publicaciones existentes.
     *
     * @return Lista de publicaciones.
     */
    @GetMapping
    public List<Publication> getAllPublications() {
        return publicationService.getAllPublications();
    }

    /**
     * Obtiene una publicación por su ID.
     *
     * @param id ID de la publicación.
     * @return Objeto Publication si existe.
     */
    @GetMapping("/{id}")
    public Optional<Publication> getPublicationById(@PathVariable String id) {
        return publicationService.getById(id);
    }

    /**
     * Crea una nueva publicación con una imagen que se sube a Cloudinary.
     *
     * @param title       Título de la publicación.
     * @param description Descripción de la publicación.
     * @param email       Correo del usuario que publica.
     * @param name        Nombre del usuario.
     * @param file        Archivo de imagen.
     * @return Publicación creada.
     * @throws IOException En caso de error con la subida del archivo.
     */
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Publication createPublication(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("email") String email,
            @RequestParam("name") String name,
            @RequestPart("file") MultipartFile file
    ) throws IOException {

        // Subida del archivo a Cloudinary
        String fileUrl = cloudinaryService.uploadFile(file);

        // Crear objeto Publication con la URL de Cloudinary
        Publication publication = new Publication();
        publication.setTitle(title);
        publication.setDescription(description);
        publication.setEmail(email);
        publication.setName(name);
        publication.setImage(fileUrl);

        return publicationService.createPublication(publication);
    }

    /**
     * Actualiza el like de una publicación por parte de un usuario.
     *
     * @param idPublicacion ID de la publicación.
     * @param idUsuario     ID del usuario que da like.
     * @return Publicación actualizada con el nuevo estado de likes.
     */
    @PutMapping("/like/{idPublicacion}/{idUsuario}")
    public Publication updateLike(@PathVariable String idPublicacion, @PathVariable String idUsuario) {
        return publicationService.updateLike(idPublicacion, idUsuario);
    }

    /**
     * Elimina una publicación por su ID.
     *
     * @param id ID de la publicación a eliminar.
     */
    @DeleteMapping("/{id}")
    public void deletePublication(@PathVariable String id) {
        publicationService.deletePublication(id);
    }
}
