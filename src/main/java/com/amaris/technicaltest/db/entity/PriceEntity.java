package com.amaris.technicaltest.db.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table("prices")
@Data
public class PriceEntity {

    @Id
    private Long id;

    private Long brandId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Long fare;

    private Long productId;

    private Long priority;

    private BigDecimal price;

    private String currency;

}
