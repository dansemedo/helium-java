package com.microsoft.azure.helium.app.genre;

import static org.junit.Assert.assertNotNull;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;

import com.microsoft.azure.helium.Application;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * GenresControllerIT
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringBootTest
public class GenresControllerIT {

    @Autowired
    private GenresController controller;

    @Autowired
    private GenresRepository repository;

    public List<String> getGenresTestCases() {
        return Arrays.asList("Animation", "Comedy", "Sci-Fi", "Thriller", "Western");
    }

    @Before
    public void setupRepositories() {
        List<String> cases = getGenresTestCases();
        List<Genre> genres = GenresUtils.getGenresFromStrings(cases);
        repository.deleteAll();
        repository.saveAll(genres);
    }

    @Test
    public void genresEndpointShouldReturnAllGenres() throws Exception {
        // Arrange
        List<String> cases = getGenresTestCases();

        // Act
        List<String> genres = controller.getAllGenres().getBody();

        // Assert
        assertNotNull(genres);
        assertThat(genres, hasSize(cases.size()));
        assertThat(genres, containsInAnyOrder(cases.toArray()));
    }
}
