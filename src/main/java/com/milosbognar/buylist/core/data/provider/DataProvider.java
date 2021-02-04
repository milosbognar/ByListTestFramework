package com.milosbognar.buylist.core.data.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.milosbognar.buylist.core.data.models.Item;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class DataProvider {

    public static List<Item> dataProvider() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return Arrays.asList(mapper.readValue(Paths.get("src/main/resources/data/item.json").toFile(), Item[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
