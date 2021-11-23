package com.switchfully.eurder.service;

import com.switchfully.eurder.api.dto.CreateOrderDto;
import com.switchfully.eurder.domain.Customer;
import com.switchfully.eurder.repository.CustomerRepositoryFake;
import com.switchfully.eurder.repository.ItemRepository;
import com.switchfully.eurder.repository.OrderRepository;
import com.switchfully.eurder.service.mapper.ItemMapper;
import com.switchfully.eurder.service.mapper.OrderMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private CustomerRepositoryFake customerRepositoryFake;
    private ValidationWithFakeRepo validationWithFakeRepo;
    private OrderService orderService;
    private OrderRepository orderRepository;
    private Customer customer1;
    private CreateOrderDto createOrderDto;
    private OrderMapper orderMapper;
    private ItemService itemService;
    private ItemRepository itemRepository;
    private ItemMapper itemMapper;

    @BeforeEach
    void setUp() {
        orderMapper = new OrderMapper();
        customerRepositoryFake = new CustomerRepositoryFake();
        validationWithFakeRepo = new ValidationWithFakeRepo(customerRepositoryFake);
        orderRepository = new OrderRepository();
        orderService = new OrderService(orderRepository, validationWithFakeRepo, orderMapper);
        itemRepository = new ItemRepository();
        itemMapper = new ItemMapper();
        itemService = new ItemService(itemRepository, validationWithFakeRepo, itemMapper);

        customer1 = Customer.Builder.aCustomer().build();
        customerRepositoryFake.save(customer1);

        createOrderDto = new CreateOrderDto();

    }

    /* Not finished, fails...
    @Test
    void givenCorrectCustomerId_whenCreateOrder_thenExtraOrderInRepository() {
        //given
        int initialNumberOfOrdersInRepo = orderRepository.size();
        //when
        orderService.createOrder(customer1.getCustomerId(), createOrderDto);

        //then
        assertEquals(initialNumberOfOrdersInRepo + 1, orderRepository.size());
    }*/

    @Test
    void givenNonExistingCustomerId_whenCreateOrder_thenThrowNewIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> orderService.createOrder("wrongId", createOrderDto));
    }
/*
    @Test
    void givenItemEnoughInStock_whenCreateOrder_thenShippingDateEqualsTomorrow() {
        //given
        itemRepository.addItem(new Item().setAmount(5));
        itemRepository.getFirstItemForTest();

        //when
        orderService.createOrder(customer1.getCustomerId(), )

        fail();
    }

    @Test
    void givenItemNotEnoughInStock_whenCreateOrder_thenShippingDateEqualsTodayPlus7Days() {
        fail();
    }

    @Test
    void givenOrderWithSeveralItemGroups_whenOrderCreated_thenExpectCorrectTotalPriceOfOrderAndSubtotalPricesPerItemGroup() {
        fail();
    }

    @Test
    void givenItemAmount_whenCreateOrder_thenItemAmountShouldBeAdaptedAccordingly() {
        fail();
    }
*/
}