package com.company;

import org.graphwalker.core.machine.ExecutionContext;

import org.graphwalker.java.annotation.GraphWalker;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@GraphWalker(start = "v_Start")
public class PazaramaLoginLogoutTest extends ExecutionContext implements PazaramaLoginLogout {

    static WebDriver driver;

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    /**
     * Verifies user is logged in successfully by checking
     * whether profile page is accessible
     */
    @Override
    public void v_VerifyHomePageForCustomer() {
        System.out.println("Running: v_VerifyHomePageForCustomer");
        driver.get("https://www.pazarama.com/hesabim/ayarlar/profil");
        String cUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + cUrl);
        Assert.assertTrue("", cUrl.endsWith("/profil"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Triggers logout action
     */
    @Override
    public void e_GoToLogoutPage() {
        driver.get("https://www.pazarama.com/logout");
    }

    /**
     * Navigates to login page again for next test
     */
    @Override
    public void e_GoToLoginPageFromLogoutPage() {
        driver.get("https://www.pazarama.com/giris");
    }

    /**
     * Initiates the environment for the Login Logout  test use case
     */
    @Override
    public void v_Start() {
        System.out.println("Running: v_Start");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\fatih\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * Verifies successfully logout from login state.
     * User is directed to main page after logout.
     */
    @Override
    public void v_VerifyLogoutPage() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Running: v_VerifyLogoutPage");
        String cUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + cUrl);
        Assert.assertTrue("", cUrl.endsWith(".com"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Executes successful login with appropriate login credentials
     * User is directed to main page after logout.
     */
    @Override
    public void e_GoToHomePageForCustomer() {
        System.out.println("Running: e_GoToHomePageForCustomer");
        driver.findElement(By.id("Username")).clear();
        driver.findElement(By.id("Username")).sendKeys("mabelrung@gmail.com");
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys("bounswe550");
        driver.findElement(By.id("submit-button")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Verifies login page is successfully fetched
     */
    @Override
    public void v_LoginPage() {
        System.out.println("Running: v_LoginPage");
        String cUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + cUrl);
        Assert.assertTrue("", cUrl.contains("/Account/Login"));
    }

    /**
     * Navigates to login page
     */
    @Override
    public void e_GoToLoginPage() {
        System.out.println("Running: e_GoToLoginPage");
        driver.get("https://www.pazarama.com/giris");
    }
}
