package com.asigmaventures.assignment.service;

import com.asigmaventures.assignment.entity.Item;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service interface for managing Item entities.
 */
public interface ItemService {

    /**
     * Creates a new item.
     *
     * @param item the item to create
     * @return a Mono emitting the created item
     */
    Mono<Item> createItem(Item item);

    /**
     * Retrieves an item by its ID.
     *
     * @param id the ID of the item to retrieve
     * @return a Mono emitting the found item, or empty if not found
     */
    Mono<Item> getItemById(Long id);

    /**
     * Retrieves all items.
     *
     * @return a Flux emitting all items
     */
    Flux<Item> getAllItems();
}
