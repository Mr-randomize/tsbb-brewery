
package com.iviberberi.brewery.web.mappers;

import com.iviberberi.brewery.domain.Beer;
import com.iviberberi.brewery.domain.BeerOrder;
import com.iviberberi.brewery.domain.BeerOrderLine;
import com.iviberberi.brewery.web.model.BeerOrderDto;
import com.iviberberi.brewery.web.model.BeerOrderLineDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerOrderMapper {

    BeerOrderDto beerOrderToDto(BeerOrder beerOrder);

    BeerOrder dtoToBeerOrder(BeerOrderDto dto);

    BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line);

    default BeerOrderLine dtoToBeerOrder(BeerOrderLineDto dto){
        return BeerOrderLine.builder()
                .orderQuantity(dto.getOrderQuantity())
                .beer(Beer.builder().id(dto.getBeerId()).build())
                .build();
    }
}
