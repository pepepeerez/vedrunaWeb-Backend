package com.vedruna.vedrunaBack.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "contact_messages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactMessage {

    @MongoId
    private String id;

    private String nombre;
    private String email;
    private String mensaje;

    private String fecha; // opcional: puedes guardar la fecha si quieres
}
