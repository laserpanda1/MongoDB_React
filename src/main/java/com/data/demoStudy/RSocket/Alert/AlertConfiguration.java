package com.data.demoStudy.RSocket.Alert;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;

import java.time.Instant;

@Configuration
@Slf4j
public class AlertConfiguration {

    @Bean
    public ApplicationRunner sender(RSocketRequester.Builder requestBuilder) {
        return args -> {
            RSocketRequester tcp = requestBuilder.tcp("localhost", 7000);
            tcp
                    .route("alert")
                    .data(new Alert(
                            Alert.Level.RED, "Panda", Instant.now()))
                    .send()
                    .subscribe();
            log.info("Alert sent");
        };
    }
}
