package com.vedruna.vedrunaBack.services;

import com.vedruna.vedrunaBack.model.ContactMessage;
import java.util.List;

public interface ContactMessageService {

    /**
     * Guarda un nuevo mensaje de contacto.
     *
     * @param message Objeto ContactMessage con la información del mensaje.
     * @return El mensaje guardado.
     */
    ContactMessage save(ContactMessage message);

    /**
     * Devuelve una lista con todos los mensajes de contacto recibidos.
     *
     * @return Lista de mensajes.
     */
    List<ContactMessage> getAll();
}
