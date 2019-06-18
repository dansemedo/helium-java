package com.microsoft.azure.helium.app.model;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.azure.helium.config.Constants;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;

/**
 * Actor
 */
@Document(collection = Constants.DEFAULT_ACTOR_COLLECTION_NAME)
public class Actor {
    private String id;
    private String actorId;
    private String textSearch;
    private String name;
    private String type;
    private String key;
    private float birthYear;
    List<String> profession = new ArrayList<String>();
    List<Movie> movies = new ArrayList<Movie>();

    // Getter Methods

    public String getId() {
        return id;
    }

    public String getActorId() {
        return actorId;
    }

    public String getTextSearch() {
        return textSearch;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getKey() {
        return key;
    }

    public float getBirthYear() {
        return birthYear;
    }

    public List<String> getProfession() {
        return profession;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    // Setter Methods

    public void setId(String id) {
        this.id = id;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public void setTextSearch(String textSearch) {
        this.textSearch = textSearch;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setBirthYear(float birthYear) {
        this.birthYear = birthYear;
    }
}