package com.vedruna.vedrunaBack.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vedruna.vedrunaBack.model.Comentario;
import com.vedruna.vedrunaBack.repository.ComentarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ComentarioServiceImpl implements ComentarioService {

    private final ComentarioRepository comentariosRepository;

    @Override
    public Comentario crearComentario(Comentario comentario) {
        return comentariosRepository.save(comentario);
    }

    @Override
    public List<Comentario> getComentariosByIdPublication(String idPublication) {
        return comentariosRepository.findByIdPublication(idPublication);
    }

    @Override
    public void deleteComentario(String idComentario) {
        comentariosRepository.deleteById(idComentario);
    }

    // Nuevo método para contar comentarios
    @Override
    public long countByIdPublication(String idPublication) {
        return comentariosRepository.countByIdPublication(idPublication);
    }
}
