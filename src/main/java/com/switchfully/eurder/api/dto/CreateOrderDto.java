package com.switchfully.eurder.api.dto;

import java.util.List;

public class CreateOrderDto {
    List<CreateItemGroupDto> listOfCreateItemGroup;

    public CreateOrderDto setListOfCreateItemGroupDto(List<CreateItemGroupDto> listOfCreateItemGroup) {
        this.listOfCreateItemGroup = listOfCreateItemGroup;
        return this;
    }

    public List<CreateItemGroupDto> getListOfCreateItemGroupDto() {
        return listOfCreateItemGroup;
    }
}
