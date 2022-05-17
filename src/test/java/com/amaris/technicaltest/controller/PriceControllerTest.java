package com.amaris.technicaltest.controller;

import com.amaris.technicaltest.dto.PriceDto;
import com.amaris.technicaltest.service.PriceService;
import com.amaris.technicaltest.testutils.FileReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceControllerTest {

    @Mock
    private PriceService service;

    @InjectMocks
    private PriceController controller;

    @Test
    void retrieve() throws IOException {
        var priceDto = FileReader.readAsObject("json/Price1.json", PriceDto.class);

        when(service.find(priceDto.getStartDate(), priceDto.getProductId(), priceDto.getBrandId()))
                .thenReturn(Mono.just(priceDto));

        Flux<PriceDto> publisher = controller.retrieve(priceDto.getStartDate(), priceDto.getProductId(), priceDto.getBrandId());

        StepVerifier.create(publisher).expectNext(priceDto).verifyComplete();
    }

    @Test
    void retrieve_empty() {
        when(service.find(any(LocalDateTime.class), anyLong(), anyLong()))
                .thenReturn(Mono.empty());

        Flux<PriceDto> publisher = controller.retrieve(LocalDateTime.now(), 1L, 1L);

        StepVerifier.create(publisher).verifyComplete();
    }

}
