package com.switchfully.eurder.service.mapper;

import com.switchfully.eurder.api.dto.CreateItemDto;
import com.switchfully.eurder.api.dto.ItemDto;
import com.switchfully.eurder.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemMapper {

    @Autowired
    public ItemMapper() {
    }


    public Item mapCreateItemDtoToItem(CreateItemDto createItemDto) {
        return new Item()
                .setName(createItemDto.getName())
                .setDescription(createItemDto.getDescription())
                .setPrice(createItemDto.getPrice())
                .setAmount(createItemDto.getAmount());
    }

    public ItemDto mapItemToItemDto(Item item) {
        return new ItemDto()
                .setItemId(item.getItemId())
                .setName(item.getName())
                .setDescription(item.getDescription())
                .setPrice(item.getPrice())
                .setAmount(item.getAmount());
    }


}
