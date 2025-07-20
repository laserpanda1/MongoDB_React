package com.data.demoStudy;

import com.data.demoStudy.MongoDB_React.Repo.OrderRepository;
import com.data.demoStudy.MongoDB_React.TacoOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.test.StepVerifier;

@DataMongoTest
public class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepo;

    @BeforeEach
    public void setup() {
        orderRepo.deleteAll().subscribe();
    }

    @Test
    public void shouldSaveAndFetchOrders() {
        TacoOrder order = createOrder();

        StepVerifier
                .create(orderRepo.save(order))
                .expectNext(order)
                .verifyComplete();

        StepVerifier
                .create(orderRepo.findById(order.getId()))
                .expectNext(order)
                .verifyComplete();
    }

    private TacoOrder createOrder() {
        TacoOrder order = new TacoOrder();
        return order;
    }
}
