package com.Assigment.assignment.Repository;



import com.Assigment.assignment.Entity.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ItemRepository {


    private final List<Item> items = new ArrayList<>();
    private long counter = 1;

    public Item save(Item item) {
        item.setId(counter++);
        items.add(item);
        return item;
    }

    public Optional<Item> findById(Long id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }
}
