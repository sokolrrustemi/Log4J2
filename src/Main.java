import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Main extends BaseDriver {

    @Test(priority = 1)
    public void Start() {

        driver.get("https://www.google.com/");
        WebElement search = driver.findElement(By.id("APjFqb"));
        search.sendKeys("Manuel Xml log4j", Keys.ENTER);

        System.out.println("Hello and welcome!");

        for (int i = 1; i <= 3; i++) {
            System.out.println("i = " + i);
        }
    }
    @Test(priority = 2)
    public void Log4jDeneme(){

        String msg = ". İşleme Başlıyoruz.";
        for (int i = 1; i <= 3; i++) {
            //System.out.println("Messages = " + i+msg);
            logger4j.info("Messages = "+ i+msg);
        }


    }
}