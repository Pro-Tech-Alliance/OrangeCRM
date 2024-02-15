package login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    @Test
    public static void falseLogin(){
        WebDriverManager.chromedriver().setup();//setup chrome browser for the test
        WebDriver driver = new ChromeDriver();
        String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(url);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("testctkw");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),url);
driver.quit();
    }


    @Test
    public  static  void trueLogin(){

        WebDriverManager.chromedriver().setup();//setup chrome browser for the test
        WebDriver driver = new ChromeDriver();
        String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(url);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assert.assertNotEquals(driver.getCurrentUrl(),url);
        driver.findElement(By.cssSelector("//input[@placeholder='Search']")).sendKeys("Hello");
driver.quit();
    }
}
