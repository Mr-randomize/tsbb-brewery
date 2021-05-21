
package com.iviberberi.brewery.web.mappers;

import com.iviberberi.brewery.domain.Beer;
import com.iviberberi.brewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
