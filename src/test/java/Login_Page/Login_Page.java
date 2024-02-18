package Login_Page;

import Base.Hooks;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Login_Page extends Hooks {
    @Test
    public void login_page_true_test () throws InterruptedException {
        //Implicit wait of 10 seconds to permit every element on the page to load before testing is launched
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Explecit wait of 5 seconds to check and ensure the URL being tested on is the expected URL
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        boolean checkUrl = wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
        if (checkUrl) {

            //Checks if the Logos are displayed
            driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[1]/img")).isDisplayed();

            //Check for the correct spelling on User name input title
            String userNameValue = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[1]/label")).getText();
            Assert.assertEquals(userNameValue, "Username");

            //Check for the correct Spelling of userPassword
            String userPassword = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[1]/label")).getText();
            Assert.assertEquals(userPassword,"Password");

            //Check if input fields collect inputs and has placeholders
             driver.findElement(By.name("username")).isEnabled();

            String placeHolderUserName = driver.findElement(By.name("username")).getAttribute("placeholder");
            Assert.assertEquals(placeHolderUserName, "Username");
            System.out.println(placeHolderUserName);
            driver.findElement(By.name("username")).isEnabled();

           String placeHolderPassword = driver.findElement(By.name("password")).getAttribute("placeholder");
            Assert.assertEquals(placeHolderPassword, "Password");
            System.out.println(placeHolderPassword);









            //Input the valid userName and Password
            driver.findElement(By.name("username")).sendKeys("Admin");
            driver.findElement(By.name("password")).sendKeys("admin123");

            //
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
           String currentUrl = driver.getCurrentUrl();
            wait.until(ExpectedConditions.urlMatches("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));
            Assert.assertEquals(currentUrl,"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
            System.out.println("You are Logged in");






        }
    }
    /*@Test
    public void Home_Page(){
        driver.findElement(new By.ByXPath("/html/body/div[1]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).isDisplayed();
    }

     */
}
