package com.vedruna.vedrunaBack.services;

import com.vedruna.vedrunaBack.model.ContactMessage;
import com.vedruna.vedrunaBack.repository.ContactMessageRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContactMessageServiceImpl implements ContactMessageService {

    private final ContactMessageRepository repository;

    @Override
    public ContactMessage save(ContactMessage message) {
        return repository.save(message);
    }

    @Override
    public List<ContactMessage> getAll() {
        return repository.findAll();
    }
}
