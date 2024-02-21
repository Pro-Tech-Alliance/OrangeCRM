package Login_Page;

import Base.Hooks;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.bouncycastle.oer.its.etsi102941.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Forgot_Password extends Hooks {
    @Test
    public void Forgot_Password_Page_Reset_Button (){


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // WebElement forgotPassElement = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p"));
        WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(10));

        //Checks if Forgot password element is displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p")));

        //driver.findElement()).isDisplayed();

        //checks to ensure Forget password element is clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p")));

        //Gets text content of Forgot password element
        String textDisplayed = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p")).getText();
        Assert.assertEquals(textDisplayed,"Forgot your password?");

        //Locates the Forgot password button and clicks it
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p")).click();
        wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode"));

        //Checks for text content of the heading
        String resetPasswordHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[1]/div/form/h6"))).getText();
        Assert.assertEquals(resetPasswordHeading, "Reset Password");

        //Check for spelling errors on the paragraph
        String textPrompt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[1]/div/form/p/p"))).getText();
        Assert.assertEquals(textPrompt, "Please enter your username to identify your account to reset your password");

        //Check for the correct spelling on Username input title
        String userNameValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div[1]/div/form/div[1]/div/div[1]/label"))).getText();
        Assert.assertEquals(userNameValue, "Username");

        //Check if input fields collect inputs and has placeholders
        WebElement usernameInputField =  driver.findElement(By.name("username"));
        usernameInputField.isEnabled();
        String placeHolderUserName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).getAttribute("placeholder");
        Assert.assertEquals(placeHolderUserName, "Username");
        System.out.println(placeHolderUserName);


        //Checks for the presence of "Reset" button element
        String resetButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[1]/div[1]/div/form/div[2]/button[2]"))).getText();
        Assert.assertEquals(resetButton, "Reset Password");

        //Checks for the presence of Cancel button and if clickable
        String cancelButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div[1]/div/form/div[2]/button[1]"))).getText();
        Assert.assertEquals(cancelButton, "Cancel");


       // driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div/form/div[2]/button[1]")).click();
       // driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //Input username and click on reset button
        usernameInputField.sendKeys("Admin");
       WebElement  resetButtonClick = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/form/div[2]/button[2]"));
       resetButtonClick.click();

       //Checks if reset password sent link loads after clicking on reset
      Boolean urlCheckPoint = wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/auth/sendPasswordReset"));
      System.out.println(urlCheckPoint);



            if (urlCheckPoint) {
                String resetPageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div[1]/div/h6"))).getText();
                Assert.assertEquals(resetPageTitle, "Reset Password link sent successfully");
                System.out.println(resetPageTitle);

                String paragraph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div[1]/div/p[1]/p"))).getText();
                Assert.assertEquals(paragraph1, "A reset password link has been sent to you via email.");
                System.out.println(paragraph1);

                String paragraph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div[1]/div/p[2]/p"))).getText();
                Assert.assertEquals(paragraph2, "You can follow that link and select a new password.");
                System.out.println(paragraph2);

                //String paragraph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[1]/div/p[3]/p[1]/font/font"))).getText();
                //Assert.assertEquals(paragraph3, "Note");
                // System.out.println(paragraph3);

                String paragraph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[1]/div/p[3]/p[2]"))).getText();
                Assert.assertEquals(paragraph4, "If the email does not arrive, please contact your OrangeHRM Administrator.");
                System.out.println(paragraph4);


                String boxColor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[1]/div/p[3]"))).getCssValue("color");
                Assert.assertEquals(boxColor, "rgba(100, 114, 140, 1)");
                System.out.println(boxColor);

                String footerElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div[2]/p[1]"))).getText();
                Assert.assertEquals(footerElement1, "OrangeHRM OS 5.6");

                String footerElement2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div[2]/p[2]"))).getText();
                Assert.assertEquals(footerElement2, "© 2005 - 2024 OrangeHRM, Inc. All rights reserved.");
                System.out.println(footerElement2);


            }else {
                System.out.println("YOUR ORIGINAL CODE DID NOT RUN CORRECTLY");
            }
        }

public void Forgot_Password_Page_Cancel_Button (){
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(10));
    //Checks for the presence of "Cancel" button element
    String cancelButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div[1]/div/form/div[2]/button[1]"))).getText();
    Assert.assertEquals(cancelButton, "Cancel");

    WebElement cancelButtonClicked =  driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div/form/div[2]/button[1]"));
    cancelButtonClicked.click();
    driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");





}







    }

