package lt.techin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    WebDriver driver;

    @BeforeEach
    void setup(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com/form-fields/");
    }

//    @AfterEach
//    void  teardown(){
//        driver.quit();
//    }

}
