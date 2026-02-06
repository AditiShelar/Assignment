package com.asigmaventures.assignment.service.Impl;

import com.asigmaventures.assignment.entity.Item;
import com.asigmaventures.assignment.exception.AsigmaServiceException;
import com.asigmaventures.assignment.exception.ErrorMessageEnum;
import com.asigmaventures.assignment.repository.ItemRepository;
import com.asigmaventures.assignment.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Implementation of the ItemService interface.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ItemServiceImpl implements ItemService {
    private final ItemRepository repository;

    /**
     * Creates a new item.
     *
     * @param item the item to create
     * @return a Mono emitting the created item
     */
    @Override
    public Mono<Item> createItem(Item item) {
        log.info("Creating item: {}", item);
        return repository.save(item)
                .doOnSuccess(savedItem -> log.info("Item created successfully with ID: {}", savedItem.getId()))
                .doOnError(e -> log.error("Error creating item: {}", e.getMessage()));
    }

    /**
     * Retrieves an item by its ID.
     *
     * @param id the ID of the item to retrieve
     * @return a Mono emitting the found item, or an error if not found
     */
    @Override
    public Mono<Item> getItemById(Long id) {
        log.info("Fetching item with ID: {}", id);
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new AsigmaServiceException(ErrorMessageEnum.RECORD_NOT_FOUND)))
                .doOnSuccess(item -> log.info("Item found: {}", item))
                .doOnError(e -> log.error("Error fetching item with ID {}: {}", id, e.getMessage()));
    }

    /**
     * Retrieves all items.
     *
     * @return a Flux emitting all items
     */
    @Override
    public Flux<Item> getAllItems() {
        log.info("Fetching all items");
        return repository.findAll()
                .doOnComplete(() -> log.info("Fetched all items successfully"))
                .doOnError(e -> log.error("Error fetching all items: {}", e.getMessage()));
    }
}
