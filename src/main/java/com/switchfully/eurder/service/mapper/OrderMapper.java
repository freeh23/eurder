package com.switchfully.eurder.service.mapper;

import com.switchfully.eurder.api.dto.CreateOrderDto;
import com.switchfully.eurder.domain.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {


    public Order mapCreateOrderDtoToOrder(CreateOrderDto createOrderDto) {
        return new Order();
    }
}
