package com.milosbognar.buylist.tests;

import com.milosbognar.buylist.core.data.models.Item;

import org.testng.annotations.Test;

import java.util.List;

import static com.milosbognar.buylist.core.data.provider.DataProvider.dataProvider;
import static org.assertj.core.api.Assertions.assertThat;

public class SettingsPageTest extends BaseTest {

    private final Item item1 = Item.getItem(dataProvider(), "product1");
    private final Item item2 = Item.getItem(dataProvider(), "product2");
    private final Item item3 = Item.getItem(dataProvider(), "product3");

    @Test(groups = {SETTINGS_TEST}, description = "Verify that comment is hidden")
    public void testHideComments() {
        String listName = "Grocery list 2";
        assertThat(homePage.createNewList(listName)
                .addItemToList(item1)
                .openSettings()
                .hideComments()
                .backToAddProductPage()
                .isCommentElementPresent())
                .describedAs("Comment element is present")
                .isFalse();
    }

    @Test(groups = {SETTINGS_TEST}, description = "Verify that unit is hidden")
    public void testHideUnits() {
        String listName = "ShoppingList";
        assertThat(homePage.createNewList(listName)
                .addItemToList(item2)
                .openSettings()
                .hideUnits()
                .backToAddProductPage()
                .isUnitElementPresent())
                .describedAs("Unit element is present")
                .isFalse();
    }

    @Test(groups = {SETTINGS_TEST}, description = "Verify that price is hidden")
    public void testHidePrice() {
        String listName = "Important";
        assertThat(homePage.createNewList(listName)
                .addItemToList(item3)
                .openSettings()
                .hidePrice()
                .backToAddProductPage()
                .isPriceElementPresent())
                .describedAs("Price element is present")
                .isFalse();
    }

    @Test(groups = {SETTINGS_TEST}, description = "Verify that items are sorted by name")
    public void testSortItems() {
        String listName = "Ordered list";
        List<Item> itemList = dataProvider().subList(3, 6);
        assertThat(homePage.createNewList(listName)
                .addItemsToList(itemList)
                .openSettings()
                .openSortListMOdal()
                .chooseByAlphabetOption()
                .backToAddProductPage()
                .areItemsSortedByAlphabet())
                .describedAs("Items are sorted by alphabet")
                .isTrue();
    }

    @Test(groups = {SETTINGS_TEST, DEBUG}, description = "User adds a new category")
    public void testAddNewCategory() {
        String categoryName = "New Category";
        assertThat(homePage.openSettings()
                .openCategoriesList()
                .addNewCategory(categoryName)
                .isNewCategoryCreated(categoryName))
                .describedAs("Category: " + categoryName + " is created")
                .isTrue();
    }

    @Test(groups = {SETTINGS_TEST}, description = "User adds an item from MyList")
    public void testAddItemFromMyList() {
        List<Item> itemList = dataProvider().subList(0, 2);
        String listName = "ListWithMyList";
        homePage.openSettings()
                .openMyList()
                .addItemToList(itemList.get(0));
        assertThat(myListPage.backToSettingsPage()
                .backToHomePage()
                .createNewList(listName)
                .addItemToList(itemList.get(1))
                .openAddFromMyList()
                .addAllMyItemsToList()
                .areItemsPresent(itemList))
                .describedAs("Presence of expected items")
                .isTrue();
    }
}
