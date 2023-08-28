package com.igor.bajobs.bajobs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.igor.bajobs.bajobs.exception.JobNotFoundException;
import com.igor.bajobs.bajobs.model.Vaga;
import com.igor.bajobs.bajobs.repository.VagaRepository;

@Service
public class VagaService {

    private final VagaRepository vagaRepository;

    public VagaService(VagaRepository vagaRepository) {
        this.vagaRepository = vagaRepository;
    }

    @Transactional
    public List<Vaga> findAll() {
        return vagaRepository.findAll();
    }

    @Transactional
    public Vaga findById(Long id) {
        return vagaRepository.findById(id).orElseThrow(() -> new JobNotFoundException("Vaga não encontrada"));
    }

    @Transactional
    public List<Vaga> findByTitle(String query) {
        List<Vaga> filteredJobs = findAll().stream()
                .filter(vaga -> vaga.getTitulo().equalsIgnoreCase(query))
                .toList();

        if (filteredJobs.isEmpty()) {
            throw new JobNotFoundException("Vaga não encontrada");
        }

        return filteredJobs;
    }

    @Transactional
    public Vaga save(Vaga vaga) {

        return vagaRepository.save(vaga);
    }

    @Transactional
    public Vaga update(Vaga vaga, Long jobId) {
        if (vagaRepository.findById(jobId).isEmpty()) {
            throw new JobNotFoundException("Vaga não encontrada");
        }

        vaga.setId(jobId);
        return vagaRepository.save(vaga);

    }

    public List<String> getAllLocais() {
        List<Vaga> vagas = findAll();
        List<String> locais = new ArrayList<>();

        vagas.forEach(vaga -> {
            if (!locais.contains(vaga.getLocal())) {
                locais.add(vaga.getLocal());
            }
        });

        return locais;
    }
 }
