package com.github.minchanghsu.producer.domain;

import lombok.Data;
import lombok.Value;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FoodOrder {
    String item;
    Double amount;
}
