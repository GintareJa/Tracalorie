import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class BaseTest {
    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://practice.expandtesting.com/tracalorie/?classId=e83a1e60-d212-4fa4-9e1c-f89284b2328a&assignmentId=bf2480e2-ae85-49e3-bbb4-6fc77a9d30d8&submissionId=c0842822-db51-d0f8-7204-731929a8a45b");

    }

//@AfterEach
//    void teardown(){
//    driver.quit();
//}
}

