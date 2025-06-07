package com.vedruna.vedrunaBack.controller;

import com.vedruna.vedrunaBack.model.ContactMessage;
import com.vedruna.vedrunaBack.services.ContactMessageService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vedruna/contacto")
@AllArgsConstructor
public class ContactMessageController {

    private final ContactMessageService service;

    @PostMapping("/enviar")
    public ContactMessage sendMessage(@RequestBody ContactMessage message) {
        return service.save(message);
    }

    @GetMapping("/todos")
    public List<ContactMessage> getAllMessages() {
        return service.getAll();
    }
}
