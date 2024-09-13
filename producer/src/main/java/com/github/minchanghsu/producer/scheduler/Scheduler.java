package com.github.minchanghsu.producer.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.minchanghsu.producer.domain.FoodOrder;
import com.github.minchanghsu.producer.service.FoodOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class Scheduler {

    private final FoodOrderService foodOrderService;
    private String[] c = {"apple", "pizza", "coffee", "tea", "hamburger"};
    private List<String> list = Arrays.stream(c).collect(Collectors.toList());

    @Scheduled(fixedRate = 1000)
    public void sendMessage() throws JsonProcessingException {

        FoodOrder order = new FoodOrder()
                .setAmount(new BigDecimal((Math.random() * 100)).setScale(2, RoundingMode.HALF_UP).doubleValue())
                .setItem(list.get((int) Math.floor(Math.random() * list.size())));
        foodOrderService.createFoodOrder(order);
    }

}
