package com.github.uuidcode.java11.test.controller;

import org.junit.Test;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import static org.assertj.core.api.Assertions.assertThat;

public class WebFluxTest {
    @Test
    public void mono() {
        Mono<Integer> mono = Mono.just(1)
            .subscribeOn(Schedulers.single());

        mono.subscribe(item -> assertThat(item).isEqualTo(1));

    }
}
