package com.microsoft.azure.helium.app.actor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * ActorsService
 */
@Service
public class ActorsService {

    @Autowired
    private ActorsRepository repository;

    public List<Actor> getAllActors(String query) {
        if (StringUtils.isEmpty(query)) {
            return (List<Actor>) repository.findAll();
        } else {
            return repository.findByTextSearchContaining(query.toLowerCase());
        }
    }

    public Optional<Actor> getActor(String actorId) {
        if (StringUtils.isEmpty(actorId)) {
            throw new NullPointerException("actorId cannot be empty or null");
        }

        List<Actor> actors = repository.findByActorId(actorId);
        if (actors.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(actors.get(0));
        }
    }

    public Actor createActor(Actor actor) {
        if (actor.equals(null)) {
            throw new NullPointerException("actor cannot be null");
        }

        return repository.save(actor);
    }
}