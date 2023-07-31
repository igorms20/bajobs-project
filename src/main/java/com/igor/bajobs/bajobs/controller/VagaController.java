package com.igor.bajobs.bajobs.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.igor.bajobs.bajobs.dto.VagaDTO;
import com.igor.bajobs.bajobs.model.Vaga;
import com.igor.bajobs.bajobs.service.VagaService;

@RestController
@RequestMapping("/vagas")
@CrossOrigin(origins = "*")
public class VagaController {

    private final VagaService vagaService;

    public VagaController(VagaService vagaService) {
        this.vagaService = vagaService;
    }

    @GetMapping
    public ResponseEntity<List<Vaga>> findAllJobs() {
        // return new ResponseEntity<>(vagaService.findAll(), HttpStatus.OK);
        // HttpHeaders headers = new HttpHeaders();
        // headers.setAccessControlAllowOrigin("*");
        // headers.add("Access-Control-Allow-Origin", "https://the-angular-app.netlify.app");
        return new ResponseEntity<List<Vaga>>(vagaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{jobId}")
    public  ResponseEntity<Vaga> findJobById(@PathVariable Long jobId) {
        return new ResponseEntity<>(vagaService.findById(jobId), HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Vaga>> findJobsByTitle(@RequestParam String query) {
        return new ResponseEntity<>(vagaService.findByTitle(query), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vaga> saveJob(@RequestBody VagaDTO vagaDTO) {
        return new ResponseEntity<>(vagaService.save(vagaDTO.convertToObject()), HttpStatus.CREATED);
    }

    @PutMapping("/{jobId}")
    public ResponseEntity<Vaga> updateJob(@RequestBody VagaDTO vagaDTO, @PathVariable Long jobId) {
        Vaga vaga = vagaDTO.convertToObject();
        return new ResponseEntity<>(vagaService.update(vaga, jobId), HttpStatus.OK);
    }

}
