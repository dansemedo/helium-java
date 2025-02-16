package com.microsoft.azure.helium.app.actor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ActorsService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Get all actors", notes = "Retrieve and return all actors")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "List of actor objects") })
    public ResponseEntity<List<Actor>> getAllActors(
            @ApiParam(value = "The actor name to filter by", required = false) @RequestParam("q") final String query) {
        List<Actor> actors = service.getAllActors(query);
        return new ResponseEntity<>(actors, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get single actor", notes = "Retrieve and return a single actor by actor ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The actor object"),
            @ApiResponse(code = 404, message = "An actor with the specified ID was not found") })
    public ResponseEntity<Actor> getActor(@ApiParam(value = "The ID of the actor to look for", required = true) @PathVariable("id") final String actorId) {
        Optional<Actor> actor = service.getActor(actorId);
        if (actor.isPresent()) {
            return new ResponseEntity<>(actor.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create actor", notes = "Creates an actor")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "The created actor") })
    public ResponseEntity<Actor> createActor(final Actor actor) {
        Actor savedActor = service.createActor(actor);
        return new ResponseEntity<>(savedActor, HttpStatus.OK);
    }
}