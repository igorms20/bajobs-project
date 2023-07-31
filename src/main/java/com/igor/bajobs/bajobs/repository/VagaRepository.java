package com.igor.bajobs.bajobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igor.bajobs.bajobs.model.Vaga;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {
}
