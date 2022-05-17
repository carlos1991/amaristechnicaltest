package com.amaris.technicaltest;

import com.amaris.technicaltest.testutils.FileReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.io.IOException;

@SpringBootTest
@AutoConfigureWebTestClient
class TechnicalTestIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void get_day14Hour10_productId35455_brandId1() throws IOException {
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/prices")
                        .queryParam("applicationDateTime", "2020-06-14T10:00:00")
                        .queryParam("productId", 35455)
                        .queryParam("brandId", 1)
                        .build())
                .accept(MediaType.APPLICATION_NDJSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody().json(FileReader.readAsString("json/Price1.json"));
    }

    @Test
    void get_day14Hour16_productId35455_brandId1() throws IOException {
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/prices")
                        .queryParam("applicationDateTime", "2020-06-14T16:00:00")
                        .queryParam("productId", 35455)
                        .queryParam("brandId", 1)
                        .build())
                .accept(MediaType.APPLICATION_NDJSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody().json(FileReader.readAsString("json/Price2.json"));
    }

    @Test
    void get_day14Hour21_productId35455_brandId1() throws IOException {
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/prices")
                        .queryParam("applicationDateTime", "2020-06-14T23:00:00")
                        .queryParam("productId", 35455)
                        .queryParam("brandId", 1)
                        .build())
                .accept(MediaType.APPLICATION_NDJSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody().json(FileReader.readAsString("json/Price1.json"));
    }

    @Test
    void get_day15Hour10_productId35455_brandId1() throws IOException {
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/prices")
                        .queryParam("applicationDateTime", "2020-06-15T10:00:00")
                        .queryParam("productId", 35455)
                        .queryParam("brandId", 1)
                        .build())
                .accept(MediaType.APPLICATION_NDJSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody().json(FileReader.readAsString("json/Price3.json"));
    }

    @Test
    void get_day15Hour21_productId35455_brandId1() throws IOException {
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/prices")
                        .queryParam("applicationDateTime", "2020-06-15T21:00:00")
                        .queryParam("productId", 35455)
                        .queryParam("brandId", 1)
                        .build())
                .accept(MediaType.APPLICATION_NDJSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody().json(FileReader.readAsString("json/Price4.json"));
    }

    @Test
    void get_missingRequiredParameter() throws IOException {
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/prices")
                        .queryParam("applicationDateTime", "2020-06-15T21:00:00")
                        .queryParam("productId", 35455)
                        .build())
                .accept(MediaType.APPLICATION_NDJSON)
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    void get_invalidParameterFormat() throws IOException {
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/prices")
                        .queryParam("applicationDateTime", "01-01-2020")
                        .queryParam("productId", 35455)
                        .queryParam("brandId", 1)
                        .build())
                .accept(MediaType.APPLICATION_NDJSON)
                .exchange()
                .expectStatus().isBadRequest();
    }

}
