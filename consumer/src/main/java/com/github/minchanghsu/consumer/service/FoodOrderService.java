package com.github.minchanghsu.consumer.service;

import com.github.minchanghsu.consumer.domain.FoodOrder;
import com.github.minchanghsu.consumer.repository.FoodOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FoodOrderService {

    private final FoodOrderRepository foodOrderRepository;

    @Autowired
    public FoodOrderService(FoodOrderRepository foodOrderRepository) {
        this.foodOrderRepository = foodOrderRepository;
    }

    public void persistFoodOrder(FoodOrder foodOrder) {
        FoodOrder persistedFoodOrder = foodOrderRepository.save(foodOrder);
        log.info("food order persisted {}", persistedFoodOrder);


        foodOrderRepository.findAll(PageRequest.of(0, 10));
    }

}
