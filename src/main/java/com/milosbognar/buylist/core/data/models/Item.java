package com.milosbognar.buylist.core.data.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Item {

    @JsonProperty("item_id")
    private String itemId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private double price;

    @JsonProperty("amount")
    private double amount;

    @JsonProperty("measure_unit")
    private String measureUnit;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("category")
    private String category;

    public static Item getItem(List<Item> items, String itemId){

        for (Item item : items) {
            if (item.getItemId().equals(itemId))
                return item;
        }
        return null;
    }
}
