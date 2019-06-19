package com.microsoft.azure.helium.app.actor;

import java.util.List;

import com.microsoft.azure.helium.app.Constants;
import com.microsoft.azure.helium.app.movie.Movie;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Actor
 */
@Getter
@AllArgsConstructor
@Document(collection = Constants.DEFAULT_ACTOR_COLLECTION_NAME)
public class Actor {
    private String id;
    private String actorId;
    private String textSearch;
    private String name;
    private String type;
    private String key;
    private float birthYear;
    private List<String> profession;
    private List<Movie> movies;
}