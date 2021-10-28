package com.switchfully.eurder.service;

import com.switchfully.eurder.api.dto.CreateItemDto;
import com.switchfully.eurder.domain.Customer;
import com.switchfully.eurder.domain.Price;
import com.switchfully.eurder.repository.CustomerRepository;
import com.switchfully.eurder.repository.ItemRepository;
import com.switchfully.eurder.service.mapper.ItemMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ItemServiceTest {

    Validation validation;
    ItemService itemService;
    ItemRepository itemRepository;
    CustomerRepository customerRepository;
    ItemMapper itemMapper;

    Customer customer1;
    Customer customer2;
    Customer customer3;
    Customer customer4;

    Customer admin;

    CreateItemDto createItemDto;

    @BeforeEach
    void setup() {
        itemMapper = new ItemMapper();
        customer1 = new Customer();
        customer2 = new Customer();
        customer3 = new Customer();
        customer4 = new Customer();
        admin = new Customer().setAdmin(true);

        customerRepository = new CustomerRepository();
        customerRepository.addCustomer(customer1);
        customerRepository.addCustomer(customer2);
        customerRepository.addCustomer(customer3);
        customerRepository.addCustomer(customer4);
        customerRepository.addCustomer(admin);

        validation = new Validation(customerRepository);

        itemRepository = new ItemRepository();
        itemService = new ItemService(itemRepository, validation, itemMapper);


        createItemDto = new CreateItemDto()
                .setName("appel")
                .setDescription("round fruit from a tree")
                .setPrice(new Price(0.25))
                .setAmount(5);
    }

    //addItem() tests

    @Test
    void givenCustomerWithoutAdminRights_whenAddItem_thenThrowIllegalArgumentException() {
        //given
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> itemService.addItem(customer1.getCustomerId(), createItemDto));
    }

    @Test
    void givenAdminRights_whenAddItem_RepoShouldContainOneAdditionalItem() {
        //given
        int initialAmountOfItemsInRepo = itemRepository.size();

        //when
        itemService.addItem(admin.getCustomerId(), createItemDto);

        //then
        assertEquals(initialAmountOfItemsInRepo + 1, itemRepository.size());
    }

    @Test
    void givenItemWithNegativeAmount_whenAddThisItem_thenReturnIllegalArgumentException() {
        //given
        CreateItemDto createItemDtoWithNegativeAmount = new CreateItemDto()
                .setAmount(-2);
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> itemService.addItem(admin.getCustomerId(), createItemDtoWithNegativeAmount));
    }

    @Test
    void givenItemWithNegativePrice_whenAddThisItem_thenReturnIllegalArgumentException() {
        //given
        CreateItemDto createItemDtoWithNegativePrice = new CreateItemDto()
                .setPrice(new Price(-5.3));

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> itemService.addItem(admin.getCustomerId(), createItemDtoWithNegativePrice));
    }

    @Test
    void givenNotAdminRights_whenAddItem_thenReturnIllegalArgumentException() {
        //given
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> itemService.addItem(customer1.getCustomerId(), createItemDto));
    }

    //updateItem() tests

}