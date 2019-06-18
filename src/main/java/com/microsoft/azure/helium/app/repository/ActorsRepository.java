package com.microsoft.azure.helium.app.repository;

import java.util.List;

import com.microsoft.azure.helium.app.model.Actor;
import com.microsoft.azure.spring.data.cosmosdb.repository.DocumentDbRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ActorsRepository extends DocumentDbRepository<Actor, String> {
    List<Actor> findByName(String name); 
}