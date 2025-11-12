import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ConfigureCustomActionDimensionTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // Implicit wait di 10 secondi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://localhost:8082/");
    }

    @Test
    @DisplayName("Configure Custom Dimension for Visit Dimension")
    public void testConfigureCustomVisitDimension() {
        driver.findElement(By.id("login_form_login")).sendKeys("admin");
        driver.findElement(By.id("login_form_password")).sendKeys("e2eW3Bt3s71nGB3nchM4rK");
        driver.findElement(By.id("login_form_submit")).click();
        driver.findElement(By.id("topmenu-coreadminhome")).click();
        driver.findElement(By.linkText("Measurables")).click();
        driver.findElement(By.linkText("Custom Dimensions")).click();
        driver.findElement(By.cssSelector("#content > div:nth-child(2) > div > div > div:nth-child(1) > div > div:nth-child(3) > div > div > div > div > button")).click();
        driver.findElement(By.id("name")).sendKeys("1");
        WebElement checkbox = driver.findElement(By.id("active"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
        driver.findElement(By.id("0pattern")).sendKeys(" /blog/(.*)/");
        driver.findElement(By.cssSelector("input[value='Create']")).click();
        WebElement message = driver.findElement(By.className("notification-body"));
        assertEquals("Custom Dimension created", message.getText());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
