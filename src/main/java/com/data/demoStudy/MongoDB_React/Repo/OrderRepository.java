package com.data.demoStudy.MongoDB_React.Repo;

import com.data.demoStudy.MongoDB_React.TacoOrder;
import com.data.demoStudy.MongoDB_React.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface OrderRepository extends ReactiveCrudRepository<TacoOrder, String> {

    Flux<TacoOrder> findByUserOrderByPlacedAtDesc(User user , Pageable pageable);

}
