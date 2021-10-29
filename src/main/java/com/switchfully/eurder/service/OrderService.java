package com.switchfully.eurder.service;

import com.switchfully.eurder.api.dto.CreateOrderDto;
import com.switchfully.eurder.domain.Order;
import com.switchfully.eurder.repository.OrderRepository;
import com.switchfully.eurder.service.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final Validation validation;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderRepository orderRepository, Validation validation, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.validation = validation;
        this.orderMapper = orderMapper;
    }

    public Order createOrder(String customerId, CreateOrderDto createOrderDto) {
        validation.assertCustomerIdExistsInTheDatabase(customerId);

        return orderRepository.addOrder(orderMapper.mapCreateOrderDtoToOrder(createOrderDto));
    }
}
