package com.vedruna.vedrunaBack.model;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "publicaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publication {
    
    @MongoId
    private String idPublication;
    
    private String email;
    private String title;
    private String description;
    private String image;
    private List <String> like = new LinkedList<>();
    private LocalDateTime createdAt = LocalDateTime.now();
    
}
