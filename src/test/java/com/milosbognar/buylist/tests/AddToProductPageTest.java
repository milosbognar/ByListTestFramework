package com.milosbognar.buylist.tests;

import com.milosbognar.buylist.core.data.models.Item;
import org.testng.annotations.Test;

import java.util.List;

import static com.milosbognar.buylist.core.data.provider.DataProvider.dataProvider;
import static org.assertj.core.api.Assertions.assertThat;

public class AddToProductPageTest extends BaseTest {

    private final List<Item> itemList = dataProvider().subList(0, 3);

    @Test(description = "Verify that total price is correct")
    public void testIsTotalPriceCorrect() {
        String listName = "Grocery list";
        assertThat(homePage.createNewList(listName)
                .addItemsToListAndCalculateTotalPrice(itemList)
                .isTotalPriceCorrect())
                .describedAs("Total price is correct")
                .isTrue();
    }
}
