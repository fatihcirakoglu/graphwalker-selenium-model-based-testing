package com.company;

import org.graphwalker.core.machine.ExecutionContext;

import org.graphwalker.java.annotation.GraphWalker;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@GraphWalker(start = "v_Start")
public class PazaramaSearchItemTest extends ExecutionContext implements PazaramaSearchItem {

    static WebDriver driver;
    static WebElement search_bar;
    static String SearchItem = "kazak";

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    /**
     * Write search keyword in search bar
     */
    @Override
    public void v_WriteItemNameInSearchBar() {
        System.out.println("Running: v_WriteItemNameInSearchBar");
        search_bar = driver.findElement(By.cssSelector("input[placeholder='Ürün, kategori veya marka ara...']"));
        search_bar.sendKeys(SearchItem);

    }

    /**
     * Verify search is triggered successfully
     */
    @Override
    public void e_VerifySearchedItem() {
        System.out.println("Running: e_VerifySearchedItem");
        String cUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + cUrl);
        Assert.assertTrue("", cUrl.contains(SearchItem));
    }

    /**
     * Initiates the environment for the Search Item test use case
     */
    @Override
    public void v_Start() {
        System.out.println("Running: v_Start");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\fatih\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * Navigates to home page
     */
    @Override
    public void e_GoToHomePage() {
        System.out.println("Running: e_GoToHomePage");
        driver.get("https://www.pazarama.com");
    }

    /**
     * Verify item is queried successfully and results are shown
     */
    @Override
    public void v_VerifySearch() {
        System.out.println("Running: v_VerifySearch");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(driver.findElement(By.xpath("//*[contains(.,'Kazak')]")));
    }

    /**
     * Trigger search
     */
    @Override
    public void e_ClickSearchButton() {
        System.out.println("Running: e_ClickSearchButton");
        driver.findElement(By.className("svg--search")).click();
    }
}
