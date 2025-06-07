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

    private String name;            
    private String email;           
    private String ciclo;          
    private String curso;  
    private String descripcion;       
    private String linkedinLink;    
    private String githubLink;      
}
