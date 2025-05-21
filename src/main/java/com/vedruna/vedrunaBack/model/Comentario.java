package com.vedruna.vedrunaBack.model;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "comentarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comentario {
    
    @MongoId
    private String idComentario;

    private String idPublication;
    private String email;
    private String name;
    private String mensaje;
    private LocalDateTime createdAt = LocalDateTime.now();
}
