package com.asigmaventures.assignment.controller;


import com.asigmaventures.assignment.entity.Item;
import com.asigmaventures.assignment.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * REST controller for managing items.
 */
@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
@Slf4j
public class ItemController {

    private final ItemService service;

    /**
     * Creates a new item.
     *
     * @param item the item to create
     * @return a Mono emitting the created item
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Item> createItem(@Valid @RequestBody Item item) {
        log.info("Received request to create item: {}", item);
        return service.createItem(item);
    }

    /**
     * Retrieves an item by its ID.
     *
     * @param id the ID of the item to retrieve
     * @return a Mono emitting the found item
     */
    @GetMapping("/{id}")
    public Mono<Item> getItemById(@PathVariable Long id) {
        log.info("Received request to fetch item with ID: {}", id);
        return service.getItemById(id);
    }

    /**
     * Retrieves all items.
     *
     * @return a Flux emitting all items
     */
    @GetMapping
    public Flux<Item> getAllItems() {
        log.info("Received request to fetch all items");
        return service.getAllItems();
    }
}
