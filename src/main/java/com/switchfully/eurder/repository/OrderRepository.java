package com.switchfully.eurder.repository;

import com.switchfully.eurder.api.dto.CreateOrderDto;
import com.switchfully.eurder.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class OrderRepository {

    private HashMap<String, Order> orderRepo = new HashMap<String, Order>();

    public int size() {
        return orderRepo.size();
    }

    public Order addOrder(Order order) {
        return orderRepo.put(order.getOrderId(), order);
    }
}
