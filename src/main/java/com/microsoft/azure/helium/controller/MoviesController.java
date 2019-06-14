package com.microsoft.azure.helium.controller;

import java.util.Arrays;
import java.util.List;

import com.microsoft.azure.helium.model.Movie;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

/**
 * MovieController
 */
@RestController
@RequestMapping(path = "/api/movies", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Movies")
public class MoviesController {

        @RequestMapping(value = "/", method = RequestMethod.GET)
        @ApiOperation(value = "Get all movies", notes = "Retrieve and return all movies")
        @ApiResponses(value = { @ApiResponse(code = 200, message = "List of movie objects") })
        public ResponseEntity<List<Movie>> getAllMovies(
                        @ApiParam(value = "The movie title to filter by") @RequestParam("q") String query) {
                Movie movie = new Movie();
                return new ResponseEntity<>(Arrays.asList(movie), HttpStatus.OK);
        }

        @RequestMapping(value = "/{id}", method = RequestMethod.GET)
        @ApiOperation(value = "Get single movie", notes = "Retrieve and return a single movie by movie ID")
        @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The movie object"),
            @ApiResponse(code = 404, message = "A movie with the specified ID was not found") })
        public ResponseEntity<Movie> getMovie(
                        @ApiParam(value = "The ID of the actor to look for", required = true) @PathVariable("id") String id) {
                Movie movie = new Movie();
                return new ResponseEntity<>(movie, HttpStatus.OK);
        }

        @RequestMapping(value = "/", method = RequestMethod.POST)
        @ResponseStatus(HttpStatus.CREATED)
        @ApiOperation(value = "Create movie", notes = "Creates an movie")
        @ApiResponses(value = { @ApiResponse(code = 201, message = "The created movie") })
        public ResponseEntity<List<Movie>> createMovie() {
                Movie movie = new Movie();
                return new ResponseEntity<>(Arrays.asList(movie), HttpStatus.OK);
        }

        @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
        @ApiOperation(value = "Update movie", notes = "Update a movie")
        @ApiResponses(value = { @ApiResponse(code = 200, message = "The updated movie") })
        public ResponseEntity<Movie> updateMovie(
                        @ApiParam(value = "The ID of the actor to patch", required = true) @PathVariable("id") String id) {
                Movie movie = new Movie();
                return new ResponseEntity<>(movie, HttpStatus.OK);
        }

        @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
        @ResponseStatus(HttpStatus.NO_CONTENT)
        @ApiOperation(value = "Delete movie", notes = "Delete a movie")
        @ApiResponses(value = {
                @ApiResponse(code = 204, message = "The resource was deleted successfully"),
                @ApiResponse(code = 404, message = "A movie with that ID does not exist") })
        public ResponseEntity<Void> deleteMovie(
                        @ApiParam(value = "The ID of the actor to delete", required = true) @PathVariable("id") String id) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}