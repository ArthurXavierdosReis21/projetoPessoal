package com.senai.biblioteca.application.port.out;

import com.senai.biblioteca.domain.Livro;

import java.util.List;
import java.util.Optional;

public interface LivroRepository {
    List<Livro> findAll();
    Optional<Livro> findById(Long id);
    Livro save(Livro livro);
    void deleteById(Long id);
}

