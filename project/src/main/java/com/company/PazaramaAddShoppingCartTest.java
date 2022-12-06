package com.company;

import org.graphwalker.core.machine.ExecutionContext;

import org.graphwalker.java.annotation.GraphWalker;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

@GraphWalker(start = "v_Start")
public class PazaramaAddShoppingCartTest extends ExecutionContext implements PazaramaAddShoppingCart {

    static WebDriver driver;
    static WebElement search_bar;
    static String SearchKeyword = "Kazak";
    WebElement SelectedItem;

    static String result = String.valueOf(false);

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    /**
     * Send search with the keyword
     */
    @Override
    public void v_WriteItemNameInSearchBar() {
        System.out.println("Running: v_WriteItemNameInSearchBar");
        search_bar = driver.findElement(By.cssSelector("input[placeholder='Ürün, kategori veya marka ara...']"));
        search_bar.sendKeys(SearchKeyword);
    }

    /**
     * Verify that item is successfully added to shopping card
     */
    @Override
    public void v_VerfiyItemIsAddedInShoppingCard() {
        System.out.println("Running: v_VerfiyItemIsAddedInShoppingCard");
        driver.get("https://www.pazarama.com/sepetim");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assert driver.findElement(By.tagName("img")).getAttribute("alt").contains(SearchKeyword);
    }

    /**
     * Add the item to shopping card
     */
    @Override
    public void e_AddItemToShoppingCard() {
        System.out.println("Running: e_AddItemToShoppingCard");
        driver.findElement(By.className("w-52")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * Navigate to one of the searched item's page
     */
    @Override
    public void v_GoToSearchedItem() {
        System.out.println("Running: v_GoToSearchedItem");

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // identify element with partial link text
        SelectedItem =driver.findElement(By.partialLinkText("Kazak"));
        SelectedItem.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initiates the environment for the Add Shopping card test use case
     */
    @Override
    public void v_Start() {
        System.out.println("Running: v_Start");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\fatih\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * Navigate to home page
     */
    @Override
    public void e_GoToHomePage() {
        System.out.println("Running: e_GoToHomePage");
        driver.get("https://www.pazarama.com");
    }

    /**
     * Trigger Search for the item
     */
    @Override
    public void e_ClickSearchButton() {
        System.out.println("Running: e_ClickSearchButton");
        driver.findElement(By.className("svg--search")).click();
    }
}
