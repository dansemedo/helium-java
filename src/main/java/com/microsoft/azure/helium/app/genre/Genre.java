package com.microsoft.azure.helium.app.genre;

import com.microsoft.azure.helium.app.Constants;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Genre
 */
@Getter
@AllArgsConstructor
@Document(collection = Constants.DEFAULT_GENRE_COLLECTION_NAME)
public class Genre {
    private String id;
    private String key;
    private String type;
    private String genre;
}