package Utility;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {

    public static WebDriver driver;

    public static WebDriverWait wait;

    public static final org.apache.logging.log4j.Logger logger4j = LogManager.getLogger();

    @BeforeClass
    public void baslangicIslemleri() {

        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(-2000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterClass
    public void bitisIslemleri() {

        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod(ITestResult result) {

        //System.out.println("Başladı");
        logger4j.info(" Test Methodu Başladı" );

    }

    @AfterMethod
    public void afterMethod(ITestResult result) {

        //System.out.println("Bitti");
        logger4j.info(result.getName()+" Test Methodu Bitti "+ (result.getStatus() == 1 ? "Passed" : "Fail"));

    }


}
