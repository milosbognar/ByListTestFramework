package com.milosbognar.buylist.tests;

import com.milosbognar.buylist.core.DriverManager;
import com.milosbognar.buylist.core.utils.Utilities;
import com.milosbognar.buylist.test.pages.addProduct.AddFromMyListPage;
import com.milosbognar.buylist.test.pages.addProduct.AddProductPage;
import com.milosbognar.buylist.test.pages.addProduct.MyListPage;
import com.milosbognar.buylist.test.pages.home.DeleteModal;
import com.milosbognar.buylist.test.pages.home.EditNameModal;
import com.milosbognar.buylist.test.pages.home.HomePage;
import com.milosbognar.buylist.test.pages.settings.CategoriesListPage;
import com.milosbognar.buylist.test.pages.settings.SettingsPage;
import com.milosbognar.buylist.test.pages.settings.SortListModal;
import org.testng.annotations.*;

import java.io.IOException;

import static com.milosbognar.buylist.core.utils.Utilities.reopenApp;

public abstract class BaseTest {

    protected AddFromMyListPage addFromMyListPage;
    protected AddProductPage addProductPage;
    protected MyListPage myListPage;

    protected DeleteModal deleteModal;
    protected EditNameModal editNameModal;
    protected HomePage homePage;

    protected CategoriesListPage categoriesListPage;
    protected SettingsPage settingsPage;
    protected SortListModal sortListModal;

    protected Utilities utilities;

//    @BeforeSuite(alwaysRun = true)
//    public void beforeSuite() throws IOException, InterruptedException {
//
//    }

//    @BeforeClass(alwaysRun = true)
//    public void beforeClass() throws IOException, InterruptedException {
//
//    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() throws IOException, InterruptedException {
        DriverManager.prepareDriver();
        initializePages();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        reopenApp();
        DriverManager.quitDriver();
    }

    public void initializePages() {
        homePage = new HomePage();
        addProductPage = new AddProductPage();
        categoriesListPage = new CategoriesListPage();
        deleteModal = new DeleteModal();
        editNameModal = new EditNameModal();
        myListPage = new MyListPage();
        settingsPage = new SettingsPage();
        sortListModal = new SortListModal();
        addFromMyListPage = new AddFromMyListPage();
        utilities = new Utilities();
    }

//    @AfterClass
//    public void afterClass() {
//
//    }
}
