package com.senai.biblioteca.adapters.in.web;

import com.senai.biblioteca.application.port.in.CreateLivroUseCase;
import com.senai.biblioteca.application.port.in.DeleteLivroUseCase;
import com.senai.biblioteca.application.port.in.GetLivroUseCase;
import com.senai.biblioteca.application.port.in.UpdateLivroUseCase;
import com.senai.biblioteca.domain.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/livros")
@CrossOrigin(origins = "*", maxAge = 8000)
public class LivroController {

    @Autowired
    private CreateLivroUseCase createLivroUseCase;

    @Autowired
    private DeleteLivroUseCase deleteLivroUseCase;

    @Autowired
    private GetLivroUseCase getLivroUseCase;

    @Autowired
    private UpdateLivroUseCase updateLivroUseCase;

    @GetMapping
    public List<Livro> getAllLivros() {
        return getLivroUseCase.getAllLivros();
    }

    @PostMapping()
    public Livro createLivro(@RequestBody Livro livro) {
        return createLivroUseCase.createLivro(livro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> getLivroById(@PathVariable(value = "id") Long livroId) {
        Livro livro = getLivroUseCase.getLivroById(livroId);
        return ResponseEntity.ok().body(livro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> updateLivro(@PathVariable(value = "id") Long livroId,@RequestBody Livro livroDetails) {
        Livro updatedLivro = updateLivroUseCase.updateLivro(livroId, livroDetails);
        return ResponseEntity.ok(updatedLivro);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteLivro(@PathVariable(value = "id") Long livroId) {
        deleteLivroUseCase.deleteLivro(livroId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

