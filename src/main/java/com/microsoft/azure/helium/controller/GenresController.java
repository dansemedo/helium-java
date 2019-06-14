package com.microsoft.azure.helium.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

/**
 * GenreController
 */
@RestController
@RequestMapping(path = "/api/genres", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Genres")
public class GenresController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Get all genres", notes = "Retrieve and return all genres")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "List of genres objects") })
    public ResponseEntity<List<String>> getGenre() {
        return new ResponseEntity<>(Arrays.asList("sample"), HttpStatus.OK);
    }
}