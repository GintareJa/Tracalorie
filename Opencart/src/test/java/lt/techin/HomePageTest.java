package lt.techin;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageTest extends BaseTest {

    @Test
    void searchTest() {
        Homepage homepage = new Homepage(driver);
        homepage.inputName("Jonas");
        homepage.inputEmail("jonas@jonas.lt");
    }


}
