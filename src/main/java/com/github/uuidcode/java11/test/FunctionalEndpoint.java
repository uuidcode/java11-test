package com.github.uuidcode.java11.test;

import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServer;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

public class FunctionalEndpoint {
    public static void main(String[] args){
        var mono = Mono.just("Hello, World");

        HandlerFunction<ServerResponse> serverResponseHandlerFunction =
            request -> ServerResponse.ok().body(fromPublisher(mono, String.class));

        var httpHandler = toHttpHandler(route(path("/hello"), serverResponseHandlerFunction));
        var reactorHttpHandlerAdapter = new ReactorHttpHandlerAdapter(httpHandler);

        HttpServer.create().host("localhost").port(37001)
            .handle(reactorHttpHandlerAdapter)
            .bind()
            .block();
    }
}
