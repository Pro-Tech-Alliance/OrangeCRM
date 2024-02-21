package Login_Page;

import Base.Hooks;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Login_Page extends Hooks {



    @Test
    public void login_page_true_test () throws InterruptedException {
        //Implicit wait of 10 seconds to permit every element on the page to load before testing is launched
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Explecit wait of 5 seconds to check and ensure the URL being tested on is the expected URL
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));

         String pageTitle = driver.getTitle();
         System.out.println(pageTitle);




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

            driver.findElement(By.name("password")).isEnabled();
           String placeHolderPassword = driver.findElement(By.name("password")).getAttribute("placeholder");
            Assert.assertEquals(placeHolderPassword, "Password");
            System.out.println(placeHolderPassword);



            //Input the valid userName and Password
            driver.findElement(By.name("username")).sendKeys("Admin");
            driver.findElement(By.name("password")).sendKeys("admin123");

            //Check if Login button is displayed
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).isDisplayed();

            //Check if login button is clickable and click to sign in
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")));
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();


            System.out.println("YOU ARE LOGGED IN");

            /* //For home page
           String currentUrl = driver.getCurrentUrl();
            wait.until(ExpectedConditions.urlMatches("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));
            Assert.assertEquals(currentUrl,"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
            System.out.println("You are Logged in");

             */
        }

    @Test // insert (groups = {"Functional", "sanity"}) here to group your test cases for execution. can be just sanity or functional or both
    public void False_Login_1 (){

        //Wrong Username and Password
        driver.findElement(By.name("username")).sendKeys("Wrong");
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")));
         String checkpoint = driver.getCurrentUrl();
         Assert.assertEquals(checkpoint,"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");






    }
    @Test
    public void False_Login_2 (){

        //Correct Usename but Wrong Password
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")));
        String checkpoint = driver.getCurrentUrl();
        Assert.assertEquals(checkpoint,"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


    }
    @Test
    public void False_Login_3 (){

        //Correct Password but Wrong Username
        driver.findElement(By.name("username")).sendKeys("guest");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")));
        String checkpoint = driver.getCurrentUrl();
        Assert.assertEquals(checkpoint,"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


    }
    @Test
    public void False_Login_4 (){
        WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(5));

        //Both Username and Password are empty
        driver.findElement(By.name("username")).sendKeys("");
        driver.findElement(By.name("password")).sendKeys("");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        //Gets the value of the Url displayed to indicate if still on the login page
        wait.until(ExpectedConditions.urlMatches("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));

        ////Checks if the "Rquired" text will display on not filling out fields
        String requiredFieldText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span"))).getText();
        Assert.assertEquals(requiredFieldText, "Required");

        //Gets username input border radius color to compare with expected
        String usernameBorderColor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).getCssValue("border-color");
        Assert.assertEquals(usernameBorderColor, "rgb(235, 9, 16)");


            //Gets Css value of input fields to check for Password input box border color, in case where fields are empty which is indicated by their red color display
            String passwordBorderColor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("password"))).getCssValue("border-color");
            Assert.assertEquals(passwordBorderColor, "rgb(235, 9, 16)");

            //For error checking purpose
            System.out.println(usernameBorderColor);


    }
    @Test
    public void False_Login_5 (){
        WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(5));

        //If Username if filled correctly and Password field is empty
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        //Gets the value of the Url displayed to indicate if still on the login page
        wait.until(ExpectedConditions.urlMatches("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));

            //Checks if the "Rquired" text will display on not filling out Password field
            String requiredFieldText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span"))).getText();
            Assert.assertEquals(requiredFieldText, "Required");

            //Gets Css value of Password input field to check for its border color if field is empty by a red color display
            String passwordBorderColor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("password"))).getCssValue("border-color");
            Assert.assertEquals(passwordBorderColor, "rgb(235, 9, 16)");

            //For error checking purpose
            System.out.println(passwordBorderColor);





    }
@Test
    public void Footer_Element_text (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));

        String footerElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[3]/div[2]/p[1]"))).getText();
        Assert.assertEquals(footerElement1, "OrangeHRM OS 5.6");

        String footerElement2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[3]/div[2]/p[2]"))).getText();
        Assert.assertEquals(footerElement2, "© 2005 - 2024 OrangeHRM, Inc. All rights reserved.");
        System.out.println(footerElement2);

    }



}
