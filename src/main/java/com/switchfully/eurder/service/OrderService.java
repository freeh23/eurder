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
    private final ValidationWithFakeRepo validationWithFakeRepo;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderRepository orderRepository, ValidationWithFakeRepo validationWithFakeRepo, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.validationWithFakeRepo = validationWithFakeRepo;
        this.orderMapper = orderMapper;
    }

    public Order createOrder(String customerId, CreateOrderDto createOrderDto) {
        validationWithFakeRepo.assertCustomerIdExistsInTheDatabase(customerId);
        return orderRepository.addOrder(orderMapper.mapCreateOrderDtoToOrder(createOrderDto, customerId));
    }
}
