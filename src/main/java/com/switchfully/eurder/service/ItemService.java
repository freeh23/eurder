package com.switchfully.eurder.service;

import com.switchfully.eurder.api.dto.CreateItemDto;
import com.switchfully.eurder.api.dto.ItemDto;
import com.switchfully.eurder.domain.Item;
import com.switchfully.eurder.repository.ItemRepository;
import com.switchfully.eurder.service.mapper.ItemMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final Validation validation;
    private final ItemMapper itemMapper;
    private final Logger logger = LoggerFactory.getLogger(ItemService.class);

    @Autowired
    public ItemService(ItemRepository itemRepository, Validation validation, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.validation = validation;
        this.itemMapper = itemMapper;
    }

    public ItemDto addItem(String authorizedId, CreateItemDto createItemDto) {
        validation.assertCustomerHasAdminRights(authorizedId);
        validation.assertValueIsNotNegative(createItemDto.getPrice().getPriceValue());
        validation.assertValueIsNotNegative(createItemDto.getAmount());

        Item item = itemMapper.mapCreateItemDtoToItem(createItemDto);
        itemRepository.addItem(item);
        logger.info("addItem(): input ok. Saving new item to the database.");
        return itemMapper.mapItemToItemDto(item);
    }


}
