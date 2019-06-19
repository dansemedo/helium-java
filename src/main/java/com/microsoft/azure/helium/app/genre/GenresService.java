package com.microsoft.azure.helium.app.genre;

import java.lang.reflect.Array;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * GenresService
 */
@Service
public class GenresService {

    @Autowired
    private GenresRepository repository;

	public List<String> getAllGenres() {
        Iterable<Genre> genres = repository.findAll();
        Stream<Genre> genresStream = StreamSupport.stream(genres.spliterator(), false);
        return genresStream.map(g -> g.getGenre()).collect(Collectors.toList());
	}
}