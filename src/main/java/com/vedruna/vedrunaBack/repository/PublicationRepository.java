package com.vedruna.vedrunaBack.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vedruna.vedrunaBack.model.Publication;

public interface PublicationRepository extends MongoRepository<Publication, String>{
    
    List<Publication> findPublicationByEmail(String email);
}
