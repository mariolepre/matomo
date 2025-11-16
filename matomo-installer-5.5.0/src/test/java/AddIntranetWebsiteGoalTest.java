import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class AddIntranetWebsiteGoalTest {
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
    @DisplayName("Add Intranet Website Goal")
    public void testIntranetWebsiteGoal() {
        driver.findElement(By.id("login_form_login")).sendKeys("admin");
        driver.findElement(By.id("login_form_password")).sendKeys("e2eW3Bt3s71nGB3nchM4rK");
        driver.findElement(By.id("login_form_submit")).click();
        driver.findElement(By.id("topmenu-coreadminhome")).click();
        driver.findElement(By.linkText("Measurables")).click();
        driver.findElement(By.linkText("Goals")).click();
        driver.findElement(By.cssSelector("#root > div.top_controls > div.top_bar_sites_selector.piwikTopControl > div > div > a")).click();
        driver.findElement(By.xpath("//a[@title='Intranet Web Test']")).click();
        driver.findElement(By.id("add-goal")).click();
        driver.findElement(By.id("goal_name")).sendKeys("Make profit");
        driver.findElement(By.id("goal_description")).sendKeys("Improve Company Revenue");
        driver.findElement(By.id("pattern")).sendKeys("/thank-you");
        driver.findElement(By.cssSelector("input[value='Add Goal']")).click();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        WebElement table = driver.findElement(By.cssSelector("table.entityTable"));
        List<WebElement> rows = table.findElements(By.cssSelector("tbody tr"));
        boolean found = false;
        for (WebElement row : rows) {
            String rowText = row.getText();
            if (rowText.contains("Make profit")) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
