package com.switchfully.eurder.api.controller;

import com.switchfully.eurder.api.dto.CreateOrderDto;
import com.switchfully.eurder.api.dto.OrderDto;
import com.switchfully.eurder.domain.Order;
import com.switchfully.eurder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestHeader String customerId, @RequestBody CreateOrderDto createOrderDto) {
        orderService.createOrder(customerId, createOrderDto);
        //not finished, should return OrderDto
    }
}
