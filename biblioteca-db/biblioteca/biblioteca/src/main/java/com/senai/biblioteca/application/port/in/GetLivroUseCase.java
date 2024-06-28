package com.senai.biblioteca.application.port.in;

import com.senai.biblioteca.domain.Livro;

import java.util.List;

public interface GetLivroUseCase {
    List<Livro> getAllLivros();

    Livro getLivroById(Long livroId);
}
