package HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.confighrm;

import java.awt.*;
import java.util.Properties;

public class orangemain {

    public static void main(String[] args) throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "\\E:\\Selenium Files\\chromedriver_win32\\chromedriver.exe\\");
        WebDriver driver = new ChromeDriver();
        Properties prop = confighrm.getProps("data");
        driver.get(prop.getProperty("url"));
        Thread.sleep(4000);
        driver.manage().window().maximize();

        HRMPOM loginmet = new HRMPOM(driver);
        loginmet.Loginhrm();

        //Verification Log In
        String newst = new String(driver.findElement(By.linkText("Dashboard")).getText());
        if (newst.equals("Dashboard")){
            System.out.println("Successfully Signed In");
        }

        HRMPOM assignleave = new HRMPOM(driver);
        assignleave.AssignL();

        //Verification for Assigning leave Ready or not.

        String assSt = new String(driver.findElement(By.linkText("Assign Leave")).getText());
        if (assSt.contains("Assign Leave")){
            System.out.println("You can assign leave now");
        }

        HRMPOM manageuser = new HRMPOM(driver);
        manageuser.Usermanage();

//        String sysus = new String(driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-header > div.oxd-table-filter-header-title > h5")).getText());
//        if (sysus.equals("System Users")){
//           // System.out.println("Search for Users");
//        }
//
//        String empnam = new String(driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.orangehrm-paper-container > div.orangehrm-container > div > div.oxd-table-body > div > div > div:nth-child(4) > div")).getText());
//        if (empnam.contains("Paul")){
//            System.out.println("Search Successfull");
//        }

        String recordfound = new String(driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.orangehrm-paper-container > div:nth-child(2) > div > span")).getText());
        if (recordfound.matches("(0) Records Found")){
            System.out.println("No Record Found");
        }else {
            System.out.println(recordfound + "Record Found");
        }

    }
}
