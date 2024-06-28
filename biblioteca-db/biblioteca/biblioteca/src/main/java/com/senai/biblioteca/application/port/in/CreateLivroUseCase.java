package com.senai.biblioteca.application.port.in;

import com.senai.biblioteca.domain.Livro;

public interface CreateLivroUseCase {

    Livro createLivro(Livro livro);

}
