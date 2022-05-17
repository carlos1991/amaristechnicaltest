package com.amaris.technicaltest.db.repository;

import com.amaris.technicaltest.db.entity.PriceEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public interface PriceRepository extends ReactiveCrudRepository<PriceEntity, String> {

    @Query(value = ""
            + "SELECT id, brand_id, start_date, end_date, "
            + "       fare, product_id, priority, price, "
            + "       currency "
            + "  FROM prices "
            + " WHERE :applicationDateTime BETWEEN start_date AND end_date "
            + "   AND product_id = :productId "
            + "   AND brand_id = :brandId "
            + " ORDER BY priority DESC"
            + " LIMIT 1"
    )
    Mono<PriceEntity> findPriceToApply(@Param("applicationDateTime") LocalDateTime applicationDateTime, @Param("productId") Long productId,
                                       @Param("brandId") Long brandId);

}
