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

    /**
     * Endpoint para enviar un nuevo mensaje de contacto.
     *
     * @param message Mensaje de contacto recibido desde el frontend.
     * @return Mensaje guardado en la base de datos.
     */
    @PostMapping("/enviar")
    public ContactMessage sendMessage(@RequestBody ContactMessage message) {
        return service.save(message);
    }

    /**
     * Endpoint para obtener todos los mensajes de contacto almacenados.
     *
     * @return Lista de todos los mensajes de contacto.
     */
    @GetMapping("/todos")
    public List<ContactMessage> getAllMessages() {
        return service.getAll();
    }
}
