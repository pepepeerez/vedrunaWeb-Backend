package com.vedruna.vedrunaBack.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vedruna.vedrunaBack.model.Publication;

@Repository
public interface PublicationRepository extends MongoRepository<Publication, String>{
    
    // Buscar publicaciones por email
    List<Publication> findPublicationByEmail(String email);
}
