package com.amaris.technicaltest.service;

import com.amaris.technicaltest.db.repository.PriceRepository;
import com.amaris.technicaltest.dto.PriceDto;
import com.amaris.technicaltest.mapper.PriceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PriceService {

    private final PriceRepository repository;
    private final PriceMapper mapper;

    public Mono<PriceDto> find(LocalDateTime applicationDateTime, Long productId, Long brandId) {
        return repository.findPriceToApply(applicationDateTime, productId, brandId)
                .map(mapper::toPriceDto);
    }

}
