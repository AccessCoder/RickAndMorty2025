package org.example.rickandmorty2025.service;

import org.example.rickandmorty2025.model.RickAndMortyChar;
import org.example.rickandmorty2025.model.RickAndMortyResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RickAndMortyService {

    private final RestClient restClient;

    public RickAndMortyService(RestClient.Builder restClient) {
        this.restClient = restClient
                .baseUrl("https://rickandmortyapi.com/api")
                .build();
    }

    public List<RickAndMortyChar> getAllChars() {
        return restClient.get()
                .uri("/character")
                .retrieve()
                .body(RickAndMortyResponse.class)
                .results();

    }

    public RickAndMortyChar getCharById(int id) {
        return restClient.get()
                .uri("/character/"+id)
                .retrieve()
                .body(RickAndMortyChar.class);

    }

    public List<RickAndMortyChar> getCharsByStatus(String status) {
        return restClient.get()
                .uri("/character/?status="+status)
                .retrieve()
                .body(RickAndMortyResponse.class)
                .results();
    }

    public int getSpeciesStatistic(String species) {
        return restClient.get()
                .uri("/character/?species="+species)
                .retrieve()
                .body(RickAndMortyResponse.class)
                .info()
                .count();
    }
}
