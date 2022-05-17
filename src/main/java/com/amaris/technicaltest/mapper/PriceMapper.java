package com.amaris.technicaltest.mapper;

import com.amaris.technicaltest.db.entity.PriceEntity;
import com.amaris.technicaltest.dto.PriceDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface PriceMapper {

    PriceDto toPriceDto(PriceEntity priceEntity);

}
