package com.igor.bajobs.bajobs.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igor.bajobs.bajobs.service.VagaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/locais")
public class LocalController {

    private final VagaService vagaService;

    public LocalController(VagaService vagaService) {
        this.vagaService = vagaService;
    }
    
    @GetMapping()
    public ResponseEntity<List<String>> getLocais() {
        return ResponseEntity.ok(vagaService.getAllLocais());

    }

}
