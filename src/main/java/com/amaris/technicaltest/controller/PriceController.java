package com.amaris.technicaltest.controller;

import com.amaris.technicaltest.dto.PriceDto;
import com.amaris.technicaltest.exception.ErrorDto;
import com.amaris.technicaltest.service.PriceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@RestController
@RequestMapping(PriceController.ENDPOINT)
@Tag(name = "Price Controller")
@RequiredArgsConstructor
@Log4j2
public class PriceController {

    protected static final String ENDPOINT = "/prices";
    private final PriceService service;

    @Operation(
            summary = "Get a price.",
            description = "Get a price with its data."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok",
                    content = @Content(mediaType = MediaType.APPLICATION_NDJSON_VALUE, schema = @Schema(implementation = PriceDto.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorDto.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorDto.class)))
    })
    @GetMapping(
            path = "",
            produces = MediaType.APPLICATION_NDJSON_VALUE
    )
    public Flux<PriceDto> retrieve(
            @RequestParam @Parameter(description = "Application date time (ISO-8601 format without offset)", example = "2020-06-15T17:30:00") LocalDateTime applicationDateTime,
            @RequestParam @Parameter(description = "Product id", example = "35455") Long productId,
            @RequestParam @Parameter(description = "Brand id", example = "1") Long brandId) {
        log.debug("Request parameters: application_date_time={}, product_id={}, brand_id={}", applicationDateTime, productId, brandId);

        return service.find(applicationDateTime, productId, brandId).flux();
    }

}
