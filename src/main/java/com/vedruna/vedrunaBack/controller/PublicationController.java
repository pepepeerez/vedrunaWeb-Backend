package com.vedruna.vedrunaBack.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vedruna.vedrunaBack.model.Publication;
import com.vedruna.vedrunaBack.services.PublicationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/vedruna/publications")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class PublicationController {

    private final PublicationService publicationService;

    // Carpeta absoluta para uploads dentro del home del usuario
    private final String uploadDir = System.getProperty("user.home") + File.separator + "uploads";

    @GetMapping
    public List<Publication> getAllPublications() {
        return publicationService.getAllPublications();
    }

    @GetMapping("/{id}")
    public Optional<Publication> getPublicationById(@PathVariable String id) {
        return publicationService.getById(id);
    }

    // Endpoint para servir archivos
    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<byte[]> serveFile(@PathVariable String filename) throws IOException {
        File file = new File(uploadDir, filename);
        if (!file.exists()) {
            return ResponseEntity.notFound().build();
        }
        String mimeType = Files.probeContentType(file.toPath());
        byte[] fileContent = Files.readAllBytes(file.toPath());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                .contentType(MediaType.parseMediaType(mimeType != null ? mimeType : "application/octet-stream"))
                .body(fileContent);
    }

    // POST para crear publicación con archivo
    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public Publication createPublication(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("email") String email,
            @RequestParam("name") String name,
            @RequestPart("file") MultipartFile file) throws IOException {

        // Crear carpeta uploads si no existe
        File uploadPath = new File(uploadDir);
        if (!uploadPath.exists()) {
            boolean created = uploadPath.mkdirs();
            if (!created) {
                throw new IOException("No se pudo crear la carpeta uploads en " + uploadDir);
            }
        }

        // Nombre único para el archivo
        String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
        String fileExtension = "";
        int dotIndex = originalFilename.lastIndexOf(".");
        if (dotIndex > 0) {
            fileExtension = originalFilename.substring(dotIndex);
        }
        String uniqueFilename = UUID.randomUUID().toString() + fileExtension;

        // Guardar archivo físicamente
        File destinationFile = new File(uploadPath, uniqueFilename);
        file.transferTo(destinationFile);

        // Crear publicación y guardar URL del archivo
        Publication publication = new Publication();
        publication.setTitle(title);
        publication.setDescription(description);
        publication.setEmail(email);
        publication.setName(name);

        // URL pública para acceder al archivo
        String fileUrl = "http://localhost:8080/vedruna/publications/files/" + uniqueFilename;
        publication.setImage(fileUrl);

        return publicationService.createPublication(publication);
    }

    @PutMapping("/like/{idPublicacion}/{idUsuario}")
    public Publication updateLike(@PathVariable String idPublicacion, @PathVariable String idUsuario) {
        return publicationService.updateLike(idPublicacion, idUsuario);
    }

    @DeleteMapping("/{id}")
    public void deletePublication(@PathVariable String id) {
        publicationService.deletePublication(id);
    }
}
