package com.vedruna.vedrunaBack.services;

import com.vedruna.vedrunaBack.model.ContactMessage;

import java.util.List;

public interface ContactMessageService {
    ContactMessage save(ContactMessage message);
    List<ContactMessage> getAll();
}
