package com.switchfully.eurder.api.controller;

import com.switchfully.eurder.api.dto.CreateItemDto;
import com.switchfully.eurder.api.dto.ItemDto;
import com.switchfully.eurder.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto addItem(@RequestHeader(name = "authorizedId") String authorizedId, @RequestBody CreateItemDto createItemDto) {
         return itemService.addItem(authorizedId, createItemDto);
    }
}
