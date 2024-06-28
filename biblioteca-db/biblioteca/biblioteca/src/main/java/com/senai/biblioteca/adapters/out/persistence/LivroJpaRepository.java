package com.senai.biblioteca.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroJpaRepository extends JpaRepository<LivroEntity, Long> {
}
