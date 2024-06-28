package com.senai.biblioteca.application;

import com.senai.biblioteca.application.port.in.CreateLivroUseCase;
import com.senai.biblioteca.application.port.in.DeleteLivroUseCase;
import com.senai.biblioteca.application.port.in.GetLivroUseCase;
import com.senai.biblioteca.application.port.in.UpdateLivroUseCase;
import com.senai.biblioteca.application.port.out.LivroRepository;
import com.senai.biblioteca.domain.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;


@Service
public class LivroService implements CreateLivroUseCase, DeleteLivroUseCase, GetLivroUseCase, UpdateLivroUseCase {

    @Autowired
    private LivroRepository livroRepository;

    @Override
    public List<Livro> getAllLivros() {
        return livroRepository.findAll();
    }

    @Override
    public Livro getLivroById(Long id) {
        return livroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Livro not found for this id :: " + id));
    }

    @Override
    public Livro createLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    @Override
    public Livro updateLivro(Long id, Livro livroDetails) {
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Livro not found for this id :: " + id));

        livro.setFotoCapa(livroDetails.getFotoCapa());
        livro.setNome(livroDetails.getNome());
        livro.setAutor(livroDetails.getAutor());
        livro.setAno(livroDetails.getAno());
        livro.setExemplares(livroDetails.getExemplares());

        return livroRepository.save(livro);
    }

    @Override
    public void deleteLivro(Long id) {
        livroRepository.deleteById(id);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public static class ResourceNotFoundException extends RuntimeException {

        public ResourceNotFoundException(String message) {
            super(message);
        }
    }
}

