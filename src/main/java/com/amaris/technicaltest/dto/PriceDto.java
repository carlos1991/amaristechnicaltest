package com.amaris.technicaltest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Schema(name = "price")
public class PriceDto {

    @Schema(
            description = "Price identifier.",
            required = true,
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Brand identifier (1 = ZARA).",
            required = true,
            example = "1"
    )
    private Long brandId;

    @Schema(
            description = "Date from which the price is applied (ISO-8601 format without offset).",
            required = true,
            example = "2020-06-14T00:00:00"
    )
    private LocalDateTime startDate;

    @Schema(
            description = "Date until which the price is applied (ISO-8601 format without offset).",
            required = true,
            example = "2020-12-31T23:59:59"
    )
    private LocalDateTime endDate;

    @Schema(
            description = "Fare identifier.",
            required = true,
            example = "1"
    )
    private Long fare;

    @Schema(
            description = "Product identifier this prices applies to.",
            required = true,
            example = "35455"
    )
    private Long productId;

    @Schema(
            description = "Priority of the price. If two rates overlap in the date range, the one with the highest priority (highest numerical value) is applied.",
            required = true,
            example = "0"
    )
    private Long priority;

    @Schema(
            description = "Price amount.",
            required = true,
            example = "35.50"
    )
    private BigDecimal price;

    @Schema(
            description = "Price currency.",
            required = true,
            example = "EUR",
            minLength = 3,
            maxLength = 3
    )
    private String currency;

}
