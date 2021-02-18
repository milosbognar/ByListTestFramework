package com.milosbognar.buylist.tests;

import com.milosbognar.buylist.core.data.models.Item;
import org.testng.annotations.Test;

import java.util.List;

import static com.milosbognar.buylist.core.data.provider.DataProvider.dataProvider;
import static com.milosbognar.buylist.core.utils.TestContext.getContext;

public class HomePageTest extends BaseTest {

    @Test(groups = {HOME_TEST}, description = "User creates and deletes the list")
    public void testCreateAndRemoveList() {
        String listName = "New List";
        homePage.createNewList(listName)
                .backToHomePage()
                .verifyEmptyListElements(listName)
                .tapOnRemoveListButton(listName)
                .verifyDeleteModalElements()
                .clickButtonOK();
    }

    @Test(groups = {HOME_TEST}, description = "User changes list name")
    public void testListNameChanged() {
        String listName = "New List";
        String newListName = "Changed name";
        homePage.createNewList(listName)
                .backToHomePage()
                .verifyEmptyListElements(listName)
                .tapOnChangeListNameButton(listName)
                .chanageListName(newListName)
                .clickButtonOK()
                .verifyEmptyListElements(newListName);
    }

    @Test(groups = {HOME_TEST}, description = "User doesn't change list name")
    public void testListNameNotChanged() {
        String listName = "New List";
        String newListName = "Changed name";
        homePage.createNewList(listName)
                .backToHomePage()
                .verifyEmptyListElements(listName)
                .tapOnChangeListNameButton(listName)
                .chanageListName(newListName)
                .clickButtonOK()//should be .clickButtonNo
                .verifyEmptyListElements(listName);
    }

    @Test(groups = {HOME_TEST}, description = "Verify that list description is correct")
    public void testVerifyListDescription() {
        List<Item> itemList = dataProvider().subList(0, 3);
        String listName = "Grocery list";
        homePage.createNewList(listName)
                .addItemsToListAndCalculateTotalPrice(itemList)
                .backToHomePage()
                .verifyListElements(listName, (int) getContext().get("itemCount"), (double) getContext().get("sumPrice"));
    }
}
