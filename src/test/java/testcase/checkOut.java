package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class checkOut {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

//        Open Browser
        System.setProperty("webdriver.chrome.driver", "/Users/naufalprayogo/Automation/otoklix/src/test/java/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com");

//        input username dan password
        WebDriverWait profil = new WebDriverWait(driver,30);
        profil.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("user-name"))));
        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("standard_user");

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");

//        click login
        WebElement btnLogin = driver.findElement(By.xpath("//input[@id='login-button']"));
        btnLogin.click();
        System.out.println("Sukses ke link " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Swag Labs");

//        Add to cart
        WebElement btnAddtocart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        btnAddtocart.click();

//        keranjang
        WebElement btnKeranjang = driver.findElement(By.xpath("//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[1]/div[3]/a[1]"));
        btnKeranjang.click();

//        check-out
        WebElement btnCheckout = driver.findElement(By.id("checkout"));
        btnCheckout.click();

//        isi informasi
        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.sendKeys("Bambang");

        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Akbar Sudibyo");

        WebElement kodePos = driver.findElement(By.id("postal-code"));
        kodePos.sendKeys("11111");

//        Button Lanjut
        WebElement btnLanjut = driver.findElement(By.id("continue"));
        btnLanjut.click();

//        Button Finish
        WebElement btnFinish = driver.findElement(By.id("finish"));
        btnFinish.click();

//        Validasi
        WebElement suksesOrder = driver.findElement(By.xpath("//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]"));
        System.out.println("result : " + suksesOrder.getText());
        Assert.assertEquals(suksesOrder.getText().toString(), "THANK YOU FOR YOUR ORDER");

//        close browser
        driver.close();
        driver.quit();

    }
}