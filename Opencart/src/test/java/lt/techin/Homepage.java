package lt.techin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {

    WebDriver driver;

    private By inputName = By.id("name");
    private By inputEmail = By.id("email");


    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputName(String name) {
        driver.findElement(inputName).sendKeys();
    }

    public void inputEmail(String email) {
        driver.findElement(inputEmail).sendKeys();
    }

}
