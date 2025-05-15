package com.vedruna.vedrunaBack.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vedruna.vedrunaBack.model.Publication;
import com.vedruna.vedrunaBack.repository.PublicationRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PublicationServiceImpl implements PublicationService {
    
    private final PublicationRepository publicationRepository;

    @Override
    public List<Publication> getAllPublications() {
        return publicationRepository.findAll();
    }

    @Override
    public Publication createPublication(Publication publication) {
        return publicationRepository.save(publication);
    }

    @Override
    public Optional<Publication> getById(String id) {
        return publicationRepository.findById(id);
    }

    @Override
    public void deletePublication(String id) {
        publicationRepository.deleteById(id);
    }

    @Override
    public Publication updateLike(String idPublicacion, String idUsuario) {
    Optional<Publication> optionalPub = publicationRepository.findById(idPublicacion);

        if (optionalPub.isPresent()) {
            Publication publication = optionalPub.get();
            List<String> likes = publication.getLike();

            if (likes == null) {
                likes = new ArrayList<>();
            }

            if (likes.contains(idUsuario)) {
                likes.remove(idUsuario); // Quitar like
            } else {
                likes.add(idUsuario); // Añadir like
            }

            publication.setLike(likes);
            return publicationRepository.save(publication);
        } else {
            throw new RuntimeException("Publicación no encontrada con ID: " + idPublicacion);
        }
    }

}
