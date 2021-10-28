package com.switchfully.eurder.repository;

import com.switchfully.eurder.api.dto.CreateItemDto;
import com.switchfully.eurder.api.dto.ItemDto;
import com.switchfully.eurder.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class ItemRepository {

    private final HashMap<String, Item> itemRepo = new HashMap<>();

    @Autowired
    public ItemRepository() {
    }

    public Item addItem(Item item) {
        return itemRepo.put(item.getItemId(), item);
    }

    public int size() {
        return itemRepo.size();
    }
}
