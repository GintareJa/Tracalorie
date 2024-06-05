import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class TestHomePage extends BaseTest {

    @Test
    public void importItemTest() {
        HomePage homePage = new HomePage(driver);
        String meal = "pizza";
        HomePage.addMeal(meal);
        String calories = ("600");
        HomePage.addCalories(calories);
        HomePage.addToTotal();
        String meal2 = "cola";
        HomePage.addMeal(meal2);
        String calories2 = ("200");
        HomePage.addCalories(calories2);
        HomePage.addToTotal();
        String actualCalories = (driver.findElement(By.cssSelector(".total-calories")).getText());
        Assertions.assertEquals("800", actualCalories, "the number of calories matches");
    }


    @Test
    public void updateItemsTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        String meal = "pizza";
        HomePage.addMeal(meal);
        String calories = ("600");
        HomePage.addCalories(calories);
        HomePage.addToTotal();
        Thread.sleep(1000);
        HomePage.clickPencilUpdateButton();
        HomePage.adjustEnteredMeal();
        String meal2 = "banana";
        HomePage.addMeal(meal2);
        HomePage.adjustEnteredCalories();
        String calories2 = "100";
        HomePage.addCalories(calories2);
        Thread.sleep(1000);
        HomePage.clickNewUpdateMealButton();
        Thread.sleep(1000);
        String caloriesValue = driver.findElement(By.cssSelector("li#item-0 > em")).getText();
        Assertions.assertEquals("100 Calories", caloriesValue, "the number of calories matches");
        String nameValue = driver.findElement(By.cssSelector("li#item-0 > strong")).getText();
        Assertions.assertEquals("banana:", nameValue, "the name is matched");
    }

    @Test
    public void deleteItemsTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        String meal = "pizza";
        HomePage.addMeal(meal);
        String calories = ("600");
        HomePage.addCalories(calories);
        HomePage.addToTotal();
        Thread.sleep(1000);
        HomePage.clickPencilUpdateButton();
        HomePage.clickDeleteButton();
        String mealValue = driver.findElement(By.id("item-name")).getAttribute("value");
        Assertions.assertEquals("", mealValue, "Meal input field is empty");
        String caloriesValue = driver.findElement(By.id("item-calories")).getAttribute("value");
        Assertions.assertEquals("", caloriesValue, "Calories input field is empty");
    }

    @Test
    public void clearAllTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        String meal = "pizza";
        HomePage.addMeal(meal);
        String calories = ("600");
        HomePage.addCalories(calories);
        HomePage.addToTotal();
        Thread.sleep(1000);
        HomePage.clickPencilUpdateButton();
        HomePage.clickClearButton();
        Thread.sleep(1000);
        String totalValue = driver.findElement(By.cssSelector(".total-calories")).getText();
        Assertions.assertEquals("0", totalValue, "deleted successfully");
    }

    @Test
    public void addOnlyMealNegativeTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        String meal = "pizza";
        HomePage.addMeal(meal);
        Thread.sleep(1000);
        HomePage.addToTotal();
        String totalValue = driver.findElement(By.cssSelector(".total-calories")).getText();
        Assertions.assertEquals("0", totalValue, "incomplete text could not be registered");
    }

    @Test
    public void addNumbersOnMealNameInput() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        String meal = "123456";
        HomePage.addMeal(meal);
        Thread.sleep(1000);
        String calories = ("600");
        HomePage.addCalories(calories);
        Thread.sleep(1000);
        HomePage.addToTotal();
        String nameValue = driver.findElement(By.cssSelector("li#item-0 > strong")).getText();
        Assertions.assertEquals("123456:", nameValue, "should not accept input only as a number");
    }

    @Test
    public void addTextOnCaloriesInput() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        String meal = "spaghetti";
        HomePage.addMeal(meal);
        Thread.sleep(1000);
        String calories = ("text");
        HomePage.addCalories(calories);
        Thread.sleep(1000);
        HomePage.addToTotal();
        String totalValue = driver.findElement(By.cssSelector(".total-calories")).getText();
        Assertions.assertEquals("0", totalValue, "should not accept text input ");
    }
}


