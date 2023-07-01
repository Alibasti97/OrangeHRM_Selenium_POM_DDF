package HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.confighrm;

import java.awt.*;
import java.util.Properties;

public class HRMPOM {

WebDriver driver;

Properties prop = confighrm.getProps("data");

///Login Xpaths
    By username = new By.ByXPath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input");
    By password = new By.ByXPath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input");

    By clicklogin = new  By.ByXPath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");

    By clickassign = new By.ByCssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div:nth-child(3) > div > div.orangehrm-dashboard-widget-body > div > div:nth-child(1) > button");

    By empname = new By.ByCssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div > div > div:nth-child(2) > div > div > input");

     By leatype = new By.ByCssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(2) > div > div:nth-child(1) > div > div:nth-child(2) > div > div");

     By startdate = new By.ByCssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(3) > div > div:nth-child(1) > div > div:nth-child(2) > div > div > input");

     By enddate = new By.ByCssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(3) > div > div:nth-child(2) > div > div:nth-child(2) > div > div > input");

     By partialD = new By.ByCssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(4) > div > div > div > div:nth-child(2) > div > div > div.oxd-select-text-input");

     By comments = new By.ByCssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(5) > div > div > div > div:nth-child(2) > textarea");

     By assignbtn = new By.ByCssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-actions > button");

     By confirmassign = new By.ByCssSelector("#app > div.oxd-overlay.oxd-overlay--flex.oxd-overlay--flex-centered > div > div > div > div.orangehrm-modal-footer > button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-button-margin");
HRMPOM(WebDriver driver){
    this.driver=driver;
}

    public void  Loginhrm() throws InterruptedException {

        // Login Code
        driver.findElement(username).sendKeys(prop.getProperty("Username"));
        Thread.sleep(3000);
        driver.findElement(password).sendKeys(prop.getProperty("Password"));
        Thread.sleep(3000);
        driver.findElement(clicklogin).click();
        Thread.sleep(3000);
    }

        public void AssignL() throws InterruptedException, AWTException {
        //Assinging Leave
            Thread.sleep(3000);
            driver.findElement(clickassign).click();
            Thread.sleep(3000);

            //Choosing Employee Name
            driver.findElement(empname).sendKeys("Ali");
            Thread.sleep(5000);

            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            actions.sendKeys(Keys.ENTER).perform();
            //Choosing Leave Type

            WebElement leavetype=driver.findElement(leatype);
            leavetype.click();
            Thread.sleep(5000);
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            actions.sendKeys(Keys.ENTER).perform();

            //Selecting From Date
            driver.findElement(startdate).sendKeys("2023-07-01");
            Thread.sleep(3000);
            //Selecting End Date
            WebElement datecl=driver.findElement(enddate);
            Thread.sleep(2000);
            datecl.click();
            Thread.sleep(3000);
            datecl.clear();
            Thread.sleep(2000);

            //Choosing Partial Days.
            WebElement partialdays=driver.findElement(partialD);
            partialdays.click();
            Thread.sleep(5000);
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            actions.sendKeys(Keys.ENTER).perform();

            //Entering Comments

            driver.findElement(comments).sendKeys("Hello World!");

            //Clicking Assign

            driver.findElement(assignbtn).click();
            Thread.sleep(3000);

            driver.findElement(confirmassign).click();
        }

}

