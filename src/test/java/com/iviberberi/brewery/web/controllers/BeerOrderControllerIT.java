package com.iviberberi.brewery.web.controllers;

import com.iviberberi.brewery.domain.Customer;
import com.iviberberi.brewery.repositories.CustomerRepository;
import com.iviberberi.brewery.web.model.BeerOrderPagedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BeerOrderControllerIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    CustomerRepository customerRepository;

    Customer customer;

    @BeforeEach
    void setUp() {
        customer = customerRepository.findAll().get(0);
    }

    @Test
    void testListOrders() {
        String url = "/api/v1/customers/" + customer.getId().toString() + " /orders";

        BeerOrderPagedList pagedList = testRestTemplate.getForObject(url, BeerOrderPagedList.class);

        assertThat(pagedList.getContent()).hasSize(1);
    }
}
