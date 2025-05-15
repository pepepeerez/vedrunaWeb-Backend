package com.vedruna.vedrunaBack.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vedruna.vedrunaBack.model.ContactMessage;

@Repository
public interface ContactMessageRepository extends MongoRepository<ContactMessage, String> {

}
