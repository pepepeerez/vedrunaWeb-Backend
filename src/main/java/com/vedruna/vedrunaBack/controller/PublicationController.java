// ACTUALIZADO PARA USAR CLOUDINARY

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
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class PublicationController {

    private final PublicationService publicationService;
    private final CloudinaryService cloudinaryService;

    @GetMapping
    public List<Publication> getAllPublications() {
        return publicationService.getAllPublications();
    }

    @GetMapping("/{id}")
    public Optional<Publication> getPublicationById(@PathVariable String id) {
        return publicationService.getById(id);
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Publication createPublication(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("email") String email,
            @RequestParam("name") String name,
            @RequestPart("file") MultipartFile file
    ) throws IOException {

        String fileUrl = cloudinaryService.uploadFile(file);

        Publication publication = new Publication();
        publication.setTitle(title);
        publication.setDescription(description);
        publication.setEmail(email);
        publication.setName(name);
        publication.setImage(fileUrl);

        return publicationService.createPublication(publication);
    }

    @PutMapping("/like/{idPublicacion}/{idUsuario}")
    public Publication updateLike(@PathVariable String idPublicacion, @PathVariable String idUsuario) {
        return publicationService.updateLike(idPublicacion, idUsuario);
    }

    @DeleteMapping("/{id}")
    public void deletePublication(@PathVariable String id) {
        publicationService.deletePublication(id);
    }
}
