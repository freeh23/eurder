package com.switchfully.eurder.service.mapper;

import com.switchfully.eurder.api.dto.CreateItemGroupDto;
import com.switchfully.eurder.api.dto.CreateOrderDto;
import com.switchfully.eurder.domain.ItemGroup;
import com.switchfully.eurder.domain.Order;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class OrderMapper {


    public Order mapCreateOrderDtoToOrder(CreateOrderDto createOrderDto, String customerId) {
        return new Order()
                .setListOfItemGroups(createOrderDto.getListOfCreateItemGroupDto().stream()
                        .map(this::mapCreateItemGroupDtoToItemGroup).collect(Collectors.toList()))
                .setCustomerId(customerId);
    }

    public ItemGroup mapCreateItemGroupDtoToItemGroup(CreateItemGroupDto createItemGroupDto) {
        return new ItemGroup()
                .setItemId(createItemGroupDto.getItemId())
                .setAmountOrdered(createItemGroupDto.getAmountOrdered());
    }
}
