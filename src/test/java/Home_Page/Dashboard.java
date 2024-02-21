package Home_Page;

import Base.Hooks;
import Login_Page.Login_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Dashboard extends Hooks {
    @Test
    public void home_page() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Input the valid userName and Password
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        //driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");

        WebElement dashboardCheckpoint = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a/span"));
        dashboardCheckpoint.getText();
       //Boolean dashboardSelected = dashboardCheckpoint.isSelected();
        WebElement activeElement = driver.switchTo().activeElement();
        System.out.println(activeElement);
        //Assert.assertEquals(dashboardCheckpoint, "Dashboard");

      //  wait.until(ExpectedConditions.elementToBeSelected(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a/span")));




    }


}
