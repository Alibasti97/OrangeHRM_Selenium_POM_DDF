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

        HRMPOM adduser = new HRMPOM(driver);
        adduser.adduser();


        
        String verifypass = new String(driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-row.user-password-row > div > div.oxd-grid-item.oxd-grid-item--gutters.user-password-cell > span")).getText());
        if (verifypass.equals("Better")){
            System.out.println("Password is strong enough");
        } else if (verifypass.equals("Weak")) {
            System.out.println("Password is not Strong enough");
        }

    }
}
