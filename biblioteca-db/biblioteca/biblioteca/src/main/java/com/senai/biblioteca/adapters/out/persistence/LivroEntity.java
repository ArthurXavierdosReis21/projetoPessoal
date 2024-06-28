package com.senai.biblioteca.adapters.out.persistence;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "livros")
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = Integer.MAX_VALUE)
    private String fotoCapa;

    private String nome;
    private String autor;
    private Integer ano;
    private Integer exemplares;

}
