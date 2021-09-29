package com.ganesh.controller;


import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @created: 29/09/2021 - 12:53 PM
 * @author: Ganesh
 */


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RequiredArgsConstructor
public class BookControllerIT {

    @LocalServerPort
    int randomServerPort;

    private final TestRestTemplate testRestTemplate;

    @Test
    public void deletingKnownEntityShouldReturn404AfterDeletion() {
        long bookId = 1;

        ResponseEntity<JsonNode> firstResult = this.testRestTemplate
                .getForEntity("/api/books/" + bookId, JsonNode.class);

        assertThat(firstResult.getStatusCode(), is(HttpStatus.OK));

        this.testRestTemplate.delete("/api/books/" + bookId);

        ResponseEntity<JsonNode> secondResult = this.testRestTemplate
                .getForEntity("/api/books/" + bookId, JsonNode.class);

        assertThat(secondResult.getStatusCode(), is(HttpStatus.NOT_FOUND));
    }
}
