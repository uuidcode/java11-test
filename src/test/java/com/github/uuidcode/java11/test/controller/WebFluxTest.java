package com.github.uuidcode.java11.test.controller;

import org.junit.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;

public class WebFluxTest {
    @Test
    public void mono1() {
        Mono<Integer> mono = Mono.just(1)
            .subscribeOn(Schedulers.single());

        mono.subscribe(item -> assertThat(item).isEqualTo(1));
    }

    @Test
    public void mono2() {
        Mono<Integer> mono = Mono.just(1)
            .subscribeOn(Schedulers.single());

        assertThat(mono.block()).isEqualTo(1);
    }

    @Test
    public void mono3() {
        Mono<Integer> mono = Mono.just(1)
            .subscribeOn(Schedulers.single());

        StepVerifier.create(mono)
            .expectNext(1)
            .verifyComplete();
    }

    @Test
    public void flux1() {
        var flux = Flux.just(1, 2, 3)
            .concatWith(Mono.error(new RuntimeException()))
            .subscribeOn(Schedulers.single());

        StepVerifier.create(flux)
            .expectNext(1)
            .expectNext(2)
            .expectNext(3)
            .expectError(RuntimeException.class)
            .verify();
    }
}
