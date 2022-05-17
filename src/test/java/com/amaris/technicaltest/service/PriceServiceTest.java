package com.amaris.technicaltest.service;

import com.amaris.technicaltest.db.entity.PriceEntity;
import com.amaris.technicaltest.db.repository.PriceRepository;
import com.amaris.technicaltest.dto.PriceDto;
import com.amaris.technicaltest.mapper.PriceMapper;
import com.amaris.technicaltest.testutils.FileReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceServiceTest {

    @Mock
    private PriceRepository repository;

    @Spy
    private PriceMapper mapper = Mappers.getMapper(PriceMapper.class);

    @InjectMocks
    private PriceService service;

    @Test
    void retrieve() throws IOException {
        var priceDto = FileReader.readAsObject("json/Price1.json", PriceDto.class);
        var priceEntity = FileReader.readAsObject("json/Price1.json", PriceEntity.class);

        when(repository.findPriceToApply(priceDto.getStartDate(), priceDto.getProductId(), priceDto.getBrandId()))
                .thenReturn(Mono.just(priceEntity));

        Mono<PriceDto> publisher = service.find(priceDto.getStartDate(), priceDto.getProductId(), priceDto.getBrandId());

        StepVerifier.create(publisher).expectNext(priceDto).verifyComplete();
    }

}
