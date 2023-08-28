package com.igor.bajobs.bajobs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.igor.bajobs.bajobs.model.Vaga;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {

    @Query("SELECT DISTINCT local from vaga")
    public List<String> getLocais();
    
}
