package com.microsoft.azure.helium.controller;

import java.util.Arrays;
import java.util.List;

import com.microsoft.azure.helium.model.Actor;

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
 * ActorController
 */
@RestController
@RequestMapping(path = "/api/actors", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Actors")
public class ActorsController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Get all actors", notes = "Retrieve and return all actors")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "List of actor objects") })
    public ResponseEntity<List<Actor>> getAllActors(
            @ApiParam(value = "The actor name to filter by") @RequestParam("q") String query) {
        Actor actor = new Actor();
        return new ResponseEntity<>(Arrays.asList(actor), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get single actor", notes = "Retrieve and return a single actor by actor ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The actor object"),
            @ApiResponse(code = 404, message = "An actor with the specified ID was not found") })
    public ResponseEntity<Actor> getActor(
            @ApiParam(value = "The ID of the actor to look for", required = true) @PathVariable("id") String index) {
        Actor actor = new Actor();
        return new ResponseEntity<>(actor, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create actor", notes = "Creates an actor")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "The created actor") })
    public ResponseEntity<List<Actor>> createActor() {
        Actor actor = new Actor();
        return new ResponseEntity<>(Arrays.asList(actor), HttpStatus.OK);
    }

}