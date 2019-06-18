package com.microsoft.azure.helium.app.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Movie
 */
public class Movie {
  private String id;
  private String movieId;
  private String textSearch;
  private String title;
  private String type;
  private String key;
  private float year;
  private float rating;
  private float votes;
  List<String> genres = new ArrayList<String>();
  List<Actor> roles = new ArrayList<Actor>();

  // Getter Methods

  public String getId() {
    return id;
  }

  public String getMovieId() {
    return movieId;
  }

  public String getTextSearch() {
    return textSearch;
  }

  public String getTitle() {
    return title;
  }

  public String getType() {
    return type;
  }

  public String getKey() {
    return key;
  }

  public float getYear() {
    return year;
  }

  public float getRating() {
    return rating;
  }

  public float getVotes() {
    return votes;
  }

  public List<String> getGenres() {
    return genres;
  }

  public List<Actor> getRoles() {
    return roles;
  }

  // Setter Methods

  public void setId(String id) {
    this.id = id;
  }

  public void setMovieId(String movieId) {
    this.movieId = movieId;
  }

  public void setTextSearch(String textSearch) {
    this.textSearch = textSearch;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public void setYear(float year) {
    this.year = year;
  }

  public void setRating(float rating) {
    this.rating = rating;
  }

  public void setVotes(float votes) {
    this.votes = votes;
  }
}