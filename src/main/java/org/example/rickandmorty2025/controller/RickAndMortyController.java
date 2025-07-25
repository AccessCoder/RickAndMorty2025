package org.example.rickandmorty2025.controller;


import org.example.rickandmorty2025.model.RickAndMortyChar;
import org.example.rickandmorty2025.service.RickAndMortyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rick")
public class RickAndMortyController {

    private final RickAndMortyService service;

    public RickAndMortyController(RickAndMortyService service) {
        this.service = service;
    }

    @GetMapping
    public List<RickAndMortyChar> getAllChars(){
        return service.getAllChars();
    }

    @GetMapping("/{id}")
    public RickAndMortyChar getCharById(@PathVariable int id){
        return service.getCharById(id);
    }
}
