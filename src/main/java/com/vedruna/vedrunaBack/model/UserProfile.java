package com.vedruna.vedrunaBack.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "user_profiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {

    @MongoId
    private String id;

    private String email;           // Clave para buscar perfil único
    private String ciclo;           // Ciclo formativo
    private String curso;           // Curso (1º, 2º, etc)
    private String descripcion;     // Descripción personal
    private String githubLink;      // Link a GitHub (opcional)
    private String linkedinLink;    // Link a LinkedIn (opcional)
}
