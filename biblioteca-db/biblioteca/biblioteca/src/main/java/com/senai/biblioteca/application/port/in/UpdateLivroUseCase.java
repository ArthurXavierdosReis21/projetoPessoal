package com.senai.biblioteca.application.port.in;

import com.senai.biblioteca.domain.Livro;

public interface UpdateLivroUseCase {
    Livro updateLivro(Long livroId, Livro livroDetails);
}
