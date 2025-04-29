package com.vedruna.vedrunaBack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.vedrunaBack.model.Publication;
import com.vedruna.vedrunaBack.services.PublicationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/vedruna/publications")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class PublicationController {
    
    private final PublicationService publicationService;

    @GetMapping
    public List<Publication> getAllPublications() {
        return publicationService.getAllPublications();
    }

    @GetMapping("/{id}")
    public Optional<Publication> getPublicationById(@PathVariable String id) {
        return publicationService.getById(id);
    }

    @PostMapping
    public Publication createPublication(@RequestBody Publication publication) {
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
