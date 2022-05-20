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
        executeGetPricesRequest("2020-06-14T10:00:00", 35455, 1)
                .expectStatus().isOk()
                .expectBody().json(FileReader.readAsString("json/Price1.json"));
    }

    @Test
    void get_day14Hour16_productId35455_brandId1() throws IOException {
        executeGetPricesRequest("2020-06-14T16:00:00", 35455, 1)
                .expectStatus().isOk()
                .expectBody().json(FileReader.readAsString("json/Price2.json"));
    }

    @Test
    void get_day14Hour21_productId35455_brandId1() throws IOException {
        executeGetPricesRequest("2020-06-14T23:00:00", 35455, 1)
                .expectStatus().isOk()
                .expectBody().json(FileReader.readAsString("json/Price1.json"));
    }

    @Test
    void get_day15Hour10_productId35455_brandId1() throws IOException {
        executeGetPricesRequest("2020-06-15T10:00:00", 35455, 1)
                .expectStatus().isOk()
                .expectBody().json(FileReader.readAsString("json/Price3.json"));
    }

    @Test
    void get_day15Hour21_productId35455_brandId1() throws IOException {
        executeGetPricesRequest("2020-06-15T21:00:00", 35455, 1)
                .expectStatus().isOk()
                .expectBody().json(FileReader.readAsString("json/Price4.json"));
    }

    @Test
    void get_missingRequiredParameter() {
        executeGetPricesRequest("2020-06-15T21:00:00", 35455, null)
                .expectStatus().isBadRequest();
    }

    @Test
    void get_invalidParameterFormat() {
        executeGetPricesRequest("01-01-2020", 35455, 1)
                .expectStatus().isBadRequest();
    }

    private WebTestClient.ResponseSpec executeGetPricesRequest(String applicationDateTime, Integer productId, Integer brandId) {
        return webTestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/prices")
                        .queryParam("applicationDateTime", applicationDateTime)
                        .queryParam("productId", productId)
                        .queryParam("brandId", brandId)
                        .build())
                .accept(MediaType.APPLICATION_NDJSON)
                .exchange();
    }

}
