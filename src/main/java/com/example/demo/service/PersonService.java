package com.example.demo.service;

import com.example.demo.dto.IngredientPojo;
import com.example.demo.dto.PersonPojo;
import com.example.demo.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final WebClient personWebClient;

    public Mono<PersonPojo> findById(Long id) {
        return personWebClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/persons/").build(id))
                .retrieve()
                .bodyToMono(PersonPojo.class);
    }

    public Flux<PersonPojo> findAll() {
        return personWebClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/persons").build())
                .retrieve()
                .bodyToFlux(PersonPojo.class);
    }

    public Mono<PersonPojo> create(PersonPojo pojo) {
        return personWebClient.post()
                .uri(uriBuilder -> uriBuilder.path("/api/persons").build())
                .bodyValue(pojo)
                .retrieve()
                .bodyToMono(PersonPojo.class);
    }

    public Mono<PersonPojo> update(PersonPojo pojo) {
        return personWebClient.post()
                .uri(uriBuilder -> uriBuilder.path("/api/persons").build())
                .bodyValue(pojo)
                .retrieve()
                .bodyToMono(PersonPojo.class);
    }

    public void delete(Long id) {
        personWebClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/persons/").build(id))
                .retrieve();
    }
}
