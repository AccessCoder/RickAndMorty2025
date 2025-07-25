package org.example.rickandmorty2025.model;

import java.util.List;

public record RickAndMortyResponse(RickAndMortyInfo info,
                                   List<RickAndMortyChar> results) {
}
