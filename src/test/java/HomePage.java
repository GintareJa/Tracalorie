import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    static WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //lokatoriai
    private static By addMealInput = (By.id("item-name"));
    private static By addCaloriesInput = (By.id("item-calories"));
    private static By clickAddMealButton = (By.cssSelector(".add-btn.blue.btn.darken-3"));
    private static By clickUpdatePencilButton = (By.cssSelector(".edit-item.fa.fa-pencil"));
    private static By clickUpdateMealButton = (By.cssSelector(".btn.orange.update-btn"));
    private static By clickDeleteMealButton = (By.cssSelector(".btn.delete-btn.red"));
    private static By clickClearAllButton = (By.xpath("/html//nav//ul[@class='right']//a[@href='#']"));


    //    metodai
    public static void addMeal(String meal) {
        driver.findElement(addMealInput).sendKeys(meal);
    }

    public static void addCalories (String calories) {
        driver.findElement(addCaloriesInput).sendKeys(calories);
    }

    public static void addToTotal() {
        driver.findElement(clickAddMealButton).click();
    }

    public static void clickPencilUpdateButton() {
        driver.findElement(clickUpdatePencilButton).click();
    }

    public static void adjustEnteredMeal() {
        driver.findElement(addMealInput).clear();
    }

    public static void adjustEnteredCalories() {
        driver.findElement(addCaloriesInput).clear();
    }

    public static void clickNewUpdateMealButton() {
        driver.findElement(clickUpdateMealButton).click();
    }

    public static void clickDeleteButton() {
        driver.findElement(clickDeleteMealButton).click();
    }

    public static void clickClearButton() {
        driver.findElement(clickClearAllButton).click();
    }



}
