package com.company;

import org.graphwalker.core.machine.ExecutionContext;

import org.graphwalker.java.annotation.GraphWalker;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@GraphWalker(start = "v_Start")
public class PazaramaFailLoginTest extends ExecutionContext implements PazaramaFailLogin {

    static WebDriver driver;

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    /**
     * Navigates to login page again for next test
     */
    @Override
    public void e_ReturnToLoginPage() {
        System.out.println("Running: e_ReturnToLoginPage");
        driver.get("https://www.pazarama.com/giris");
    }

    /**
     * Tiriggers login with wrong credentials
     */
    @Override
    public void e_TryLoginWithWrongCredential() {
        System.out.println("Running: e_TryLoginWithWrongCredential");
        driver.findElement(By.id("Username")).clear();
        driver.findElement(By.id("Username")).sendKeys("mabelrung@gmail.com");
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys("bounswe550x");
        driver.findElement(By.id("submit-button")).click();
    }

    /**
     * Initiates the environment for the Login Fail test use case
     */
    @Override
    public void v_Start() {
        System.out.println("Running: v_Start");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\fatih\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     *  Verify that login page is opened successfully
     */
    @Override
    public void v_LoginPage() {
        System.out.println("Running: v_LoginPage");
        String cUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + cUrl);
        Assert.assertTrue("", cUrl.contains("/Account/Login"));
    }

    /**
     * Verifies login failed due to credential errors
     */
    @Override
    public void v_VerifyLoginFailed() {
        System.out.println("Running: v_VerifyLoginFailed");
        Assert.assertNotNull(driver.findElement(By.xpath("//*[contains(.,'E-Postanız veya şifreniz hatalıdır')]")));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Navigate to login page
     */
    @Override
    public void e_GoToLoginPage() {
        System.out.println("Running: e_GoToLoginPage");
        driver.get("https://www.pazarama.com/giris");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
