
package com.iviberberi.brewery.services;

import com.iviberberi.brewery.web.model.BeerDto;
import com.iviberberi.brewery.web.model.BeerPagedList;
import com.iviberberi.brewery.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {
    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest);

    BeerDto findBeerById(UUID beerId);
}
